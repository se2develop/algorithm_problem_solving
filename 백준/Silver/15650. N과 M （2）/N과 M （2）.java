import java.util.Scanner;

public class Main {
	// 조합
	public static int N;
	public static int R;
	public static int[] arr;
	public static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 전체 개수
		arr = new int[N];
		R = sc.nextInt(); // 뽑을 개수
		sel = new int[R];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		comb(0, 0);

	} // main

	public static void comb(int idx, int sidx) {
		if (sidx == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = arr[i];
			comb(i + 1, sidx + 1);
		}

	} // comb
} // class