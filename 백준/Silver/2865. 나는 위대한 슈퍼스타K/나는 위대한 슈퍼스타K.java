import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 예선 참가자 수
		int M = sc.nextInt(); // 장르 개수
		int K = sc.nextInt(); // 본선 진출자 수

		double[][] skill = new double[N][M];

		for (int j = 0; j < M; j++) { // 열 고정
			for (int i = 0; i < N; i++) {
				skill[sc.nextInt() - 1][j] = sc.nextDouble();
			}
		}

		double[] max = new double[N];

		for (int i = 0; i < N; i++) { // 행(참가자번호)
			double tmp = 0.0;
			for (int j = 0; j < M; j++) {
				if (skill[i][j] > tmp) {
					tmp = skill[i][j];
				}
				max[i] = tmp;
			}
		}
		// 정렬
		Arrays.sort(max);

		double ans = 0.0;

		// 본선진출자 K명
		// 오름차순 정렬한 배열의 뒤에서부터 K개 더함
		for (int i = N - 1; i >= N - K; i--) {
			ans += max[i];
		}

		System.out.printf("%.1f", ans);
	}
}