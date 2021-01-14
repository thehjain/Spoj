import java.util.*;
import java.io.*;
import java.math.*;

class MARTIAN {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;
			solve(n, m);
		}
	}

	static void solve(int n, int m) throws IOException {

		int[][] blog = new int[n][m];
		int[][] yen = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				yen[i][j] = sc.nextInt();
				if (j > 0)
					yen[i][j] += yen[i][j - 1];
			}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				blog[i][j] = sc.nextInt();
				if (i > 0)
					blog[i][j] += blog[i - 1][j];
			}

		int[][] dp = new int[n + 1][m + 1];

		for (int[] row : dp)
			Arrays.fill(row, -1);

		int res = solveUtil(yen, blog, n, m, dp);

		System.out.println(res);
	}

	static int solveUtil(int[][] yen, int[][] blog, int n, int m, int[][] dp) {

		if (n == 0 || m == 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[n][m];

		int temp1 = yen[n - 1][m - 1] + solveUtil(yen, blog, n - 1, m, dp);
		int temp2 = blog[n - 1][m - 1] + solveUtil(yen, blog, n, m - 1, dp);

		return dp[n][m] = Math.max(temp1, temp2);

	}

	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}