import java.util.Scanner;

public class Solution {
	public static int[] price, plan;
	public static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			plan = new int[13];

			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			} // 이용권 요금 입력받기

			for (int i = 1; i < 13; i++) {
				plan[i] = sc.nextInt();
			} // 각 달의 이용계획 입력받기

			// 1년권 가격은 1번 -> 최소로 지정해서 비교 시작
			ans = price[3];

			DFS(1, 0);
			System.out.println("#" + tc + " " + ans);
		} // tc for문

	} // main

	public static void DFS(int month, int cost) {
		// 비용 > 최소비용 이면 더이상 탐색할 필요 없음!
		if (cost > ans)
			return;

		// month > 12가 되면 탐색 끝!
		if (month > 12) {
			ans = Math.min(ans, cost);
			return;
		}
		// 1일권 이용
		DFS(month + 1, cost + (plan[month] * price[0]));
		// 1달권 이용
		DFS(month + 1, cost + price[1]);
		// 3달권 이용
		DFS(month + 3, cost + price[2]);
	}
} // class