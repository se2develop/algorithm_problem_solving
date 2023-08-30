import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static int N; // 재료의 수
	public static int L; // 제한 칼로리
	public static int[] cal; // 칼로리
	public static int[] taste; // 맛에 대한 점수
	public static boolean[] sel;
	public static List<Integer> score = new ArrayList<>(); // 제한된 칼로리 이하 조합일 때 점수들 저장
	public static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			taste = new int[N];
			cal = new int[N];
			sel = new boolean[N];

			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			} // 입력받기 끝
			max = 0;
			subset(0);

			System.out.println("#" + tc + " " + max);

		} // 테케 for문

	} // main

	public static void subset(int cnt) {
		// 기저 부분
		if (cnt == N) {
			// sum: 칼로리 조합의 합
			// tmp: 그 때의 맛에 대한 점수의 합
			int sum = 0, tmp = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += cal[i];
					tmp += taste[i];
				}
			}
			// 칼로리 조합의 합이 제한 칼로리 L 이하이면서, 점수 합 최대
			if (sum > 0 && sum <= L && tmp > max) {
				max = tmp;
			}
			return;
		}

		sel[cnt] = false;
		subset(cnt + 1);
		sel[cnt] = true;
		subset(cnt + 1);

	} // subset

} // class
