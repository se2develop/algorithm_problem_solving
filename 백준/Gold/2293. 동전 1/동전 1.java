import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// n가지 종류의 동전
		int n = sc.nextInt();
		// 가치의 합 k원이 되도록!
		int k = sc.nextInt();

		// 각 동전의 가치
		int[] coin = new int[n];
		for (int i = 0; i < n; i++)
			coin[i] = sc.nextInt();

		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			// 현재 사용하는 동전의 가치
			int curr = coin[i];
			for (int j = 1; j < k + 1; j++) {
				// j원이 현재 사용하는 동전의 가치보다 작으면
				if (j < curr)
					// 그 전까지 경우의 수 그대로
					dp[j] = dp[j];
				// j원이 현재 사용하는 동전의 가치와 같으면
				else if (j == curr)
					// 경우의수 1 추가
					dp[j] = dp[j] + 1;
				// j원이 현재 사용하는 동전의 가치보다 크면
				else
					dp[j] = dp[j] + dp[j - curr];
			}
		}
		System.out.println(dp[k]);

	} // main
} // class