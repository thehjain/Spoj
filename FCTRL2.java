import java.util.*;
import java.io.*;
import java.math.*;

class FCTRL2 {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	static BigInteger[] arr = new BigInteger[101];

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		solve();
		while (T-- > 0) {
			int n = sc.nextInt();
			System.out.println(arr[n]);
		}
	}

	static void solve() throws IOException {

		BigInteger f = new BigInteger("1");

		arr[0] = BigInteger.ONE;

		for (int i = 1; i <= 100; i++) {
			f = f.multiply(BigInteger.valueOf(i));
			arr[i] = f;
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