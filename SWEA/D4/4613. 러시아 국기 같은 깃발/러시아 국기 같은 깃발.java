import java.util.Scanner;

public class Solution {
	public static int N, M;
	public static char[][] flag;
	public static int[] result;
	public static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 행 길이
			M = sc.nextInt(); // 열 길이

			flag = new char[N][M];
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < M; j++) {
					flag[i][j] = tmp.charAt(j);
				}
			} // 입력받기 끝!

			// 흰색으로 칠할 마지막 행, 파란색으로 칠할 마지막 행 선택
			result = new int[2];
			ans = 987654321; // 새로 칠해야 하는 칸의 최소 개수
			comb(0, 0);
			System.out.println("#" + tc + " " + ans);

		} // tc for문
	} // main

	public static void comb(int idx, int sidx) {
		// 기저 부분
		if (sidx == 2) {
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i <= result[0]) { // 하얀색 칠하는 경우
						if (flag[i][j] != 'W')
							tmp++;
					} else if (i <= result[1]) { // 파란색 칠하는 경우
						if (flag[i][j] != 'B')
							tmp++;
					} else { // 빨간색 칠하는 경우
						if (flag[i][j] != 'R')
							tmp++;
					}
				}
			}
			if (tmp < ans)
				ans = tmp;
			return;
		}
		// 재귀 부분
		// 마지막 1줄은 무조건 빨간색이 칠해져야 조건을 만족하므로 (N-1)개 중 2개 선택
		for (int i = idx; i <= (N - 1) - 2 + sidx; i++) {
			result[sidx] = i;
			comb(i + 1, sidx + 1);
		}

	} // comb
} // class