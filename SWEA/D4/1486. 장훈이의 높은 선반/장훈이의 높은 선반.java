import java.util.Scanner;

public class Solution {
	public static int N, B, ans;
	public static int[] H;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 점원의 수
			B = sc.nextInt(); // 탑의 최소 높이

			H = new int[N];
			visited = new boolean[N];

			ans = 987654321; // 높이가 B이상인 탑 중 가장 최소 높이
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			} // 입력받기 끝!

			subset(0);
			System.out.println("#" + tc + " " + (ans - B));
		} // tc for문

	} // main

	public static void subset(int idx) {
		if (idx == N) {
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				// visited[i]가 true인 직원들의 높이를 tmp에 저장
				if (visited[i])
					tmp += H[i];
			}
			// tmp가 B이상이고, ans보다 작으면 갱신
			if (tmp >= B && tmp < ans)
				ans = tmp;
			return;
		}

		// 부분집합 구하기
		visited[idx] = true;
		subset(idx + 1);
		visited[idx] = false;
		subset(idx + 1);
	} // subset
} // class