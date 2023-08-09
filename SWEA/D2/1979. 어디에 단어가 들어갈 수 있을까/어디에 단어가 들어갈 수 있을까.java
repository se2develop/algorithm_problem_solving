import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 단어 퍼즐의 가로, 세로 길이
			int K = sc.nextInt(); // 단어의 길이

			int[][] puzzle = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			} // 입력받기 끝!

			int cnt = 0; // 길이 K의 단어가 들어갈 수 있는 곳

			// 1) 가로 방향 탐색
			int cell = 0; // 연속된 하얀색 빈칸의 개수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 하얀색 빈칸이면 cell++
					if (puzzle[i][j] == 1)
						cell++;
					else if (cell >= 1 && puzzle[i][j] == 0) { // 벽을 만났을 때
						if (cell == K) { // 벽 앞의 하얀색 빈칸의 개수가 == K
							cnt++;
						}
						cell = 0; // 다시 초기화
					}
				}
				if (cell == K)
					cnt++;
				cell = 0; // 행 탐색 끝나면 다시 시작
			}
			// 2) 세로 방향 탐색
			cell = 0; // 연속된 하얀색 빈칸의 개수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 하얀색 빈칸이면 cell++
					if (puzzle[j][i] == 1)
						cell++;
					else if (cell >= 1 && puzzle[j][i] == 0) { // 벽을 만났을 때
						if (cell == K) { // 벽 앞의 하얀색 빈칸의 개수가 == K
							cnt++;
						}
						cell = 0; // 다시 초기화
					}
				}
				if (cell == K)
					cnt++;
				cell = 0; // 열 탐색 끝나면 다시 시작
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}