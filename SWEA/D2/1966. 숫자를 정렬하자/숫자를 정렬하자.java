import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N
			int[] num = new int[N]; // N 길이의 숫자열

			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			} // 입력받기 끝

			// 선택정렬 복습!
			// 0 번째 원소는 이미 정렬 되어있다고 생각!
			for (int i = 1; i < N; i++) {
				int key = num[i];

				int j;
				for (j = i - 1; j >= 0 && key < num[j]; j--) {
					num[j + 1] = num[j];
				}
				num[j + 1] = key;
			}

			System.out.print("#" + tc);
			for (int i = 0; i < N; i++) {
				System.out.print(" " + num[i]);
			}
			System.out.println();
		} // 테스트 케이스 for문
	} // main
} // class