import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int N, M;
	public static int[][] maze;
	public static int[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 배열 행 개수
		M = sc.nextInt(); // 배열 열 개수
		maze = new int[N][M]; // 미로 배열
		visited = new int[N][M]; // BFS -> 최소 칸 수 저장

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		} // 미로 입력받기 끝(1:이동가능, 0:이동불가능)

		// (0,0) -> (N-1,M-1)도착
		BFS(0, 0);
		System.out.println(visited[N - 1][M - 1]);
	} // main

	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		// 시작 정점 큐에 추가, 시작 노드 방문 칸수 = 1
		queue.add(new int[] { i, j });
		visited[i][j] = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			// 상하좌우탐색
			for (int idx = 0; idx < 4; idx++) {
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];
				// 좌표가 경계 내에 있으면서
				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					// 갈 수 있는 길(1)이고, 아직 방문하지 않았으면
					if (maze[nr][nc] == 1 && visited[nr][nc] == 0) {
						// 방문하고
						queue.add(new int[] { nr, nc });
						// 방문 칸수 + 1 해서 저장
						visited[nr][nc] = visited[now[0]][now[1]] + 1;
					}
				}
			}
		}
	} // BFS
} // class