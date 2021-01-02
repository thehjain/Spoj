
//Here we have given 8*8 chess square board and
//one inital position and target position and we
//have to find the minimum number of steps so that
//knight can reach to its target position.

import java.util.*;
import java.io.*;
import java.math.*;

public class MinimumKnightMoves {

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

		String[] input = sc.nextLine().split(" ");

		int[]start = new int[2];
		int[]end = new int[2];

		start[0] = input[0].charAt(0) - 'a' + 1;
		start[1] = input[0].charAt(1) - '0';
		end[0] = input[1].charAt(0) - 'a' + 1;
		end[1] = input[1].charAt(1) - '0';

		int res = minSteps(start, end, 8);

		System.out.println(res);
	}

	static boolean isSafe(int x, int y, int N) {
		if (x >= 1 && x <= N)
			if (y >= 1 && y <= N)
				return true;
		return false;
	}

	static int minSteps(int[] start, int[] end, int N) {

		int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

		//To store results and backtrack
		Queue<Cell> que = new LinkedList<>();
		que.add(new Cell(start[0], start[1], 0));

		Cell temp;
		int x, y;
		boolean[][] visited = new boolean[9][9];

		visited[start[0]][start[1]] = true;

		while (!que.isEmpty()) {

			temp = que.poll();

			if (temp.x == end[0] && temp.y == end[1])
				return temp.dis;

			for (int i = 0; i < 8; i++) {
				x = temp.x + dx[i];
				y = temp.y + dy[i];

				if (isSafe(x, y, N) && !visited[x][y]) {
					visited[x][y] = true;
					que.add(new Cell(x, y, temp.dis + 1));
				}
			}
		}
		return -1;
	}

	static class Cell {
		int x, y;
		int dis;
		Cell(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
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