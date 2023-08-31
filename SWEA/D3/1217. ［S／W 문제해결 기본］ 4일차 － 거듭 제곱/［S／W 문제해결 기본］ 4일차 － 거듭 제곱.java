import java.util.Scanner;

public class Solution {
	public static int num, N, M;
	public static int[] memories;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 10개
		for (int tc = 1; tc <= 10; tc++) {

			num = sc.nextInt(); // 테스트 케이스 번호
			N = sc.nextInt(); // 밑
			M = sc.nextInt(); // 지수
			memories = new int[M + 1];

			System.out.println("#" + num + " " + pow(N, M));
		} // tc for문

	} // main

	// 중복 연산을 피하기 위해서 값을 저장해서 사용
	public static int pow(int N, int M) {
		if (M == 1)
			memories[1] = N;

		// 저장된 값이 있으면 바로 return
		if (memories[M] != 0) {
			return memories[M];

		} else {
			// 1) 짝수일 때
			if (M % 2 == 0) {
				int tmp = pow(N, M / 2);
				memories[M] = tmp * tmp;
				return memories[M];
			}
			// 2) 홀수일 때
			else {
				int tmp = pow(N, (M - 1) / 2);
				memories[M] = tmp * tmp * N;
				return memories[M];
			}
		}
	} // pow
} // class