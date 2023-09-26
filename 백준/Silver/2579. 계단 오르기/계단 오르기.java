import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 계단의 개수
		int N = sc.nextInt();

		int[] step = new int[301];

		for (int i = 1; i < N + 1; i++) {
			step[i] = sc.nextInt();
		} // 계단 정보 거꾸로 입력받기

		// 각 칸에 도착했을 때 얻을 수 있는 최대값
		long[] dp = new long[301];
		dp[1] = step[1];
		dp[2] = step[1] + step[2];

		for (int i = 3; i < N + 1; i++) {
			// 조건을 만족하기 위해
			// 1. 내 바로 전 계단을 밟지 않고, 두 계단 전에서 나로 오거나
			// 2. 내 바로 전 계단을 밞고 오려면, 그 전 계단 기준으로 두 계단 전에서 올 수 있음
			// 그 다음 내 계단에 적힌 숫자를 더했을 때 최댓값
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + step[i - 1]) + step[i];
		}

		System.out.println(dp[N]);
	} // main
} // class
