import java.util.Scanner;

// bottom-up 방식 >> 주로 반복문 이용
public class Main {
	public static int N;
	public static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정수 N

		dp = new int[N + 1]; // i에서 1로 만드는데 걸리는 최소 연산 횟수
		dp[1] = 0; // 초기화
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1; // -1 연산
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나누는 연산
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나누는 연산
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	} // main
} // class