import java.util.*;
import java.io.*;
import java.math.*;

class ACMAKER {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			String s = sc.next();
			if (s.equals("0")) break;
			solve(s);
		}
	}

	static void solve(String s) throws IOException {

		int n = s.length();

		int[] dp = new int[n + 1];

		dp[0] = dp[1] = 1;

		if (s.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		for (int i = 2; i <= n; i++) {
			dp[i] = 0;
			if (s.charAt(i - 1) > '0')
				dp[i] = dp[i - 1];
			if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')
				dp[i] += dp[i - 2];
		}

		System.out.println(dp[n]);

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