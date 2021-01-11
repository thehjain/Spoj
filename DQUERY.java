


//This problem is solved using Mo's Algorithm


import java.util.*;
import java.io.*;
import java.math.*;

class Query {
	int L;
	int R;
	int res;
	Query(int L, int R) {
		this.L = L;
		this.R = R;
	}
}

class DQUERY {

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

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int m = sc.nextInt();

		int block = (int)Math.sqrt(n);

		int[] freq = new int[1000001];

		ArrayList<Query> queries = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			queries.add(new Query(sc.nextInt() - 1, sc.nextInt() - 1));
		}

		// for (Query ele : queries) {
		// 	System.out.println(ele.L + " " + ele.R);
		// }

		HashMap<Query, Integer> map = new HashMap<>();
		ArrayList<Query> temp = new ArrayList<>(queries);

		Collections.sort(queries, new Comparator<Query>() {
			public int compare(Query x, Query y) {
				if (x.L / block != y.L / block)
					return (x.L < y.L) ? -1 : 1;
				return (x.R < y.R) ? -1 : 1;
			}
		});

		// for (Query ele : queries)
		// 	System.out.println(ele.L + " " + ele.R);

		int currL = queries.get(0).L, currR = queries.get(0).R;
		int res = 0;

		for (int i = currL; i <= currR; i++) {
			freq[arr[i]]++;
			// System.out.println("hello" + arr[i]);
			if (freq[arr[i]] == 1)
				res++;
			map.put(queries.get(0), res);
		}

		// System.out.println(res);

		for (int i = 1; i < m; i++) {

			int L = queries.get(i).L;
			int R = queries.get(i).R;

			// System.out.println(L + " " + R);

			// for (int ele : arr)
			// 	System.out.print("hello " + freq[ele]);
			// System.out.println();

			while (currL < L) {
				freq[arr[currL]]--;
				if (freq[arr[currL]] == 0)
					res -= 1;
				currL++;
			}
			while (currL > L) {
				currL--;
				freq[arr[currL]]++;
				if (freq[arr[currL]] == 1)
					res++;
			}
			while (currR <  R ) {
				currR++;
				freq[arr[currR]]++;
				if (freq[arr[currR]] == 1)
					res++;

			}
			while (currR > R ) {
				freq[arr[currR]]--;
				if (freq[arr[currR]] == 0)
					res--;
				currR--;
			}
			currR = R;
			currL = L;
			// System.out.println(currL + " " + currR);
			map.put(queries.get(i), res);
		}

		for (Query ele : temp)
			System.out.println(map.get(ele));

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