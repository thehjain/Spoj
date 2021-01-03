

import java.util.*;
import java.io.*;
import java.math.*;

class PARTY {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			int budget = sc.nextInt();
			int n = sc.nextInt();
			if (budget == 0 && n == 0)
				break;
			solve(budget, n);
		}
	}

	static void solve(int budget, int n) throws IOException {

		int[] fun = new int[n];
		int[] cost = new int[n];
		for (int i = 0; i < n; i++) {
			cost[i] = sc.nextInt();
			fun[i] = sc.nextInt();
		}

		int[][] dp = new int[n + 1][budget + 1];

		int[] res = solveUtil(cost, fun, n, budget, dp);

		System.out.println(res[1] + " " + res[0]);
	}

	static int[] solveUtil(int[] wt, int[] val, int n, int budget, int[][] K) {

		int res = 0;
		int weight = MAX;

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= budget; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w]
					    = Math.max(val[i - 1]
					               + K[i - 1][w - wt[i - 1]],
					               K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];

				if (K[i][w] > res) {
					res = K[i][w];
					weight = w;
				} else if (K[i][w] == res)
					weight = Math.min(weight, w);

			}
		}
		return new int[] {K[n][budget], weight};
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