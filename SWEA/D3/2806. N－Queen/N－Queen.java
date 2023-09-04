import java.util.Scanner;

public class Solution {
	public static boolean[] flag, flagL, flagR;
	public static int[] pos;
	public static int N, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 퀸의 개수, 체스판의 가로세로 크기
			pos = new int[N]; // 각 행에 놓인 퀸의 위치, pos[i] = j >> i행, j열
			flag = new boolean[N]; // 세로 방향
			flagL = new boolean[2 * N - 1]; // / 대각선 방향
			flagR = new boolean[2 * N - 1]; // \ 대각선 방향
			ans = 0; // 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수

			queenSet(0);
			System.out.println("#" + tc + " " + ans);
		} // tc for문
	} // main

	public static void queenSet(int idx) {
		for (int i = 0; i < N; i++) {
			if (flag[i] == false && flagL[idx + i] == false && flagR[idx - i + (N - 1)] == false) {
				pos[idx] = i; // 퀸을 (idx, i)에 배치
				if (idx == N - 1) { // 모든 행에 퀸이 배치되었다면
					ans++;
//					System.out.println(Arrays.toString(pos)); // 출력
				} else {
					flag[i] = flagL[idx + i] = flagR[idx - i + (N - 1)] = true;
					queenSet(idx + 1); // 다음 행으로 넘어감
					flag[i] = flagL[idx + i] = flagR[idx - i + (N - 1)] = false;
				}
			}
		}
	} // queenSet

} // class