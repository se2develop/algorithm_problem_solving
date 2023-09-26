import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 물품의 수
		int N = sc.nextInt();
		// 최대 무게
		int K = sc.nextInt();

		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			// i번째 물건의 무게, 가치 입력받기!
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

		// 선택에 따른 최대 가치를 담을 배열
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i < N + 1; i++) {
			// 임시무게가 0이면 아무 물건도 선택하지 못하므로 최대가치 0
			dp[i][0] = 0;
			for (int j = 1; j < K + 1; j++) {
				// 아무 물건도 탐색 안했을 때 최대가치 0
				dp[0][j] = 0;
				// i번째 물건의 무게가 임시무게 j보다 크면
				if (weight[i] > j)
					// i번째 물건 선택할 수 없음
					dp[i][j] = dp[i - 1][j];
				else {
					// 선택하지 않거나, i번째 물건의 무게만큼 빼고 i번째 물건 선택한 가치 비교
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
				}
			}
		}
		// 출력
		System.out.println(dp[N][K]);
	} // main
} // class