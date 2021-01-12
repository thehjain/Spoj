import java.util.*;
import java.io.*;
import java.math.*;

class SUMFOUR {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		// int T = sc.nextInt();
		// while (T-- > 0) {
		solve();
		// }
	}

	static void solve() throws IOException {

		int n = sc.nextInt();

		long[] A = new long[n];
		long[] B = new long[n];
		long[] C = new long[n];
		long[] D = new long[n];

		for (int i = 0; i < n; i++) {
			A[i] = sc.nextLong();
			B[i] = sc.nextLong();
			C[i] = sc.nextLong();
			D[i] = sc.nextLong();
		}

		// long[] arr = new long[10000001];
		// long[] brr = new long[10000001];

		ArrayList<Long> arr = new ArrayList<>();
		ArrayList<Long> brr = new ArrayList<>();

		// int index = 0;
		for (long a : A)
			for (long b : B)
				arr.add(a + b);

		// index = 0;

		for (long c : C)
			for (long d : D)
				brr.add((-1) * (c + d));

		long[] ar = new long[arr.size()];
		long[] br = new long[brr.size()];

		int index = 0;

		for (long ele : arr)
			ar[index++] = ele;
		index = 0;
		for (long ele : brr)
			br[index++] = ele;

		Arrays.sort(ar);
		Arrays.sort(br);

		long res = 0;

		// for (int i = 0; i < n * n - n; i++)
		// 	System.out.print(ar[i] + " ");
		// System.out.println();
		// for (int i = 0; i < n * n - n; i++)
		// 	System.out.print(br[i] + " ");
		// System.out.println();

		for (int i = 0; i < index;) {
			int size1 = 0;
			long temp = br[i];
			while (i < index && br[i] == temp) {
				size1++;
				i++;
			}
			int size2 = binarySearch(temp, index, ar);
			res += size2 * size1;
			// System.out.println(size2);
		}

		System.out.println(res);

	}

	static int binarySearch(long val, int index, long[] arr) {
		int size = 0;
		int temp = 0, low = 0, high = index - 1;
		int mid;
		while (low <= high) {
			mid = (high + low) / 2;
			if (arr[mid] == val) {
				temp = mid - 1;
				while (mid < index && arr[mid] == val) {
					size++;
					mid++;
				}
				while (temp >= 0 && arr[temp] == val) {
					size++;
					temp--;
				}
				return size;
			} else if (arr[mid] > val) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return 0;
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