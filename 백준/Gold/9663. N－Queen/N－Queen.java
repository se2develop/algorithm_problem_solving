import java.util.Scanner;

public class Main {
	public static int N, ans;
	public static boolean[] flag, flagA, flagB;
	public static int[] pos;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 퀸의 개수, 체스판의 가로세로길이
		pos = new int[N]; // pos[r] = c >> r행, c열
		flag = new boolean[N];
		flagA = new boolean[2 * N - 1]; // / 대각선
		flagB = new boolean[2 * N - 1]; // \ 대각선
		ans = 0;

		queenSet(0);
		System.out.println(ans);
	} // main

	public static void queenSet(int r) {
		for (int c = 0; c < N; c++) {
			// c열이 비어있고, / 대각선, / 대각선이 비어있으면
			if (flag[c] == false && flagA[r + c] == false && flagB[r - c + (N - 1)] == false) {
				pos[r] = c; // (r,c)에 퀸 배치
				if (r == N - 1) { // 모든 행에 퀸에 배치되었으면
					ans++; // 경우의 수 + 1;
				} else {
					flag[c] = flagA[r + c] = flagB[r - c + (N - 1)] = true;
					queenSet(r + 1); // 다음 행 탐색
					flag[c] = flagA[r + c] = flagB[r - c + (N - 1)] = false;
				}
			}
		} // 각 행에 대해서 세로, 대각선 탐색

	} // queenSet
} // class