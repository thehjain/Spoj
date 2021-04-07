import java.util.*;
import java.io.*;
import java.math.*;

class ABA12C {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		int sum = sc.nextInt();

		flag = false;

		int[] prices = new int[sum + 1];
		int[] quant = new int[sum + 1];

		for (int i = 1; i <= sum; i++) {
			prices[i] = sc.nextInt();
			quant[i] = i;
		}

		int[][] dp = new int[sum + 1][sum + 1];

		for (int[] row : dp)
			Arrays.fill(row, -1);

		int res = findMin(prices, quant, sum, sum, dp);

		if (!flag) {
			System.out.println(-1);
			return;
		}

		System.out.println(res);

	}

	static int findMin(int[] prices, int[] quant, int n, int sum, int[][] dp) {

		if (sum == 0) {
			flag = true;
			return 0;
		}

		if (n == 0 && sum != 0) {
			return Integer.MAX_VALUE;
		}

		if (dp[n][sum] != -1)
			return dp[n][sum];

		if (prices[n] == -1) {
			return dp[n][sum] = findMin(prices, quant, n - 1, sum, dp);
		}

		if (n <= sum) {
			return dp[n][sum] = Math.min(findMin(prices, quant, n, sum - n, dp) + prices[n],
			                             findMin(prices, quant, n - 1, sum, dp));
		} else
			return dp[n][sum] = findMin(prices, quant, n - 1, sum, dp);


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