import java.util.Scanner;

public class Main {
	public static int N, ans;
	public static int[] T, P, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 퇴사까지 남은 날
		T = new int[N + 1]; // 상담을 완료하는데 걸리는 기간
		P = new int[N + 1]; // 상담을 했을 때 받을 수 있는 금액
		dp = new int[N + 2]; // i번째 날부터 퇴사일까지 벌 수 있는 최대수입

		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		} // 상담 일정표 입력받기 끝!

		for (int i = N; i > 0; i--) {
			// i번째날 시작하는 상담이 퇴사날까지 끝나지 않는경우
			if (i + T[i] > N + 1) {
				dp[i] = dp[i + 1];
			}
			// i번째날 시작하는 상담이 퇴사날전에 끝나는 경우
			else
				// i+1번째 날부터 퇴사일까지 벌 수 있는 최대 수입
				// i번째 상담비용 + i번째 상담이 끝난 다음날 부터 퇴사일까지의 최대 수입
				dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
		}
		System.out.println(dp[1]);
	} // main
} // class