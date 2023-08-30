import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// 조합
	public static int N;
	public static int R;
	public static int[] arr;
	public static int[] ans;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 전체 개수
		R = sc.nextInt(); // 뽑을 개수
		arr = new int[N];
		ans = new int[R];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		comb(0, 0);
		System.out.println(sb);
		
	} // main

	public static void comb(int idx, int sidx) {
		if (sidx == R) {
			for (int i = 0; i < R; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		// 중복 비교해주는 변수
		int tmp = -1;
		for (int i = idx; i <= N - R + sidx; i++) {
//			System.out.println(i + " " + sidx + " " + tmp + " " + arr[i]); 로직 확인
			if (tmp == arr[i])
				continue;
			ans[sidx] = arr[i];
			comb(i + 1, sidx + 1);
			tmp = arr[i];
		}
	} // comb
} // class
