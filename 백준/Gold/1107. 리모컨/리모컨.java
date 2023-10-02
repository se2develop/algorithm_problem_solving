import java.util.Scanner;

public class Main {
	public static int N, M, len, ans;
	public static boolean[] btn;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수빈이가 이동하려고 하는 채널번호
		N = sc.nextInt();
		// 고장난 버튼의 개수
		M = sc.nextInt();

		// 0-9 버튼 누를 수 있는 여부 저장
		btn = new boolean[10];
		for (int i = 0; i < M; i++) {
			int idx = sc.nextInt();
			// 고장난 버튼 기록
			btn[idx] = true;
		}

		// 버튼을 누르는 최소 횟수
		ans = Math.abs(N - 100);

		for (int i = 0; i < 1000001; i++) {
			// 숫자 버튼으로 이동가능한 채널번호 여부
			boolean flag = check(i);

			// 이동 가능한 채널이면!
			if (flag) {
				// 현재번호에서 (+ / -) 누르는 횟수 + 채널번호 자릿 수
				ans = Math.min(ans, Math.abs(i - N) + len);
			}
		}

		// 정답 출력
		System.out.println(ans);

	} // main

	public static boolean check(int A) {
		// 누른 채널 번호의 자릿 수
		len = String.valueOf(A).length();
		if (A == 0) {
			if (!btn[0])
				return true;
			else
				return false;
		}

		int position = len;
		// 한자리씩 보면서 누를 수 있는 번호인지 탐색
		while (position > 0) {
			// 일의자리부터 탐색
			int tmp = (int) (A % 10);

			// 누를 수 있는 번호면 A = A/10;
			if (!btn[tmp]) {
				A /= 10;
				position--;
			}
			// 누를 수 없으면 false
			else
				return false;
		}
		// 여기까지 왔으면 누를 수 있는 채널번호
		return true;
	} // check
} // class