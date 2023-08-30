import java.util.Scanner;

public class Main {
	// 중복조합
	public static int N;
	public static int R;
	public static int[] arr;
	public static int[] sel;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 전체 개수
		arr = new int[N];
		R = sc.nextInt(); // 뽑을 개수
		sel = new int[R];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		dcomb(0, 0);
		System.out.println(sb);
	} // main

	public static void dcomb(int idx, int sidx) {
		if (sidx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[sidx] = arr[i];
			dcomb(i, sidx + 1);
		}

	} // comb

} // class