import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int change = sc.nextInt();

		int[] dp = new int[change + 1];
		// 동전은 2원, 5원 사용 가능, 거슬러 줄 수 없으면 -1

		for (int i = 1; i < change + 1; i++) {
			int min = 987654321;
			// 2원을 작은 부분 문제에 추가
			if (i >= 2)
				min = Math.min(min, dp[i - 2] + 1);

			// 5원을 작은 부분 문제에 추가
			if (i >= 5)
				min = Math.min(min, dp[i - 5] + 1);

			dp[i] = min;
		}

//		System.out.println(Arrays.toString(dp));
		if (dp[change] == 987654321)
			System.out.println(-1);
		else
			System.out.println(dp[change]);
	} // main
} // class
