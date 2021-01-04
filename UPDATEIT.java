
//Problem solution is available on geeksforgeeks

import java.util.*;
import java.io.*;
import java.math.*;

class UPDATEIT {

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

		int n = sc.nextInt();
		int k = sc.nextInt();

		long[] arr = new long[n];
		long[] diff = new long[n + 1];

		intiatialize(diff, arr);

		for (int i = 0; i < k; i++) {

			int l = sc.nextInt();
			int r = sc.nextInt();
			int x = sc.nextInt();
			update(diff, l, r, x);
		}

		for (int i = 0; i < n; i++) {
			if (i == 0) arr[i] = diff[i];
			else
				arr[i] = diff[i] + arr[i - 1];
		}

		int q = sc.nextInt();

		while (q-- > 0) {
			int index = sc.nextInt();
			System.out.println(arr[index]);
		}

	}

	static void intiatialize(long[] diff, long[] arr) {
		diff[0] = arr[0];
		diff[arr.length] = 0;
		for (int i = 1; i < arr.length; i++)
			diff[i] = arr[i] - arr[i - 1];
	}

	static void update(long[] diff, int l, int r, int x) {
		diff[l] += x;
		diff[r + 1] -= x;
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