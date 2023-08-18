import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int order = sc.nextInt(); // 테스트케이스 번호
			int[] arr = new int[8];

			for (int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
			} // 입력받기 끝!

			outer: while (true) {
				for (int i = 1; i <= 5; i++) {
					int first = arr[0] - i;

					for (int j = 0; j < arr.length - 1; j++) {
						arr[j] = arr[j + 1];
					} // 1 ~ 마지막인덱스 까지의 값들이 하나씩 앞으로 당겨짐

					// 0보다 작아지는 경우 0으로 유지되며 프로그램 종료
					if (first <= 0) {
						arr[arr.length - 1] = 0;
						break outer;
					}
					// 마지막 인덱스의 값에 arr[0] - i 저장
					else {
						arr[arr.length - 1] = first;
					}
				} // 한 사이클
			}

			// 정답 출력 양식
			System.out.print("#" + order);
			for (int i = 0; i < 8; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
		}
	}
}