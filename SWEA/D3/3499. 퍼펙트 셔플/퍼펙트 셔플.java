import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 카드 개수
			String[] deck1;
			String[] deck2;

			// N이 홀수일 때, 짝수 일 때 나눠서 생각
			if (N % 2 == 1) {
				// 홀수라면 먼저 놓는 쪽에 한 장 더 들어가도록
				deck1 = new String[N / 2 + 1];
				deck2 = new String[N / 2];

				for (int i = 0; i < N / 2 + 1; i++) {
					deck1[i] = sc.next();
				}

				for (int i = 0; i < N / 2; i++) {
					deck2[i] = sc.next();
				}

				System.out.print("#" + tc);
				for (int i = 0; i < N / 2 + 1; i++) {
					System.out.print(" " + deck1[i]);
					if (i < N / 2)
						System.out.print(" " + deck2[i]);
				}
			} else {
				// 짝수라면 균등하게 배분
				deck1 = new String[N / 2];
				deck2 = new String[N / 2];
				for (int i = 0; i < N / 2; i++) {
					deck1[i] = sc.next();
				}

				for (int i = 0; i < N / 2; i++) {
					deck2[i] = sc.next();
				}

				System.out.print("#" + tc);
				for (int i = 0; i < N / 2; i++) {
					System.out.print(" " + deck1[i]);
					System.out.print(" " + deck2[i]);
				}
			}
			System.out.println();
		}
	}
}