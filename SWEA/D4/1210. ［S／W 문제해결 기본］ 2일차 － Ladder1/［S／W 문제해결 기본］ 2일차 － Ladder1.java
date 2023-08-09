import java.util.Scanner;

class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			int[][] ladder = new int[100][100];

			// 입력받기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}

			// 도착지점 찾기

			int row = 99;
			int col = 0;
			for (int i = 0; i < 100; i++) {
				if (ladder[row][i] == 2)
					col = i;
			}

			// 0행까지 올라오면 종료 , 그 때의 col값이 출발점
			while (row > 0) {
				// 1) col이 0일 때(가장 왼쪽 위치)
				if (col == 0) {
					// 오른쪽이 0이면 위로 이동
					if (ladder[row][col + 1] == 0) {
						row--;
					}
					// 오른쪽이 1이면 0을 만날때까지 오른쪽으로 이동
					else {
						while (col + 1 <= 99 && ladder[row][col + 1] != 0) {
							col++;
						}
						// 오른쪽으로 이동 다하면 위로 이동
						row--;
					}
				}
				// 2) col이 99일 때(가장 오른쪽 위치)
				else if (col == 99) {
					// 왼쪽이 0이면 위로 이동
					if (ladder[row][col - 1] == 0) {
						row--;
					}
					// 왼쪽이 1이면 0을 만날때까지 왼쪽으로 이동
					else {
						while (col - 1 >= 0 && ladder[row][col - 1] != 0) {
							col--;
						}
						// 왼쪽으로 이동 다하면 위로 이동
						row--;
					}
				}
				// 그 외 나머지
				else {
					// 양쪽이 0이면 위로 이동
					if (ladder[row][col - 1] == 0 && ladder[row][col + 1] == 0) {
						row--;
					}
					// 왼쪽이 1이면 0을 만날때까지 왼쪽으로 이동
					else if (ladder[row][col - 1] == 1) {
						while (col - 1 >= 0 && ladder[row][col - 1] != 0) {
							col--;
						}
						row--;
					}
					// 오른쪽이 1이면 0을 만날때까지 오른쪽으로 이동
					else if (ladder[row][col + 1] == 1) {
						while (col + 1 <= 99 && ladder[row][col + 1] != 0) {
							col++;
						}
						row--;
					}
				}
			}
			System.out.println("#" + tc + " " + col);
		}
	}
}