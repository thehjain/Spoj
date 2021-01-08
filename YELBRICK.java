import java.util.*;
import java.io.*;
import java.math.*;

class YELBRICK {

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

		int[][] arr = new int[n][3];

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}

		int hcf = arr[0][0];

		for (int i = 0; i < n; i++) {
			hcf = gcd(hcf, arr[i][0]);
			hcf = gcd(hcf, arr[i][1]);
			hcf = gcd(hcf, arr[i][2]);
		}

		long res = 0;

		for (int i = 0; i < n; i++)
			res += (arr[i][0] / hcf) * (arr[i][1] / hcf) * (arr[i][2] / hcf);

		System.out.println(res);

	}

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