import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int N, M, R, C, L;
	public static int[][] map;
	public static int[][] visited;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	// 파이프 번호에 따른 상,하,좌,우 가능 여부 탐색
	// 0은 갈 수 있고, 1은 갈 수 없음
	public static int[][] dir = { 
			{ 0, 0, 0, 0 }, 
			{ 1, 1, 1, 1 }, // 1번 파이프
			{ 1, 1, 0, 0 }, // 2번 파이프
			{ 0, 0, 1, 1 }, // 3번 파이프
			{ 1, 0, 0, 1 }, // 4번 파이프
			{ 0, 1, 0, 1 }, // 5번 파이프
			{ 0, 1, 1, 0 }, // 6번 파이프
			{ 1, 0, 1, 0 } }; // 7번 파이프

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			// 지도의 세로 크기
			N = sc.nextInt();
			// 지도의 가로 크기
			M = sc.nextInt();
			// 맨홀 뚜껑의 세로 위치
			R = sc.nextInt() + 1;
			// 맨홀 뚜껑의 가로 위치
			C = sc.nextInt() + 1;
			// 탈출 후 소요된 시간
			L = sc.nextInt();

			map = new int[N + 2][M + 2];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 지도 정보 입력받기
			visited = new int[N + 2][M + 2];
			BFS(R, C);

			int ans = 0;
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					if(visited[i][j] > 0 && visited[i][j] <= L)
						ans++;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		} // tc for문
	} // main

	public static void BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();

		// 맨홀뚜껑 좌표 저장
		queue.add(new int[] { r, c });
		visited[r][c] = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			// 현재 좌표의 파이프 종류
			int nowPipe = map[now[0]][now[1]];

			// 파이프 정보에 따라 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				// 현재 파이프 종류에 따라 갈 수 없는 곳이면 continue
				if (dir[nowPipe][i] == 0)
					continue;

				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int nextPipe = map[nr][nc];

				if (i % 2 == 0 && dir[nextPipe][i + 1] == 0)
					continue;

				if (i % 2 == 1 && dir[nextPipe][i - 1] == 0)
					continue;

				// 애초에 배열을 크게 만들어서 경계를 벗어나는 것 처리해줌
				// 0이면 파이프가 없으므로 그것만 확인!
				if (map[nr][nc] != 0 && visited[nr][nc] == 0) {
					queue.add(new int[] { nr, nc });
					visited[nr][nc] = visited[now[0]][now[1]] + 1;
				}
			}
		}
	}
} // class