import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, cnt;
	public static int[][] map;
	public static List<Integer> list;
	public static boolean[][] visited;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 지도의 크기
		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		} // 입력받기 끝!

		// 단지의 수
		cnt = 0;
		list = new ArrayList<>();
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					BFS(i, j);
					cnt++;
				}
			}
		}
		// 각 단지내 집의 수 오름차순 정렬
		Collections.sort(list);

		// 출력
		System.out.println(cnt);
		for (int people : list) {
			System.out.println(people);
		}

	} // main

	public static void BFS(int i, int j) {
		// 단지 내 사람 수
		int tmp = 1;
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			// 상하좌우탐색
			for (int idx = 0; idx < 4; idx++) {
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];

				// 경계 내에 있으면서
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					// 아직 방문하지 않고, 집이 있는 경우
					if (map[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
						tmp++;
					}
				}
			}
		}
		list.add(tmp);
	} // BFS
} // class
