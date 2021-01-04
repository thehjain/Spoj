import java.util.*;
import java.io.*;
import java.math.*;

class MINVEST {

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

		int amount = sc.nextInt();
		int years = sc.nextInt();

		int n = sc.nextInt();

		int[] weight = new int[n];
		int[] val = new int[n];

		for (int i = 0; i < n; i++) {
			weight[i] = sc.nextInt() / 1000;
			val[i] = sc.nextInt();
		}

		// int interest = 0;



		for (int i = 0; i < years; i++) {

			int tempAmount = amount / 1000;
			int[][] dp = new int[tempAmount + 1][n + 1];
			for (int[] row : dp)
				Arrays.fill(row, -1);
			int interest =  knapSack(val, weight, tempAmount, n, dp);
			tempAmount *= 1000;
			amount += interest;
			// System.out.println("amount" + amount);
		}
		System.out.println(amount);
	}


	static int knapSack(int[] val, int[] weight, int k, int n, int[][] dp) {

		if (k == 0 || n == 0) return 0;

		if (dp[k][n] != -1) return dp[k][n];

		if (weight[n - 1] > k) {
			return dp[k][n] = knapSack(val, weight, k, n - 1, dp);
		} else {
			return dp[k][n] = Math.max(val[n - 1] + knapSack(val, weight, k - weight[n - 1], n, dp),
			                           knapSack(val, weight, k, n - 1, dp)) ;
		}
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