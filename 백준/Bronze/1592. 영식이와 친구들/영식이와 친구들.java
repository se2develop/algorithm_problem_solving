import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 사람 N명
		int M = sc.nextInt(); // 한 사람이 M번 받으면 게임 끝!

		// 지금까지 던짓횟수가 홀수이면 시계방향으로 L번째 있는 사람에게
		// 짝수이면 반시계방향으로 L번째 있는 사람에게
		int L = sc.nextInt();

		boolean ans = true;
		int total = 0; // 총 던짓 횟수
		int idx = 0; // 현재 공의 위치
		int[] cnt = new int[N]; // 각 사람이 몇 번 던졌는지 저장

		// 시작점
		cnt[0] = 1;

		while (ans != false && M != 1) {
			if (cnt[idx] % 2 == 0) {
				idx = ((idx) + N - L) % N;
				cnt[idx] += 1;
				if (cnt[idx] != M)
					total++;
				else
					ans = false;

			} else if (cnt[idx] % 2 == 1) {
				idx = (idx + L) % N;
				cnt[idx] += 1;
				if (cnt[idx] != M)
					total++;
				else
					ans = false;
			}

		}

		if (M != 1)
			System.out.println(total + 1);
		else
			System.out.println(total);
	}
}