import java.util.Scanner;

public class Solution {
	public static int N, B, ans;
	public static int[] H;
	public static boolean[] sel;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 점원의 수
			B = sc.nextInt(); // 높이가 B이상인 탑

			// 모든 부분집합을 구해서 판단해보자
			H = new int[N];
			sel = new boolean[N]; // 해당 점원의 포함 여부
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}

			ans = 987654321;
			powerset(0);
			System.out.println("#" + tc + " " + (ans - B));

		} // tc for문

	} // main

	public static void powerset(int idx) {
		// 기저 부분
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i])
					sum += H[i];
			}
			if (sum >= B && sum < ans)
				ans = sum;
			return; // 종료조건 !!
		}
		// 재귀 부분
		sel[idx] = false; // 미포함
		powerset(idx + 1);
		sel[idx] = true; // 포함
		powerset(idx + 1);
	}

} // class