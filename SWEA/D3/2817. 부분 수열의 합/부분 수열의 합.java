import java.util.Scanner;

public class Solution {
	public static int N; // 수열 길이
	public static int K; // 합이 K가 되는 경우의 수 구하기
	public static int[] arr;
	public static boolean[] sel;
	public static int sum; // 각 부분 수열의 합
	public static int cnt; // 부분 수열의 합 == K인 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			cnt = 0; // 각 테케마다 0으로 초기화

			N = sc.nextInt();
			K = sc.nextInt();

			arr = new int[N];
			sel = new boolean[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			subset(0);
			System.out.println("#" + tc + " " + cnt);

		} // tc for문

	} // main

	public static void subset(int idx) {
		if (idx == N) {
			sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i])
					sum += arr[i];
			}
			// 각 부분수열의 합이 K와 같으면
			if (sum == K)
				cnt++; // cnt+1
			return;
		}

		sel[idx] = false;
		subset(idx + 1);
		sel[idx] = true;
		subset(idx + 1);
	} // subset

} // class