import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	// 순열
	public static int N;
	public static int R;
	public static int[] arr;
	public static boolean[] sel;
	public static int[] ans;
	// LinkedHashSet: 중복 허용X, 입력한 순서대로 출력
	public static Set<String> lhs = new LinkedHashSet<>();

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

		perm(0);
		for (String str : lhs) {
			System.out.println(str);
		}
	} // main

	public static void perm(int idx) {
		if (idx == R) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < R; i++) {
				sb.append(ans[i] + " ");
			}
			lhs.add(sb.toString());
			return;
		}

		// 재귀파트
		for (int i = 0; i < arr.length; i++) {
			if (!sel[i]) {
				ans[idx] = arr[i];
				sel[i] = true;
				perm(idx + 1);
				sel[i] = false;
			}
		}

	} // perm
}// class