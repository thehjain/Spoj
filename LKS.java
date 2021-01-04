import java.util.*;
import java.io.*;
import java.math.*;

class LKS {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	// static FastScanner sc = new FastScanner();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// static int[] val

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		String[] input = br.readLine().trim().split(" ");

		int K = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);

		int[] val = new int[N];
		int[] weight = new int[N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			val[i] = Integer.parseInt(temp[0]);
			weight[i] = Integer.parseInt(temp[1]);
		}

		// int[][] dp = new int[K + 1][N + 1];

		// for (int[] row : dp)
		// 	Arrays.fill(row, -1);

		int res = KnapSack(val, weight, N, K);

		System.out.println(res);
	}

	static int KnapSack(int val[], int wt[], int n, int W) {
		// array to store final result
		//dp[i] stores the profit with KnapSack capacity "i"
		int []dp = new int[W + 1];

		//initially profit with 0 to W KnapSack capacity is 0
		Arrays.fill(dp, 0);

		// iterate through all items
		for (int i = 0; i < n; i++)

			//traverse dp array from right to left
			for (int j = W; j >= wt[i]; j--)
				dp[j] = Math.max(dp[j] , val[i] + dp[j - wt[i]]);

		/*above line finds out maximum of dp[j](excluding ith element value)
		and val[i] + dp[j-wt[i]] (including ith element value and the
		profit with "KnapSack capacity - ith element weight") */
		return dp[W];
	}


	// static class FastScanner {
	// 	public BufferedReader reader;
	// 	public StringTokenizer tokenizer;
	// 	public FastScanner() {
	// 		reader = new BufferedReader(new InputStreamReader(System.in), 32768);
	// 		tokenizer = null;
	// 	}
	// 	public String next() {
	// 		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	// 			try {
	// 				tokenizer = new StringTokenizer(reader.readLine());
	// 			} catch (IOException e) {
	// 				throw new RuntimeException(e);
	// 			}
	// 		}
	// 		return tokenizer.nextToken();
	// 	}
	// 	public int nextInt() {
	// 		return Integer.parseInt(next());
	// 	}
	// 	public long nextLong() {
	// 		return Long.parseLong(next());
	// 	}
	// 	public double nextDouble() {
	// 		return Double.parseDouble(next());
	// 	}
	// 	public String nextLine() {
	// 		try {
	// 			return reader.readLine();
	// 		} catch (IOException e) {
	// 			throw new RuntimeException(e);
	// 		}
	// 	}
	// }

}