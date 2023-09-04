import java.util.Scanner;

public class Solution {
	public static int N, B, ans;
	public static int[] H;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 점원의 수
			B = sc.nextInt(); // 높이가 B이상인 탑

			// 모든 부분집합을 구해서 판단해보자
			H = new int[N];

			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}

			ans = 987654321;
			powerset(0, 0);
			System.out.println("#" + tc + " " + (ans - B));

		} // tc for문

	} // main

	// sum = 중간합
	public static void powerset(int idx, int sum) {
        // 내가 가지고 있는 ans보다 크면 탈출!
		if (sum > ans)
			return;
        
		// 기저 부분
		if (idx == N) {
			if (sum >= B)
				ans = Math.min(ans, sum);
			return; // 종료조건 !!
		}

		// 재귀 부분
		// 중간합을 사용 > 어떤 점원이 포함되었는지는 알 수 없음
		powerset(idx + 1, sum + H[idx]);
		powerset(idx + 1, sum);
	}

} // class