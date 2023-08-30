import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// 순열
	public static int N;
	public static int R;
	public static int[] arr;
	public static boolean[] visited;
	public static int[] ans;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];

		R = sc.nextInt();
		ans = new int[R];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		} // 입력받기 끝
		Arrays.sort(arr);

		perm(0);
		System.out.println(sb);
	} // main

	public static void perm(int idx) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}

		// 재귀파트
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				ans[idx] = arr[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}

	}
}// class