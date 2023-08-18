import java.util.Scanner;

public class Solution {
	public static int sum = 0;
	public static int nr = 0;
	public static int nc = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 오목판의 크기

			int[][] omok = new int[N][N]; // 오목판

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					char ch = str.charAt(j);
					// 돌이 없으면 0
					if (ch == '.')
						omok[i][j] = 0;
					// 돌이 있으면 1
					else if (ch == 'o')
						omok[i][j] = 1;
				}
			} // 입력받고 오목판 생성 끝!

			// 가로 , 세로, 좌하향 대각선, 우하향대각선
			// 델타탐색으로는 어떻게 해야 하지 ,,
//				int[] dr = { 0, 1, 1, 1 };
//				int[] dc = { 1, 0, -1, 1 };

			// 오목인지 아닌지 출력할 결과
			String ans = "NO";

			// 1) 가로 방향 탐색(r은 그대로, c+1)
			forR: for (int i = 0; i < N; i++) {
				sum = 0; // 연속한 돌의 개수
				for (int j = 0; j < N; j++) {
					// 돌을 만나면 위치 저장, sum = 1
					if (omok[i][j] == 1) {
						nr = i;
						nc = j;
						sum = 1;

						while (nc + 1 <= N - 1 && omok[nr][nc + 1] != 0) {
							sum++;
							nc++;
						} // 경계를 벗어나거나, 돌이 없을 때 까지 반복
					}
					// sum이 5이상이 되면 오목이므로 더이상 안봐도됨!
					if (sum >= 5) {
						ans = "YES";
						break forR;
					}
				}
			}

			// 2) 세로 방향 탐색(r+1, c는 그대로)
			forC: for (int i = 0; i < N; i++) {
				sum = 0; // 연속한 돌의 개수
				for (int j = 0; j < N; j++) {
					// 돌을 만나면 위치 저장, sum = 1
					if (omok[j][i] == 1) {
						nr = j;
						nc = i;
						sum = 1;

						while (nr + 1 <= N - 1 && omok[nr + 1][nc] != 0) {
							sum++;
							nr++;
						} // 경계를 벗어나거나, 돌이 없을 때 까지 반복
					}
					// sum이 5이상이 되면 오목이므로 더이상 안봐도됨!
					if (sum >= 5) {
						ans = "YES";
						break forC;
					}
				}
			}

			// 3) 좌하향 대각선 방향 탐색(r+1, c-1)
			forL: for (int i = 0; i < N; i++) {
				sum = 0; // 연속한 돌의 개수
				for (int j = 0; j < N; j++) {
					// 돌을 만나면 위치 저장, sum = 1
					if (omok[i][j] == 1) {
						nr = i;
						nc = j;
						sum = 1;

						while (nr + 1 <= N - 1 && nc - 1 >= 0 && omok[nr + 1][nc - 1] != 0) {
							sum++;
							nr++;
							nc--;
						} // 경계를 벗어나거나, 돌이 없을 때 까지 반복
					}
					// sum이 5이상이 되면 오목이므로 더이상 안봐도됨!
					if (sum >= 5) {
						ans = "YES";
						break forL;
					}
				}
			}

			// 4) 우하향 대각선 방향 탐색(r+1, c+1)
			forR: for (int i = 0; i < N; i++) {
				sum = 0; // 연속한 돌의 개수
				for (int j = 0; j < N; j++) {
					// 돌을 만나면 위치 저장, sum = 1
					if (omok[i][j] == 1) {
						nr = i;
						nc = j;
						sum = 1;

						while (nr + 1 <= N - 1 && nc + 1 <= N - 1 && omok[nr + 1][nc + 1] != 0) {
							sum++;
							nr++;
							nc++;
						} // 경계를 벗어나거나, 돌이 없을 때 까지 반복
					}
					// sum이 5이상이 되면 오목이므로 더이상 안봐도됨!
					if (sum >= 5) {
						ans = "YES";
						break forR;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}

	}
}