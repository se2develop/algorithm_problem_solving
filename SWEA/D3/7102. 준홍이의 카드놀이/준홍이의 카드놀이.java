import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 1번째 세트의 마지막 숫자
			int M = sc.nextInt(); // 2번째 세트의 마지막 숫자
			int[] prob = new int[N + M];

			int max = 0; // 가장 많이 나올 수 있는 수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					prob[i + j]++;
					if (prob[i + j] > max)
						max = prob[i + j];
				}
			}

			// 가장 많이 나온 수들을 저장할 문자열
			String str = "";
			for (int i = 0; i < prob.length; i++) {
				if (prob[i] == max) {
					str += (i + 2);
					str += " ";
				}
			}
			System.out.println("#" + tc + " " + str);
		}
	}
}