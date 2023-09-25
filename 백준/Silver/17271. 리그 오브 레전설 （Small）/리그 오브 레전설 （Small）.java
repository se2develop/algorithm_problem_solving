import java.util.Scanner;

public class Main {
	public static int N, M;
	public static long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 싸움시간
		M = sc.nextInt(); // B의 시전시간

		// N은 10000이하의 자연수 이므로 10001크기로 만듦!
		dp = new long[10001];

		// B의 시전시간 전까지는 A로 이루어진 경우의 수 1개만 존재
		for (int i = 1; i < M; i++) {
			dp[i] = 1;
		}

		// B의 시전시간이 되는 순간은 A로만 이루어진 경우의 수 1개, B
		dp[M] = 2;

		// M+1부터는 N까지는
		// (i-1 번쨰 경우의 수) + A
		// (i-M 번째 경우의 수 ) + B 를 합한 경우의 수!
		for (int i = M + 1; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - M]) % 1000000007;
		}

		System.out.println(dp[N]);
	} // main
} // class
