import java.util.*;
import java.io.*;
import java.math.*;

class TRT {

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

	// static int day = 1;

	static void solve() throws IOException {

		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		// i
		long[][] dp = new long[n + 1][n + 1];

		for (long[] row : dp)
			Arrays.fill(row, -1);

		long res = findMax(arr, 0, n - 1, 1, dp);

		System.out.println(res);

	}

	static long findMax(int[] arr, int start, int end, int age, long[][] dp) {

		if (start == end)
			return age * arr[start];

		if (dp[start][end] != -1)
			return dp[start][end];

		// System.out.println("hello");

		return dp[start][end] = Math.max(arr[start] * age + findMax(arr, start + 1, end, age + 1, dp),
		                                 arr[end] * age + findMax(arr, start, end - 1, age + 1, dp));

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