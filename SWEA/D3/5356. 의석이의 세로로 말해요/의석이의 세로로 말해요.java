import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			// 테스트 케이스 개수
			int tcase = sc.nextInt();
			for (int tc = 1; tc <= tcase; tc++) {
				// 입력의 최대 크기 15 * 15
				char[][] input = new char[5][15];
				for (int i = 0; i < 5; i++) {
					// 문자열을 한 줄씩 읽어서
					String str = sc.next();
					// 한 글자씩 input배열의 요소로 넣어줌
					for (int j = 0; j < str.length(); j++) {
						input[i][j] = str.charAt(j);
					}
                    for (int j = str.length(); j < 15; j++) {
						input[i][j] = '*';
					}
				}

				// 세로로 배열을 출력하는데
				// char의 기본값이 '\u0000'이므로 기본값이 아니면 출력하도록!
				String ans = "";
				for (int i = 0; i < 15; i++) {
					for (int j = 0; j < 5; j++) {
						if (input[j][i] != '*')
							ans += input[j][i];
					}

				}
				System.out.println("#" + tc + " " + ans);
		}
	}
}

