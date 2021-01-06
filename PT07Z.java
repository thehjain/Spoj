import java.util.*;
import java.io.*;
import java.math.*;

class PT07Z {

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

	static int maxNode, maxDist;

	static void solve() throws IOException {

		int n = sc.nextInt();

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		for (int i = 0; i < n; i++)
			arr.add(new ArrayList<>());

		for (int i = 0; i < n - 1; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			addEdge(u, v, arr);
		}

		boolean[] visited = new boolean[n];
		visited[0] = true;

		maxDist = 0;
		maxNode = 0;

		dfs(arr, visited, 0, 0);

		maxDist = 0;
		Arrays.fill(visited, false);

		dfs(arr, visited, maxNode, 0);

		System.out.println(maxDist);
	}

	static void dfs(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int u, int d) {
		visited[u] = true;
		if (d > maxDist) {
			maxDist = d;
			maxNode = u;
		}
		for (int child : arr.get(u))
			if (!visited[child])
				dfs(arr, visited, child, d + 1);
	}

	static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> arr) {
		arr.get(u).add(v);
		arr.get(v).add(u);
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