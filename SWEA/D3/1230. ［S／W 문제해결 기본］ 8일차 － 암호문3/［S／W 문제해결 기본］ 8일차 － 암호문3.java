import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static LinkedList<Integer> password;
	public static int idx;
	public static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 10개
		for (int tc = 1; tc <= 10; tc++) {
			password = new LinkedList<>();

			int N = sc.nextInt(); // 원본 암호문 개수

			for (int i = 0; i < N; i++) {
				password.add(sc.nextInt());
			} // 원본 암호문 입력받기 끝!

			int M = sc.nextInt(); // 명령어의 개수
			for (int i = 0; i < M; i++) {
				// 명령어 받아오기!
				String command = sc.next();

				switch (command) {

				// "I"는 삽입
				case "I":
					idx = sc.nextInt(); // 삽입할 위치
					cnt = sc.nextInt(); // 삽입할 개수

					// idx 바로 다음부터 cnt개를 삽입 >> 하나 삽입할 때마다 idx++;
					for (int j = 0; j < cnt; j++) {
						password.add(idx, sc.nextInt());
						idx++;
					}
					break;

				// "D"는 삭제
				case "D":
					idx = sc.nextInt(); // 삭제할 위치
					cnt = sc.nextInt(); // 삭제할 개수

					// idx 바로 다음부터 cnt개를 삭제
					for (int j = 0; j < cnt; j++) {
						password.remove(idx + 1);
					}
					break;

				// "A"는 추가
				case "A":
					cnt = sc.nextInt(); // 추가할 개수

					// 맨 뒤애 cnt개의 암호문 추가
					for (int j = 0; j < cnt; j++) {
						password.addLast(sc.nextInt());
					}
					break;

				} // 명령어 switch문

			} // 한 사이클에서 명령어 개수만큼 반복

			// 테스트 케이스 번호 출력
			System.out.print("#" + tc);

			// 수정된 암호문 뭉치의 앞 10개 출력
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + password.get(i));
			}

			System.out.println();

		} // 테스트 케이스 for문

	} // main

} // class
