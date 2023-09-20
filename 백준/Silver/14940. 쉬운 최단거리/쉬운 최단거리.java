import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int n, m;
	public static boolean[][] visited;
	public static int[][] map, dist;
	// 상하좌우 탐색
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 지도 세로의 크기
		m = sc.nextInt(); // 지도 가로의 크기
		map = new int[n][m]; // 지도 배열
		visited = new boolean[n][m]; // 방문 배열
		dist = new int[n][m]; // 거리 배열

		int sI = 0, sJ = 0; // 목표지점 좌표
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				// 2 시작점
				if (map[i][j] == 2) {
					sI = i;
					sJ = j;
				} else if (map[i][j] == 0) {
					// 0은 어차피 갈 수없는땅 -> 방문처리
					visited[i][j] = true;
				}
			}
		} // 입력받기 끝
		BFS(sI, sJ);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j])
					sb.append(dist[i][j] + " ");
				else
					sb.append("-1 ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	} // main

	public static void BFS(int sI, int sJ) {
		Queue<int[]> queue = new LinkedList<>();
		// 시작점 큐에 저장, 방문 처리
		queue.add(new int[] { sI, sJ });
		visited[sI][sJ] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			// 상하좌우 탐색하면서
			for (int idx = 0; idx < 4; idx++) {
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];

				// 경계 내에 존재하면서
				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					// 갈 수 있는 땅이고, 아직 방문 안했으면
					if (map[nr][nc] == 1 && !visited[nr][nc]) {
						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
						dist[nr][nc] = dist[now[0]][now[1]] + 1;
					}
				}
			}
		}
	} // BFS
} // class