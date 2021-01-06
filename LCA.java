import java.util.*;
import java.io.*;
import java.math.*;

class LCA {

	private static int MAX = Integer.MAX_VALUE;
	private static int MIN = Integer.MIN_VALUE;
	private static int MOD = 1000000007;
	static FastScanner sc = new FastScanner();

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		int index = 1;
		while (T-- > 0) {
			solve(index++);
		}
	}

	static int[] layer = new int[1001];
	static int[] parent = new int[1001];
	static boolean[] visited = new boolean[1001];
	static boolean[] notRoot = new boolean[1001];

	static void solve(int index) throws IOException {

		int n = sc.nextInt();

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		for (int i = 0; i < n; i++)
			arr.add(new ArrayList<>());

		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			layer[i] = 0;
			parent[i] = -1;
			visited[i] = false;
			for (int j = 0; j < m; j++) {
				int temp = sc.nextInt() - 1;
				arr.get(i).add(temp);
				notRoot[temp] = true;
			}
		}

		int rootNode = 0;

		for (int i = 0; i < n; i++) {
			if (!notRoot[i]) {
				rootNode = i;
				break;
			}
		}

		bfs(rootNode, arr);

		int q = sc.nextInt();

		System.out.println("Case " + index + ":");

		for (int i = 0; i < q; i++) {

			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			System.out.println(findLCA(u, v, arr) + 1);
		}
	}

	static int findLCA(int a, int b, ArrayList<ArrayList<Integer>> arr) {
		int node1, node2;
		if (layer[a] > layer[b]) {
			node1 = a;
			node2 = b;
		} else {
			node1 = b;
			node2 = a;
		}
		while (layer[node1] > layer[node2]) {
			node1 = parent[node1];
		}
		while (node1 != node2) {
			node1 = parent[node1];
			node2 = parent[node2];
		}
		return node1;
	}

	static void bfs(int rootNode, ArrayList<ArrayList<Integer>> arr) {
		visited[rootNode] = true;
		layer[rootNode] = 0;
		Queue<Integer> que = new LinkedList<>();
		que.add(rootNode);
		while (!que.isEmpty()) {
			int curr = que.poll();
			for (int i = 0; i < arr.get(curr).size(); i++) {
				if (!visited[arr.get(curr).get(i)]) {
					visited[arr.get(curr).get(i)] = true;
					layer[arr.get(curr).get(i)] = layer[curr] + 1;
					parent[arr.get(curr).get(i)] = curr;
					que.add(arr.get(curr).get(i));
				}
			}
		}
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