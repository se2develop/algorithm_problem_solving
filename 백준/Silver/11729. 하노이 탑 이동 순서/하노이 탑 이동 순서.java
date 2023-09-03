import java.util.Scanner;

public class Main {
	public static int cnt = 0; // 옮긴 횟수
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 원판의 개수

		hanoi(N, 1, 3);

		System.out.println(cnt);
		System.out.println(sb);
	}

	// 기둥번호 1,2,3 (1+2+3=6)
	// 6 - 시작기둥(start) - 목표기둥(end) == 중간기둥
	public static void hanoi(int n, int start, int end) {
		int mid = 6 - start - end;
		if (n == 0)
			return;
		else {
			cnt++;
			if (n > 1)
				hanoi(n - 1, start, mid);
			sb.append(start + " " + end + "\n");
			if (n > 1)
				hanoi(n - 1, mid, end);
		}
	}
}