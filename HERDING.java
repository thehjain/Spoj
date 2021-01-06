import java.util.*;
import java.io.*;
import java.math.*;

class HERDING {

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

	static int count = 0, last = 0;

	static void solve() throws IOException {

		int n = sc.nextInt();
		int m = sc.nextInt();

		char[][] arr = new char[n][m];
		int[][] visited = new int[n][m];

		for (int[] row : visited)
			Arrays.fill(row, -1);

		// int count = 0;
		// int last=0;

		for (int i = 0; i < n; i++)
			arr[i] = sc.next().toCharArray();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == -1) {
					count = last + 1;
					dfs(arr, visited, i, j);
					if (count > last) last++;
				}
			}
		System.out.println(last);
	}

	static void dfs(char[][] arr, int[][] visited, int i, int j) {

		if (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length) {
			if (visited[i][j] != -1) {
				count = visited[i][j];
				return;
			}
			visited[i][j] = count;
			if (arr[i][j] == 'W') dfs( arr, visited, i, j - 1);
			else if (arr[i][j] == 'E') dfs(arr, visited, i, j + 1);
			else if (arr[i][j] == 'N') dfs(arr, visited, i - 1, j);
			else if (arr[i][j] == 'S') dfs(arr, visited, i + 1, j);
			visited[i][j] = count;
		}
		// return;
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