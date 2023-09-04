import java.util.Scanner;

public class Solution {
	public static int N, dist, ans;
	public static int[][] basic; // 회사, 집의 좌표
	public static int[][] point; // 고객의 좌표
	public static boolean[] sel; // 고객의 좌표 방문 여부
	public static int[] result; // 고객의 좌표 방문 순서

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 고객의 수

			basic = new int[2][2]; // (basic[0][0],basic[1][0]) 회사의 좌표, (basic[0][1],basic[1][1]) 집의 좌표
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					basic[j][i] = sc.nextInt();
				}
			}

			point = new int[2][N]; // 0행: x좌표, 1행: y좌표, 열: 각 고객
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					point[j][i] = sc.nextInt();
				}
			} // 입력받기 끝

			sel = new boolean[N]; // 고객의 좌표 방문 여부
			result = new int[N]; // 고객의 좌표 방문 순서

			ans = 987654321;
			perm(0);
			System.out.println("#" + tc + " " + ans);

		} // tc for문
	} // main

	public static void perm(int idx) {
		if (idx == N) {
			// sum의 초기값 = (회사의 좌표 - 첫 번째 방문한 고객의 좌표)
			int sum = Math.abs(basic[0][0] - point[0][result[0]]) + Math.abs(basic[1][0] - point[1][result[0]]);
			// result 순서대로 고객을 방문하고
			for (int i = 1; i < N; i++) {
				sum += Math.abs(point[0][result[i]] - point[0][result[i - 1]])
						+ Math.abs(point[1][result[i]] - point[1][result[i - 1]]);
			}
			// (마지막 고객의 좌표 - 집의 좌표)
			sum += Math.abs(basic[0][1] - point[0][result[N - 1]]) + Math.abs(basic[1][1] - point[1][result[N - 1]]);
			// 새로 계산한 거리와 ans에 저장된 거리 중 최솟값으로 갱신
			ans = Math.min(ans, sum);
			return;
		}

		// 순열 계산
		for (int i = 0; i < N; i++) {
			if (sel[i])
				continue;
			result[idx] = i;
			sel[i] = true;
			perm(idx + 1);
			sel[i] = false;
		}
	} // perm

} // class