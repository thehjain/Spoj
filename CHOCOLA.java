import java.util.*;
import java.io.*;
import java.math.*;

class CHOCOLA {

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


		int n = sc.nextInt() - 1;
		int m = sc.nextInt() - 1;
		int[] x = new int[n];
		int[] y = new int[m];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			y[i] = sc.nextInt();
		}
		int vCut = 1;
		int hCut = 1;
		Arrays.sort(x);
		Arrays.sort(y);
		int i = n - 1;
		int j = m - 1;
		int ans = 0;
		while (i >= 0 && j >= 0) {
			if (x[i] > y[j]) {
				ans += x[i] * vCut;
				hCut++;
				i--;
			} else {
				ans += y[j] * hCut;
				vCut++;
				j--;
			}
		}
		while (i >= 0) {
			ans += x[i] * vCut;
			i--;
		}
		while (j >= 0) {
			ans += y[j] * hCut;
			j--;
		}
		System.out.println(ans);
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