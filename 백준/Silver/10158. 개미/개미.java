import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt(); // 격자 가로 길이
		int h = sc.nextInt(); // 격자 세로 길이

		int p = sc.nextInt(); // 초기 x좌표
		int q = sc.nextInt(); // 초기 y좌표

		int t = sc.nextInt(); // 개미가 움직일 시간

		// t가 2 * w, 2 * h만큼 지나면 제자리로 좌표가 돌아옴!

		// 가로(0 <= nr < 2*w)
		int nr = (p + t) % (2 * w);

		if (nr <= w) { // nr <= w이면, x좌표가 우방향으로 이동중
			p = nr;
		} else { // 아니면 x좌표가 좌뱡항으로 이동중
			p = 2 * w - nr;
		}

		// 세로가로(0 <= nc < 2*h)
		int nc = (q + t) % (2 * h);

		if (nc <= h) { // nc <= h이면, y좌표가 상방향으로 이동중
			q = nc;
		} else { // 아니면 x좌표가 좌뱡항으로 이동중
			q = 2 * h - nc;
		}

		System.out.println(p + " " + q);
	}
}