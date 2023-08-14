import java.util.Scanner;

class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 테스트케이스 10개
		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			// 찾을 문자열
			String word = sc.next();
			// 검색할 문장
			String str = sc.next();
			// 찾을 문자열 길이
			int len = word.length();
			int cnt = 0;
			String ans = "";

			for (int i = 0; i <= str.length() - len; i++) {
				ans = str.substring(i, i + len);
				if (ans.equals(word))
					cnt++;
			}
			System.out.println("#" + num + " " + cnt);
		}
	}
}
