import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 전체 좌석 수
		String str = sc.next(); // 좌석 배치 정보
		char[] seat = new char[N]; // 좌석 배치 정보 배열로 저장
		for (int i = 0; i < N; i++) {
			seat[i] = str.charAt(i);
		}
		int cnt = 0; // 연속한 L(커플석)의 개수
		int ans = 1; // 컵홀더 개수(맨 왼쪽 1개)

		// S(일반석)이면 1개 추가
		// L(커플석)이면 cnt % 2, 즉 짝수번째 좌석 옆에만 1개 추가
		for (int i = 0; i < N; i++) {
			if (seat[i] == 'S') {
				ans++;
				cnt = 0;
			} else if (seat[i] == 'L') {
				cnt++;
				if (cnt % 2 == 0)
					ans++;
			}
		}
		if (ans > N)
			System.out.println(N);
		else
			System.out.println(ans);
	}
}