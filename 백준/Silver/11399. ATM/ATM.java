import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ATM 앞에 줄 서 있는 N명의 사람
		int N = sc.nextInt();
		// i번쨰 사람이 돈을 인출하는데 걸리는 시간 저장
		int[] time = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}

		// 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값 >> 정렬
		Arrays.sort(time);

		// 누적합
		for (int i = 1; i < N; i++) {
			time[i] += time[i - 1];
		}

		// 결과 구하기
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += time[i];
		}
		System.out.println(ans);
	}
}