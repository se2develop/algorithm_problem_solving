import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] date = new int[12];
		for (int i = 0; i < 12; i++) {
			if (i == 1) {
				date[i] = 28;
			} else if (i == 3 || i == 5 || i == 8 || i == 10) {
				date[i] = 30;
			} else
				date[i] = 31;
		} // 각 달의 마지막 날짜 배열에 저장

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0; // 두 번째 날짜가 첫 번째 날짜의 며칠째인지

			int sMonth = sc.nextInt(); // 첫 번째 날짜 > 월
			int sDay = sc.nextInt(); // 첫 번째 날짜 > 일
			int eMonth = sc.nextInt(); // 두 번째 날짜 > 월
			int eDay = sc.nextInt(); // 두 번째 날짜 > 일

			// 같은 달이면 일끼리만 빼면 되고
			if (sMonth == eMonth) {
				ans = eDay - sDay + 1;
			}
			// 다른 달이면
			else {
				// 두 번째 날짜의 일 더하고
				ans += eDay;
				// 두 날짜 사이에 있는 달의 모든 일수를 더하고
				for (int i = eMonth - 2; i >= sMonth; i--) {
					ans += date[i];
				}
				// 첫 번째 월의 마지막 날짜에서 - 첫 번째 일 + 1
				ans += date[sMonth - 1] - sDay + 1;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}