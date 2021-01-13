import java.util.*;
import java.io.*;
import java.math.*;

class ADFRUITS {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (sc.hasNext()) {
			String a = sc.next();
			String b = sc.next();
			solve(a, b);
		}
	}

	static void solve(String a, String b) throws IOException {

		String res = lcs(a, b);

		System.out.println(res);

	}

	static String lcs(String a, String b) {

		int m = a.length();
		int n = b.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int index = dp[m][n];

		String str = "";

		int i = m, j = n;

		while (i > 0 && j > 0) {

			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				str += a.charAt(i - 1);
				i--; j--;
				index--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				str += b.charAt(j - 1);
				j--;
				index--;
			} else {
				str += a.charAt(i - 1);
				i--;
				index--;
			}
		}

		while (i > 0) {
			str += a.charAt(i - 1);
			i--;
			index--;
		}
		while (j > 0) {
			str += b.charAt(j - 1);
			j--;
			index--;
		}

		str = reverse(str);
		return str;

	}

	static String reverse(String s) {

		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();

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