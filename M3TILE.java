import java.util.*;
import java.io.*;
import java.math.*;

class M3TILE {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			int n = sc.nextInt();
			if (n == -1)
				break;
			solve(n);
		}
	}

	static void solve(int n) throws IOException {

		// if(n==0 || n==1 || n%2==1){
		// 	System.out.println(0);
		// 	return;
		// }

		if (n == 0) {
			System.out.println(1);
			return;
		}

		long[] A = new long[n + 1];
		long[] B = new long[n + 1];

		//Base Cases
		A[0] = 1; A[1] = 0;
		B[0] = 0; B[1] = 1;

		for (int i = 2; i <= n; i++) {
			A[i] = A[i - 2] + 2 * (B[i - 1]);
			B[i] = A[i - 1] + B[i - 2];
		}
		System.out.println(A[n]);
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