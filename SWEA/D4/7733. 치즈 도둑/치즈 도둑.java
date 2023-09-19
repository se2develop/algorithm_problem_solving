import java.util.Scanner;

public class Solution {
	public static int N, endDay, cnt, ans;
	public static int[][] cheese;
	public static boolean[][] visited;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			endDay = 0; // 마지막 날
			ans = 0; // 정답
			N = sc.nextInt(); // 치즈 한 변의 길이
			cheese = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					// 굳이 100일까지 갈 필요 없고, 치즈들 중 가장 맛있는 치즈가 있는 날까지만
					if (cheese[i][j] > endDay)
						endDay = cheese[i][j];
				}
			} // 입력받기 끝

			// 1일부터 endDay일까지만 하면 됨! 치즈 먹어버리자
			for (int day = 1; day <= endDay; day++) {
				// cnt(그 날 공간의 개수), visited(방문정보배열) 초기화
				int cnt = 0;
				visited = new boolean[N][N];

				// 모든 칸을 탐색하면서
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 아직 방문하지 않았고, 맛있는 정도가 그 날의 값 보다 크면
						if (visited[i][j] == false && cheese[i][j] > day) {
							// DFS
							DFS(i, j, day);
							cnt++; // 이게 공간 횟수
						}
					}
				}
				// 가장 최대 공간 구하기
				ans = Math.max(cnt, ans);
			}

			// ans가 0이면 1덩어리
			if (ans == 0)
				System.out.println("#" + tc + " 1");
			else
				System.out.println("#" + tc + " " + ans);

		} // tc for문
	} // main

	public static void DFS(int i, int j, int day) {
		visited[i][j] = true; // 방문 정보 기록하고

		// 상하좌우 탐색해서
		for (int idx = 0; idx < 4; idx++) {
			int nr = i + dr[idx];
			int nc = j + dc[idx];
			// 경계 내에 있으면서
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				// 아직 방문하지 않았고, 맛있는 정도가 그 날의 값 보다 크면
				if (visited[nr][nc] == false && cheese[nr][nc] > day) {
					DFS(nr, nc, day);
				}
			}
		} // 한 덩어리를 탐색하는 과정
	}
} // class