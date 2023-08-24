import java.util.Scanner;

public class Solution {
	public static int[][] sudoku = new int[9][9];
	public static int[] cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			} // 스도쿠 입력받기 끝

			int ans = 1; // 스도쿠 맞으면 1, 아니면 0

			// 가로, 세로, 네모 3가지 경우를 각 9번씩 탐색
			// cnt배열을 만들어 1~9까지 개수를 세고, 1이 아닌 수가 있다면 스도쿠 아님 탈출!

			// 1. 가로
			outerR: for (int i = 0; i < 9; i++) {
				// 각 행마다 카운트 배열 0으로 초기화
				cnt = new int[9];
				for (int j = 0; j < 9; j++) {
					// (각 칸에 있는 값 -1) 인덱스에 해당하는 배열값 ++
					cnt[sudoku[i][j] - 1]++;
					// 카운트가 1이 아닌 것이 있으면 스도쿠가 아님 >> 탈출!
					if (cnt[sudoku[i][j] - 1] != 1) {
						ans = 0;
						break outerR;
					}
				}
			} // outerR

			// 2. 세로
			outerC: for (int i = 0; i < 9; i++) {
				// 각 열마다 카운트 배열 0으로 초기화
				cnt = new int[9];
				for (int j = 0; j < 9; j++) {
					// (각 칸에 있는 값 -1) 인덱스에 해당하는 배열값 ++
					cnt[sudoku[j][i] - 1]++;
					// 카운트가 1이 아닌 것이 있으면 스도쿠가 아님 >> 탈출!
					if (cnt[sudoku[j][i] - 1] != 1) {

						ans = 0;
						break outerC;
					}
				}
			} // outerC

			// 3. 네모
			// 네모 9개의 시작 좌표 2차원 배열로 저장
			int[][] point = { { 0, 0 }, { 0, 3 }, { 0, 6 }, { 3, 0 }, { 3, 3 }, { 3, 6 }, { 6, 0 }, { 6, 3 },
					{ 6, 6 } };
			int idx = 0; // point 배열의 행 인덱스

			outerS: while (idx < 9) {
				// 각 네모마다 카운트 배열 0으로 초기화
				cnt = new int[9];
				// 9개의 시작점
				int r = point[idx][0];
				int c = point[idx][1];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						// 네모모양 값 탐색
						cnt[sudoku[r + i][c + j] - 1]++;
					}
				}
				// 카운트 배열 중 1이 아닌 값이 있으면 스도쿠 아님
				for (int i = 0; i < 9; i++) {
					if (cnt[i] != 1) {
						ans = 0;
						break outerS;
					}
				}
				idx++;
			} // outerS

			System.out.println("#" + tc + " " + ans);
		} // 테스트 케이스 for문

	} // main

} // class