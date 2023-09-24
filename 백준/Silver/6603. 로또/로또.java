import java.util.Scanner;

public class Main {
	public static int k;
	public static int[] S, sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		outer: while (true) {
			// 집합 S의 원소의 개수
			k = sc.nextInt();

			// 0을 입력받으면 끝남
			if (k == 0)
				break outer;

			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = sc.nextInt();
			} // 집합S 저장

			sel = new int[6];

			comb(0, 0);
			System.out.println();

		}
	} // main

	public static void comb(int idx, int sidx) {
		if (sidx == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i <= k - 6 + sidx; i++) {
			sel[sidx] = S[i];
			comb(i + 1, sidx + 1);
		}
	}
} // class