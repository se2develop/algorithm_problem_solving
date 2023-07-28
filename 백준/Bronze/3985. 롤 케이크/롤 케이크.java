import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt(); // 롤케이크 길이
		int N = sc.nextInt(); // 방청객 수
		int idx1 = 0; // 가장 많이 받을 것으로 기대하고 있던 방척객
		int idx2 = 0; // 실제로 가장 많이 받은 방청객
		int max1 = 0;
		int max2 = 0;

		int[] cake = new int[L];
		int[] cnt = new int[L];
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			// 가장 많이 받을 것으로 기대하고 있던 방청객
			int diff = end - start;
			if (max1 < diff) {
				max1 = diff;
				idx1 = i + 1;
			}
			for (int j = start - 1; j < end; j++) {
				if(cake[j] == 0)
				cake[j] = i+1;
			}
		}
		// 실제로 받은 개수 계산
		for (int k = 0; k < L; k++)
			if (cake[k] != 0)
				cnt[cake[k] - 1] += 1;

		for (int i = 0; i < L; i++) {
			if (cnt[i] > max2) {
				max2 = cnt[i];
				idx2 = i + 1;
			}
		}

		// 출력;
		System.out.println(idx1);
		System.out.println(idx2);
	}
}