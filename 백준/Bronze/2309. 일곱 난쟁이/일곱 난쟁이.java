import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int idx = 0;
		int idx1 = 0;
		int idx2 = 0;

		int[] state = new int[9];
		int[] ans = new int[7];

		for (int i = 0; i < state.length; i++) {
			state[i] = sc.nextInt();
			sum += state[i];
		}

		// 위치 찾아내기
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				if ((state[i] + state[j]) == (sum - 100)) {
					idx1 = j;
					idx2 = i;
				}
			}
		}

		// 2개 제외하고 새로운 배열에 값 저장
		for (int i = 0; i < state.length; i++) {
			if (i != idx1 && i != idx2) {
				ans[idx++] = state[i];
			}
		}

		// 오름차순 정렬
		for (int i = 1; i < ans.length; i++) {
			for (int j = 0; j < ans.length - i; j++)
				if (ans[j] > ans[j + 1]) {
					int temp = ans[j];
					ans[j] = ans[j + 1];
					ans[j + 1] = temp;
				}
		}

		// 출력
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}