import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int M, N, cnt, ans;
	public static int[][] tomato;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int[][] visited;
	public static Queue<int[]> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 상자의 가로 칸 수
		N = sc.nextInt(); // 상자의 세로 칸 수
		tomato = new int[N][M]; // 토마토 상태 저장
		visited = new int[N][M]; // 첫 날부터 시작해서 익는데 걸리는 일 수
		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tomato[i][j] = sc.nextInt();
				// 익어야 할 토마토 개수 cnt
				if (tomato[i][j] == 0) {
					cnt++;
				} else if (tomato[i][j] == 1) {
					// 1이면 토마토가 있으니까 방문배열 true, 큐에 삽입
					visited[i][j] = 0;
					queue.add(new int[] { i, j });
				}
			}
		} // 입력받기 끝

		// 처음부터 모든 토마토가 익어있으면 0 출력
		if (cnt == 0) {
			System.out.println("0");
			return;
		}

		BFS();
		// 탐색 후 모든 토마토가 익었으면 최소 일수 출력
		if (cnt == 0)
			System.out.println(ans);
		// 아니면 -1
		else
			System.out.println(-1);

	} // main

	public static void BFS() {
		while (!queue.isEmpty()) {
			// 큐 사이즈(어제 익은 모든 토마토 정보 저장됨)ㄴ
			for (int i = 0; i < queue.size(); i++) {
				int[] now = queue.poll();
				// 상하좌우 탐색
				for (int idx = 0; idx < 4; idx++) {
					int nr = now[0] + dr[idx];
					int nc = now[1] + dc[idx];
					// 경계 내에 존재하고
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						// 아직 익지 않은 토마토이면서, 방문하지 않았으면
						if (tomato[nr][nc] == 0 && visited[nr][nc] == 0) {
							queue.add(new int[] { nr, nc });
							tomato[nr][nc] = 1; // 토마토 익히고
							cnt--; // 익어야 할 토마토 개수 줄이고
							visited[nr][nc] = visited[now[0]][now[1]] + 1; // 날짜 저장
							// 마지막에 저장되는 날짜가 모든 토마토가 익는데 걸리는 시간
							ans = visited[nr][nc];
						}
					}
				}
			}
		}

	} // BFS
} // class
