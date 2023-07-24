import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
			Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int cnt = 1 ; cnt < T+1; cnt++) {
			int N = sc.nextInt();
			int[][] ans = new int[N][N]; // N*N 크기의 배열 생성
			int r = 0; // 행 index
			int c = 0; // 열 index

			ans[r][c] = 1; // 시작점은 (0,0) = 1
			int num = 2; // 배열에 들어갈 숫자 (1씩 증가)
			// 종료시점은 num == N * N
			// 방향(우 > 하 > 좌 > 상)
			while (num <= N * N) {
				// 우
				while (c + 1 < N && ans[r][c + 1] == 0) {
					c++;
					ans[r][c] = num;
					num++;
				}
				// 하
				while (r + 1 < N && ans[r + 1][c] == 0) {
					r++;
					ans[r][c] = num;
					num++;
				}
				// 좌
				while (c - 1 >= 0 && ans[r][c - 1] == 0) {
					c--;
					ans[r][c] = num;
					num++;
				}
				// 상
				while (r - 1 >= 0 && ans[r - 1][c] == 0) {
					r--;
					ans[r][c] = num;
					num++;
				}
			}
			System.out.println("#" + cnt);
			for (int i = 0; i < N; i++) {
				for (int n : ans[i])
					System.out.print(n + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}