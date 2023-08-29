import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 마지막 N비트
			int M = sc.nextInt(); // M의 이진수 표현

			String flag = "ON";

			for (int i = 0; i < N; i++) {
				// 마지막 N비트 중 1로 켜져있지 않은 비트가 있으면
				if ((M & (1 << i)) == 0) {
					flag = "OFF"; // OFF로 바꾸고 탈출
					break;
				}
			}
			System.out.println("#" + tc + " " + flag);

		} // tc for문

	} // solution

} // class