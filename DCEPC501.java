import java.util.*;
import java.io.*;
import java.math.*;

class DCEPC501 {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		long[] arr = new long[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();

		long[] dp = new long[n + 1];
		Arrays.fill(dp, -1);

		long res = findMax(arr, n, dp, 0);

		System.out.println(res);
	}

	static long findMax(long[] arr, int n, long[] dp, int index) {

		if (index >= n) {
			return 0;
		}

		if (dp[index] != -1)
			return dp[index];

		long a = 0, b = 0, c = 0;

		a = arr[index] + findMax(arr, n, dp, index + 2);
		if (index + 1 < n)
			b = arr[index] + arr[index + 1] + findMax(arr, n, dp, index + 4);
		if (index + 2 < n)
			c = arr[index] + arr[index + 1] + arr[index + 2] + findMax(arr, n, dp, index + 6);

		return dp[index] = Math.max(a, Math.max(b, c));

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