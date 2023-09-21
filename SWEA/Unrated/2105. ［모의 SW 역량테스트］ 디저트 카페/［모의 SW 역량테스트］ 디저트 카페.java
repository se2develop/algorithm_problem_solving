import java.util.Scanner;

public class Solution {
	public static int N, max, ans;
	public static int[][] map;
	public static boolean[] visited;
	public static int[] dr = { 1, -1, -1, 1 };
	public static int[] dc = { 1, 1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 디저트 카페가 모여있는 지역의 가로,세로

			map = new int[N][N]; // 카페 지역 배열 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] > max)
						max = map[i][j];

				}
			} // 입력받기 끝!

			ans = -1; // 디저트 개수 -> 먹을 수 없으면 -1 출력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 1; k < N; k++) {
						for (int l = 1; l < N; l++) {
							// 가장 많은 디저트의 개수 저장
							ans = Math.max(ans, snack(i, j, k, l));
						} // 대각선 길이 2
					} // 대각선 길이1
				} // 시작점 y좌표
			} // 시작점 x 좌표

			System.out.println("#" + tc + " " + ans);
		} // tc for문
	} // main

	public static int snack(int startR, int startC, int len1, int len2) {
		visited = new boolean[max + 1];
		int cnt = 1; // 반환값
		int nr = startR;
		int nc = startC;

		// 시작점 디저트 먹었음!
		int num = map[nr][nc];
		visited[num] = true;

		int L = 0; // 대각선 길이가 경우마다 다름
		for (int idx = 0; idx < 4; idx++) {

			if (idx == 0 || idx == 2)
				L = len1;
			else if (idx == 1)
				L = len2;
			// 마지막은 출발점까진 안가도 되므로 len2-1
			else
				L = len2 - 1;

			for (int i = 0; i < L; i++) {
				// idx에 따라 시계방향으로 대각선길을 따라감
				nr += dr[idx];
				nc += dc[idx];

				// 경계를 벗어나면 -1
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					return -1;

				// 이미 있는 디저트면 -1
				if (visited[map[nr][nc]])
					return -1;

				// 아니면 디저트 개수 ++, 그 디저트는 이미 먹었음
				cnt++;
				visited[map[nr][nc]] = true;
			}

		}

		return cnt; // 여기까지 오면 가능한 경우임!
	} // snack 개수 계산
}// class