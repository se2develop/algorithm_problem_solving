import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int M, N, K;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int[][] farm;
	public static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt(); // 배추밭의 가로길이
			N = sc.nextInt(); // 배추밭의 세로길이
			K = sc.nextInt(); // 심어져 있는 배추의 수

			farm = new int[M][N];
			visited = new boolean[M][N];
			// 배추가 있는 곳의 값 1로 변경
			for (int i = 0; i < K; i++) {
				farm[sc.nextInt()][sc.nextInt()] = 1;
			}

			int cnt = 0; // 필요한 배추흰지렁이의 마리 수
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (farm[i][j] == 1 && !visited[i][j]) {
						BFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		} // tc for문

	} // main

	public static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		// 시작정점 큐에 넣고 방문정보 기록
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int idx = 0; idx < 4; idx++) {
				// 상하좌우 탐색
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];

				// 배추밭 경계를 넘어가지 않고
				if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
					// 배추가 있고, 방문하지 않았으면
					if (farm[nr][nc] == 1 && !visited[nr][nc]) {
						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}

		}
	} // BFS
} // class