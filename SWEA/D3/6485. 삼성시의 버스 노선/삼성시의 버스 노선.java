import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			// 1 <= 정류장번호 <= 5000
			int[] busStop = new int[5000];

			int N = sc.nextInt(); // 버스 노선 개수
			// i번째 버스가 다니는 시작 ~ 끝 정류장 번호 받아서
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				// 정류장 배열에 ++ 해주기
				for (int j = start - 1; j < end; j++) {
					busStop[j]++;
				}
			}

			int P = sc.nextInt(); // 궁금한 버스 정류장 개수
			int[] idx = new int[P]; // P개의 버스 정류장 번호

			for (int i = 0; i < P; i++) {
				idx[i] = sc.nextInt();
			} // 입력받고

			// 결과 출력
			System.out.print("#" + tc);
			for (int i = 0; i < P; i++) {
				// 입력받은 버스정류장 번호를 지나는 노선의 개수 출력
				System.out.print(" " + busStop[idx[i] - 1]);
			}
			System.out.println();

		} // 테스트 케이스 for문
	} // main
} // class
