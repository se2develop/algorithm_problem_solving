import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// 중복 순열
	public static int N;
	public static int R;
	public static int[] arr;
	public static boolean[] sel;
	public static int[] ans;
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

		sel = new boolean[N];
		ans = new int[R];

		dperm(0);
		System.out.println(sb);

	} // main

	public static void dperm(int idx) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			ans[idx] = arr[i];
			dperm(idx + 1);
		}
	} // dperm
} // class