import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수
		for (int i = 0; i < T; i++) {
			String str = sc.next();
			char[] strarr = new char[str.length()];
			int[] ans = new int[str.length()];
			int con = 0; // 앞에 연속된 O의 개수
			int result = 0;

			for (int j = 0; j < str.length(); j++) {
				strarr[j] = str.charAt(j);
			}
			
			// 0번 자리 먼저 계산
			if (strarr[0] == 'O') {
				ans[0] = 1;
				con = 1;
			}
			 
			// 1번 자리부터 끝까지 연속적인 'O' 고려하여 점수 계산
			for (int j = 1; j < strarr.length; j++) {
				if (strarr[j] == 'O') {
					ans[j] = con + 1;
					con++;
				} else if (strarr[j] == 'X') {
					con = 0;
				}
			}

			for (int idx = 0; idx < ans.length; idx++) {
				result += ans[idx];
			}
			System.out.println(result);

		}
	}
}