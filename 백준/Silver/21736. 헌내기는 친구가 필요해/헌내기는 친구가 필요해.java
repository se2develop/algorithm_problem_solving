import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, M, ans;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int[][] map;
	public static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 캠퍼스 세로길이
		N = sc.nextInt();
		// 캠퍼스 가로길이
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		// 도연이 위치
		int ir = 0, ic = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					ir = i;
					ic = j;
				}
			}
		} // 입력받기 끝

		ans = 0;
		BFS(ir, ic);

		if (ans == 0)
			System.out.println("TT");
		else
			System.out.println(ans);

	} // main

	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		// 도연이 위치 queue에 넣고, 방문 표시
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int idx = 0; idx < 4; idx++) {
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];

				// 경계를 넘지 않으면서
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					// 아직 방문하지 않았고 벽이 아니면
					if (!visited[nr][nc] && map[nr][nc] != 'X') {
						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
						// 사람 만나면 인원 수 체크
						if (map[nr][nc] == 'P')
							ans++;
					}
				}
			}
		}
	} // BFS
} // class