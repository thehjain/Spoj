import java.util.*;
import java.io.*;
import java.math.*;

class INS14C {

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

		char[] arr = sc.next().toCharArray();

		ArrayList<Integer> zero = new ArrayList<>();
		ArrayList<Integer> one = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (arr[i] == 48)
				zero.add(i);
			else
				one.add(i);
		}

		int count = 1;

		for (int i = 0, j = 0; count <= n - k; count++) {

			if ((count & 1) == 1) {
				if (i < one.size())
					arr[one.get(i++)] = 50;
				else
					arr[zero.get(j++)] = 50;
			} else {
				if (j < zero.size())
					arr[zero.get(j++)] = 50;
				else
					arr[one.get(i++)] = 50;
			}

		}

		for (int i = 0; i < n; i++)
			if (arr[i] != 50)
				System.out.print(arr[i]);

		System.out.println();

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