import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static boolean[][] visited;
	public static int[][] maze;
	public static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			maze = new int[16][16];
			visited = new boolean[16][16];
			sc.nextInt(); // 날려버리기 tc로 하면 됨

			for (int i = 0; i < 16; i++) {
				String str = sc.next();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = str.charAt(j) - '0';
				}
			} // 입력받기 끝

			ans = 0; // 도달가능여부(0:불가능, 1:가능)
			BFS(1, 1);
			System.out.println("#" + tc + " " + ans);
		} // tc for문
	} // main

	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		// 시작점(1,1)을 큐에 넣고, 방문 정보 기록
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			// 도착점에 도착하면 ans=1로 바꾸고 끝
			if (now[0] == 13 && now[1] == 13) {
				ans = 1;
				return;
			}
			// 상하좌우 탐색
			for (int idx = 0; idx < 4; idx++) {
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];
				// 좌표가 미로 경계 내에 있을 때
				if (nr >= 1 && nc >= 1 && nr <= 13 && nc <= 13) {
					// (갈 수 있는 길 || 도착점) 이고 아직 방문하지 않았다면
					if ((maze[nr][nc] == 0 || maze[nr][nc] == 3) && visited[nr][nc] == false) {
						// 큐에 추가하고 방문 정보 기록
						queue.add(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			} // 상하좌우 탐색 for문
		} // queue가 비어있을 때까지 while

	} // BFS
} // class