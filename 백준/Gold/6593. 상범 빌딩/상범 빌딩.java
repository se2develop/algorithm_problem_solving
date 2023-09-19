import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int L, R, C, time;
	public static char[][][] building;
	public static int[][][] visited;
	public static int sfloor, srow, scol, efloor, erow, ecol; // 시작점 좌표, 출구 좌표 저장
	// 상하좌우남북
	public static int[] dr = { -1, 1, 0, 0, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1, 0, 0 };
	public static int[] df = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			L = sc.nextInt(); // 상범 빌딩의 층 수
			R = sc.nextInt(); // 한 층의 행의 개수
			C = sc.nextInt(); // 한 층의 열의 개수
			if (L == 0 && R == 0 && C == 0)
				System.exit(0);

			building = new char[L][R][C];
			visited = new int[L][R][C];

			for (int f = 0; f < L; f++) {
				for (int i = 0; i < R; i++) {
					String str = sc.next();
					for (int j = 0; j < C; j++) {
						building[f][i][j] = str.charAt(j);
						if (building[f][i][j] == 'S') {
							sfloor = f;
							srow = i;
							scol = j;
						}
						if (building[f][i][j] == 'E') {
							efloor = f;
							erow = i;
							ecol = j;
						}
					} // 열
				} // 행
				sc.nextLine();
			} // 층 -> 입력받기 끝

			time = 0;
			BFS(sfloor, srow, scol);
			if (time == 0) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + (time - 1) + " minute(s).");
			}
		} // (0,0,0) 들어오면 종료
	} // main

	public static void BFS(int f, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { f, r, c });
		visited[f][r][c] = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (building[now[0]][now[1]][now[2]] == 'E') {
				time = visited[now[0]][now[1]][now[2]];
				return;
			}

			for (int idx = 0; idx < 6; idx++) {
				int nf = now[0] + df[idx];
				int nr = now[1] + dr[idx];
				int nc = now[2] + dc[idx];

				if (nf >= 0 && nf < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if ((building[nf][nr][nc] == '.' || building[nf][nr][nc] == 'E') && visited[nf][nr][nc] == 0) {
						queue.add(new int[] { nf, nr, nc });
						visited[nf][nr][nc] = visited[now[0]][now[1]][now[2]] + 1;
					}
				}
			}
		}
	} // BFS
} // class
