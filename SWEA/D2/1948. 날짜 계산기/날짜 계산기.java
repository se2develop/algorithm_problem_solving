import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 각 월의 마지막 날짜 저장하는 배열
		int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int sMonth = sc.nextInt(); // 첫 번째 날짜 -> 월
			int sDay = sc.nextInt(); // 첫 번째 날짜 -> 일
			int eMonth = sc.nextInt(); // 두 번째 날짜 -> 월
			int eDay = sc.nextInt(); // 두 번째 날짜 -> 일

			int ans = 0; // 정답 -> 두 번째 날짜가 첫 번째 날짜의 며칠째인지!

			if (sMonth == eMonth) {
				ans = eDay - sDay + 1;
			} // 두 날짜의 월이 같다면 일 수만 빼주면 됨!
			else {
				// 1) 첫 번째 날짜로부터 다음달까지 남은 일 수 계산
				ans += date[sMonth - 1] - sDay + 1;
				// 2) 두 달 사이의 일 수 계산
				for (int i = sMonth; i <= eMonth - 2; i++) {
					ans += date[i];
				}
				// 3) 두 번째 날짜의 일 수 계산
				ans += eDay;
			}
			System.out.println("#" + tc + " " + ans);
		} // 테스트 케이스만큼 반복

	} 
}

