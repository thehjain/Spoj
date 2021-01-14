
//Time Limit Exceeding in Java
//Submitted the solution in c++

import java.util.*;
import java.io.*;
import java.math.*;

class LCMSUM {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	static int maxN = 1000003;
	static long[] ans = new long[maxN];
	static long[] phi = new long[maxN];

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		ETF();
		LumSum();
		while (T-- > 0) {
			solve();
		}
	}

	static void solve() throws IOException {

		int n = sc.nextInt();
		long a = ans[n];
		a = (1 + a) * n;
		a /= 2;
		System.out.println(a);

	}

	static void LumSum() {
		for (int i = 1; i < maxN; i++) {
			for (int j = i; j < maxN; j += i)
				ans[j] += (i * phi[i]);
		}
	}

	static void ETF() {
		for (int i = 1; i < maxN; i++)
			phi[i] = i;
		for (int i = 2; i < maxN; i++) {
			if (phi[i] == i) {
				phi[i] = i - 1;
				for (int j = 2 * i; j < maxN; j += i)
					phi[j] = (phi[j] * (i - 1)) / i;
			}
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