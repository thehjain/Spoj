import java.util.*;
import java.io.*;
import java.math.*;

class MICEMAZE {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int exit = sc.nextInt();
		int time = sc.nextInt();
		int m = sc.nextInt();

		int[][] arr = new int[n][n];

		for (int[] row : arr)
			Arrays.fill(row, MAX);

		for (int i = 0; i < n; i++)
			arr[i][i] = 0;

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int dist = sc.nextInt();
			arr[a][b] = dist;
		}

		int res = 0;

		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = arr[i][j];

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dp[i][k] + dp[k][j] < dp[i][j] && dp[i][k] != MAX && dp[k][j] != MAX)
						dp[i][j] = dp[i][k] + dp[k][j];
				}
			}
		}

		// for (int i = 0; i < n; i++) {
		// 	for (int j = 0; j < n; j++) {
		// 		if (dp[i][j] == MAX)
		// 			System.out.print("N ");
		// 		else
		// 			System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		for (int i = 0; i < n; i++)
			if (dp[i][exit - 1] <= time)
				res++;

		System.out.println(res);

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