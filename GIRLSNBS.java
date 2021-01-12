import java.util.*;
import java.io.*;
import java.math.*;

class GIRLSNBS {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			int girls = sc.nextInt();
			int boys = sc.nextInt();
			if (girls == -1 && boys == -1)
				break;
			solve(girls, boys);
		}
	}

	static void solve(int girls, int boys) throws IOException {

		if (girls == 0) {
			System.out.println(boys);
			return;
		}
		if (boys == 0) {
			System.out.println(girls);
			return;
		}

		int res = 0;

		if (girls <= boys) {
			girls++;
			res = boys / girls;
			if (boys % girls > 0)
				res++;
		} else {
			boys++;
			res = girls / boys;
			if (girls % boys > 0)
				res++;
		}

		System.out.println(res);
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