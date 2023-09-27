import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 2xn 크기의 직사각형을 채우는 방법의 수
		int N = sc.nextInt();

		int[] dp = new int[1001];

		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i < N + 1; i++) {
			dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
		}
		System.out.println(dp[N]);
	}
}