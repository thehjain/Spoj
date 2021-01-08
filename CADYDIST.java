import java.util.*;
import java.io.*;
import java.math.*;

class CADYDIST {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			int n = sc.nextInt();
			if (n == 0) break;
			solve(n);
		}
	}

	static void solve(int n) throws IOException {

		long[] students = new long[n];
		long[] candies = new long[n];

		for (int i = 0; i < n; i++)
			students[i] = sc.nextLong();
		for (int i = 0; i < n; i++)
			candies[i] = sc.nextLong();

		Arrays.sort(students);
		Arrays.sort(candies);

		long sum = 0;

		for (int i = 0, j = n - 1; i < n; i++, j--) {
			sum += students[i] * candies[j];
			// sum += candies[i] * students[j];
		}

		System.out.println(sum);

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