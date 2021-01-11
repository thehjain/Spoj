import java.util.*;
import java.io.*;
import java.math.*;

class Pos {
	int x, y;
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class KOZE {

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

	static int sheeps = 0, wolves = 0;

	static void solve() throws IOException {

		int n = sc.nextInt();
		int m = sc.nextInt();

		char[][] arr = new char[n][m];

		for (int i = 0; i < n; i++)
			arr[i] = sc.next().toCharArray();

		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (!visited[i][j] && arr[i][j] != '#') {
					Pos pos = new Pos(i, j);
					bfs(pos, arr, visited);
				}

			}
		}
		System.out.println(sheeps + " " + wolves);
	}

	static void bfs(Pos pos, char[][] arr, boolean[][] visited) {

		Queue<Pos> que = new LinkedList<>();

		Pos temp;

		int flag = 0;
		que.add(new Pos(pos.x, pos.y));

		int countSheeps = 0, countWolves = 0;

		while (!que.isEmpty()) {

			temp = que.poll();

			int x = temp.x;
			int y = temp.y;

			if (!visited[x][y]) {

				visited[x][y] = true;

				if (arr[x][y] == 'k')
					countSheeps++;
				else if (arr[x][y] == 'v')
					countWolves++;
				if (x == 0 || y == 0 || x == arr.length - 1 || y == arr[0].length - 1)
					flag = 1;
				if ((x < arr.length - 1) && (arr[x + 1][y] != '#'))	que.add(new Pos(x + 1, y));
				if ((x > 0) && (arr[x - 1][y] != '#'))	que.add(new Pos(x - 1, y));
				if ((y < arr[0].length - 1) && (arr[x][y + 1] != '#'))	que.add(new Pos(x, y + 1));
				if ((y > 0) && (arr[x][y - 1] != '#'))	que.add(new Pos(x, y - 1));

			}

		}

		if (flag == 0) {
			if (countSheeps > countWolves)
				sheeps += countSheeps;
			else
				wolves += countWolves;
		} else {
			sheeps += countSheeps;
			wolves += countWolves;
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