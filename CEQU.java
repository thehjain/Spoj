import java.util.*;
import java.io.*;
import java.math.*;

class CEQU {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();
	static int i;

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (c % gcd(a, b) != 0)
				System.out.println("Case " + i + ":" + "No");
			else
				System.out.println("Case " + i + ":" + "Yes");
		}

	}

	// static void solve() throws IOException {


	// }

	static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
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