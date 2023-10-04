import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static Queue<int[]> queue;
	public static int N, M, H, cnt, ans;
	public static int[] dr = { -1, 1, 0, 0, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1, 0, 0 };
	public static int[] dh = { 0, 0, 0, 0, -1, 1 };
	public static int[][][] box, visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 상자의 가로 칸
		M = sc.nextInt();
		// 상자의 세로 칸
		N = sc.nextInt();
		// 쌓아올려지는 상자의 수
		H = sc.nextInt();

		box = new int[H][N][M];
		visited = new int[H][N][M];
		queue = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					box[h][i][j] = sc.nextInt();
					// 익어야 할 토마토의 개수++;
					if (box[h][i][j] == 0) {
						cnt++;
					} else if (box[h][i][j] == 1) {
						// 익어 있는 토마토
						queue.add(new int[] { h, i, j });
					}
				}
			}
		} // 토마토 상태 입력받기

		// 처음부터 모든 토마토가 익어있는 상태이면 0
		if (cnt == 0) {
			System.out.println(0);
			return;
		}

		BFS();
		// 탐색 후에 모든 토마토가 익었으면 최소 일수를 출력, 아니면 -1
		if (cnt == 0)
			System.out.println(ans);
		// 아니면 -1
		else
			System.out.println(-1);

	} // main

	public static void BFS() {

		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				int[] now = queue.poll();

				for (int idx = 0; idx < 6; idx++) {
					int nh = now[0] + dh[idx];
					int nr = now[1] + dr[idx];
					int nc = now[2] + dc[idx];

					if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M) {
						// 아직 익지 않은 토마토이면서, 방문하지 않았으면
						if (box[nh][nr][nc] == 0 && visited[nh][nr][nc] == 0) {
							queue.add(new int[] { nh, nr, nc });
							box[nh][nr][nc] = 1; // 토마토 익히고
							cnt--; // 익어야 할 토마토 개수 줄이고
							visited[nh][nr][nc] = visited[now[0]][now[1]][now[2]] + 1; // 날짜 저장
							// 마지막에 저장되는 날짜가 모든 토마토가 익는데 걸리는 시간
							ans = visited[nh][nr][nc];
						}
					}

				}
			}
		}
	} // BFS
} // class