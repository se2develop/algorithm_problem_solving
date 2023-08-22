import java.util.LinkedList;
import java.util.Scanner;

// LinkedList 자료구조 사용
public class Solution {
	public static LinkedList<Integer> password;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 10개
		for (int tc = 1; tc <= 10; tc++) {
			password = new LinkedList<>();

			int N = sc.nextInt(); // 원본 암호문의 길이

			for (int i = 0; i < N; i++) {
				password.add(sc.nextInt());
			} // 원본 암호문 입력받기

			int M = sc.nextInt(); // 명령어의 개수

			for (int i = 0; i < M; i++) {
				String command = sc.next(); // I 입력받기
				int idx = sc.nextInt(); // 삽입할 위치
				int cnt = sc.nextInt(); // 삽입할 개수

				// cnt개를 차례로 idx뒤에 삽입하므로 하나 삽입할 때마다 idx++;
				for (int j = 0; j < cnt; j++) {
					password.add(idx, sc.nextInt());
					idx++;
				}
			}

			// 테스트 케이스 번호 출력
			System.out.print("#" + tc);

			// 수정된 password 리스트의 처음 10개 숫자 출력
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + password.get(i));
			}

			// 개행문자 출력
			System.out.println();

		} // 테케 for문
		
	} // main

} // Solution