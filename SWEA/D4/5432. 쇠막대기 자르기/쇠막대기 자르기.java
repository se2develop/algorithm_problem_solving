import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 개수
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 괄호 문자열
			String str = sc.next();

			char[] pipe = new char[str.length()];

			int piece = 0; // 잘려진 쇠막대기 조각의 총 개수
			int open = 0; // 레이저를 만날 때 유효한 파이프 개수

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					open++;
				}
				// 파이프가 끝날 떼 piece++;
				else if (str.charAt(i) == ')' && str.charAt(i - 1) != '(') {
					open--;
					piece++;
				}
				// 레이저를 만날 때 open되어 있는 파이프 개수를 piece에 더함
				else if (str.charAt(i) == ')' && str.charAt(i - 1) == '(') {
					open--;
					piece += open;
				}
			}
			System.out.println("#" + tc + " " + piece);
		}
	}
}