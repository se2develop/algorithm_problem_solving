import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, cntO, cntX;
	public static boolean flag;
	public static char[][] grid;
	public static boolean[][] visited;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 그리드 크기
		N = sc.nextInt();

		grid = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				grid[i][j] = str.charAt(j);
			}
		} // 입력받기 끝

		// 적록색약이 아닌 사람이 보는 구역 수
		cntX = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					BFS1(i, j);
					cntX++;
				}
			}
		}

		// 적록색약인 사람이 보는 구역
		cntO = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					BFS2(i, j);
					cntO++;
				}
			}
		}

		System.out.print(cntX + " " + cntO);
	} // main

	public static void BFS1(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			char color = grid[i][j];

			for (int idx = 0; idx < 4; idx++) {
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];

				// 그리드 경계를 벗어나지 않고
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					// 적록 색약 아닌 경우
					if (!visited[nr][nc] && grid[nr][nc] == color) {
						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
		}
	} // BFS1

	public static void BFS2(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			char color = grid[i][j];

			for (int idx = 0; idx < 4; idx++) {
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];

				// 그리드 경계를 벗어나지 않고
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					// 파랑색은 그냥 하나의 구역으로 구분 가능
					if (color == 'B') {
						if (!visited[nr][nc] && grid[nr][nc] == 'B') {
							queue.add(new int[] { nr, nc });
							visited[nr][nc] = true;
						}
					}
					// 빨강 초록은 서로 붙어있으면 같은 구역으로 인식
					else {
						if (!visited[nr][nc] && (grid[nr][nc] == 'G' || grid[nr][nc] == 'R')) {
							queue.add(new int[] { nr, nc });
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
	} // BFS2

} // class