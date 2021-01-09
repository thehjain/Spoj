import java.util.*;
import java.io.*;
import java.math.*;

class HONDA {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	static int index = 1;
	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve();
			index++;
		}
	}

	static void solve() throws IOException {

		double hx = sc.nextDouble();
		double hy = sc.nextDouble();
		double kx = sc.nextDouble();
		double ky = sc.nextDouble();

		double diff = Math.sqrt(Math.pow(hx + kx, 2) + Math.pow(hy + ky, 2));

		diff *= 1000000;

		diff = Math.round(diff);

		System.out.println("Case " + index + ": " + diff / 1000000);

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