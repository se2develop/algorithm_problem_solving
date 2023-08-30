import java.util.Scanner;

public class Solution {
	public static int N;
	public static int[][] S;
	public static int[] food;
	public static boolean[] sel;
	public static int[] A;
	public static int[] B;
	public static int total;
	public static int tasteA;
	public static int tasteB;
	public static int min;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 식재료의 수
			food = new int[N];
			sel = new boolean[N];

			A = new int[N / 2];
			B = new int[N / 2];
			total = 0; // 전체 시너지의 합
			min = 20000; // 시너지 최댓값으로 초기화

			for (int i = 0; i < N; i++) {
				food[i] = i;
			}

			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					S[i][j] = sc.nextInt();
					total += S[i][j];
				}
			} // 입력받기 끝!

			comb(0, 0);
			System.out.println("#" + tc + " " + min);
		} // tc for문

	} // main

	public static void comb(int idx, int aidx) {
		if (aidx == N / 2) {
			int bidx = 0, diff = 0;
			tasteA = 0;
			tasteB = 0;
			for (int i = 0; i < N; i++) {
				// A 음식에 들어가지 않은 재료 B에 넣어주기
				if (!sel[i]) {
					B[bidx] = food[i];
					bidx++;
				}
			}
			// A와 B가 바뀌어서 겹치는 내용 2번 >> A[0] == 0일 때가 절반
			if (A[0] == 0) {
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < N / 2; j++) {
						tasteA += S[A[i]][A[j]];
						tasteB += S[B[i]][B[j]];
					}
				}
				// A음식과 B음식 맛의 차이
				diff = Math.abs(tasteB - tasteA);
				if (diff < min)
					min = diff;
			}
			return;
		}

		for (int i = idx; i <= N / 2 + aidx; i++) {
			A[aidx] = food[i];
			sel[i] = true;
			comb(i + 1, aidx + 1);
			sel[i] = false;
		}

	} // comb
}// class