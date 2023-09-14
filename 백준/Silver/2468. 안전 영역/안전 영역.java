import java.util.Scanner;

public class Main {
	public static int N;
	public static int max = 0, ans = 0;
	public static int[][] area;
	public static boolean[][] visited;

	// 상하좌우 탐색
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 행과 열의 개수
		area = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				area[i][j] = sc.nextInt();
				if (max < area[i][j])
					max = area[i][j];
			}
		} // 입력받기 끝

		for (int height = 0; height <= max; height++) {
			visited = new boolean[N][N];
			int safe = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && area[i][j] > height) {
						DFS(i, j, height);
						safe++;
					}
				}
			}

			if (ans < safe)
				ans = safe;
		}

		System.out.println(ans);

	} // main

	public static void DFS(int r, int c, int min) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (!visited[nr][nc] && area[nr][nc] > min) {
					visited[nr][nc] = true;
					DFS(nr, nc, min);
				}
			}
		}
	}
} // class
