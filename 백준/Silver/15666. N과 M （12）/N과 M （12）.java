import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// 중복 조합
	public static int N;
	public static int R;
	public static int[] arr;
	public static int[] sel;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 전체 개수
		R = sc.nextInt(); // 뽑을 개수

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		sel = new int[R];

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

		int tmp = -1; // 중복 체크해주는 변수
		for (int i = idx; i < arr.length; i++) {
			if (tmp == arr[i])
				continue;
			sel[sidx] = arr[i];
			dcomb(i, sidx + 1);
			tmp = arr[i];
		}
	} // dcomb
} // class
