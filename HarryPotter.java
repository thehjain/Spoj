
//Harry Potter and the Forbidden Forest

import java.util.*;
import java.io.*;
import java.math.*;

class HarryPotter {

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

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		char[][] arr = new char[N][M];

		for (int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();

		while (K-- > 0) {

			int x = sc.nextInt();
			int y = sc.nextInt();

			Queue<Cell> que = new LinkedList<>();

			que.add(new Cell(x, y));
			Cell temp;
			int res = 0;

			while (!que.isEmpty()) {
				temp = que.poll();
				x = temp.x;
				y = temp.y;
				if (arr[x - 1][y - 1] == '$')
					continue;
				arr[x - 1][y - 1] = '$';
				if (isSafe(x - 1, y, N, M) && arr[x - 2][y - 1] == '.')
					que.add(new Cell(x - 1, y));
				if (isSafe(x, y - 1, N, M) && arr[x - 1][y - 2] == '.')
					que.add(new Cell(x, y - 1));
				if (isSafe(x + 1, y, N, M) && arr[x][y - 1] == '.')
					que.add(new Cell(x + 1, y));
				if (isSafe(x, y + 1, N, M) && arr[x - 1][y] == '.')
					que.add(new Cell(x, y + 1));
				if (isSafe(x - 1, y, N, M) && arr[x - 2][y - 1] == '*')
					res++;
				if (isSafe(x, y - 1, N, M) && arr[x - 1][y - 2] == '*')
					res++;
				if (isSafe(x + 1, y, N, M) && arr[x][y - 1] == '*')
					res++;
				if (isSafe(x, y + 1, N, M) && arr[x - 1][y] == '*')
					res++;
			}
			System.out.println(res);
		}
	}

	static boolean isSafe(int x, int y, int N, int M) {
		if (x >= 1 && x <= N && y >= 1 && y <= M)
			return true;
		return false;
	}

	static class Cell {
		int x, y;
		Cell(int x, int y) {
			this.x = x;
			this.y = y;
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