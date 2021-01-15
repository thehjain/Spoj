import java.util.*;
import java.io.*;
import java.math.*;

class BALLOT {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		while (true) {
			int no_of_cities = sc.nextInt();
			int no_of_ballots = sc.nextInt();
			if (no_of_ballots == -1 && no_of_cities == -1)
				break;
			solve(no_of_cities, no_of_ballots);
		}
	}

	static void solve(int no_of_cities, int no_of_ballots) throws IOException {

		long[] arr = new long[no_of_cities];

		long max = MIN;

		for (int i = 0; i < no_of_cities; i++) {
			arr[i] = sc.nextLong();
			max = Math.max(max, arr[i]);
		}

		long res = binarySearch(no_of_cities, no_of_ballots, max, arr);

		System.out.println(res);
	}

	static long distribution(long mid, int no_of_cities, long[] arr) {
		int i, res = 0;
		for (i = 0; i < no_of_cities; i++) {
			if (arr[i] > mid) {
				res += arr[i] / mid;
				if (arr[i] % mid != 0)
					res++;
			} else
				res++;
		}
		return res;
	}

	static long binarySearch(int no_of_cities, int no_of_ballots, long high, long[] arr) {

		long low = 1, mid, ballotsDistributed;
		while (low < high) {
			mid = (low + high) / 2;
			ballotsDistributed = distribution(mid, no_of_cities, arr);
			if (ballotsDistributed <= no_of_ballots)
				high = mid;
			else
				low = mid + 1;
		}
		return low;
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