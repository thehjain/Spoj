import java.util.*;
import java.io.*;
import java.math.*;

class DOTAA {

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

		long n = sc.nextLong();
		long m = sc.nextLong();
		long d = sc.nextLong();

		long count = 0;

		for (long i = 0; i < n; i++) {
			long temp = sc.nextLong();
			if (temp > d) {
				if (temp % d == 0)
					count += temp / d - 1;
				else
					count += temp / d;
			}
		}

		if (count >= m)
			System.out.println("YES");
		else
			System.out.println("NO");

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