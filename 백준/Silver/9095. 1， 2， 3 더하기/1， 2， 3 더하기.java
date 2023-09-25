import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			// 정수 n
			n = sc.nextInt();

			// n은 11보다 작으므로 12로 생성
			dp = new int[12];

			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			if (n >= 4) {
				for (int i = 4; i <= n; i++) {
					dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
				}
			}

			System.out.println(dp[n]);
		} // tc for문

	} // main

} // class