import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {

			String input = sc.next();

			int ans = 0; // 패턴 마디의 길이

			// 마디 길이는 최대 10
			outer: for (int node = 1; node <= 10; node++) {
				// 0 ~ (node-1)까지 추출한 문자열과
				String str1 = input.substring(0, node);
				// node~(node*2-1)까지 추출한 문자열
				String str2 = input.substring(0 + node, node * 2);
				// 같으면 패턴 마디이므로 for문 탈출
				if (str1.equals(str2)) {
					ans = node;
					break outer;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}