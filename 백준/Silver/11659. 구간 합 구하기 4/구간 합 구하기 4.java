import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 숫자의 개수
		int N = sc.nextInt();
		// 부분합을 구해야 하는 횟수
		int M = sc.nextInt();

		// N개의 숫자 입력받기
		int[] nums = new int[N + 1];
		int[] sum = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			nums[i] = sc.nextInt();
			sum[i] += sum[i - 1] + nums[i];
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int ans = sum[b] - sum[a-1];
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	} // main
} // class