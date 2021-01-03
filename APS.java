
import java.util.*;
import java.io.*;
import java.math.*;

class APS {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	static long[] A = new long[10000009];
	static int[] F = new int[10000009];

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		// Arrays.fill(A,0);
		// Arrays.fill(F,0);
		sieve();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		if (n == 0 || n == 1) {
			System.out.println(0);
			return;
		}

		System.out.println(A[n]);
	}

	static void sieve() {
		for (int i = 2; i <= 10000000; i++) {
			if (F[i] == 0) {
				for (int j = i + i; j <= 10000000; j += i) {
					if (F[j] == 0) {
						F[j] = i;
					}
				}
				A[i] = A[i - 1] + i;
			} else
				A[i] = A[i - 1] + F[i];
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