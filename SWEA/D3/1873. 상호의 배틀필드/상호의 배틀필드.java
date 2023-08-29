import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt(); // 게임 맵의 높이
			int W = sc.nextInt(); // 게임 맵의 너비

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int dir = 0; // 현재 바라보고 있는 방향(^: 0, v: 1, <: 2, >: 3)
			int nr = 0, nc = 0; // 현재 전차의 위치

			char[][] map = new char[H][W]; // 게임 맵 상태 저장

			for (int i = 0; i < H; i++) {
				String tmp = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);

					// 현재 전차의 방향 저장
					if (map[i][j] == '^') {
						nr = i;
						nc = j;
						dir = 0;
					} else if (map[i][j] == 'v') {
						nr = i;
						nc = j;
						dir = 1;

					} else if (map[i][j] == '<') {
						nr = i;
						nc = j;
						dir = 2;

					} else if (map[i][j] == '>') {
						nr = i;
						nc = j;
						dir = 3;
					}
				}
			} // 입력받기

			// 전차의 현재 위치, 방향 확인
			// System.out.println(nr + " " + nc + " " + dir);

			Queue<Character> queue = new LinkedList<>();
			int N = sc.nextInt(); // 사용자가 넣을 입력의 개수
			String input = sc.next();

			// 사용자 입력 큐에 저장
			for (int i = 0; i < N; i++) {
				queue.add(input.charAt(i));
			}

			// 입력을 하나씩 꺼내서 수행
			for (int i = 0; i < N; i++) {
				char move = queue.remove();
				int ar = nr, ac = nc;

				switch (move) {
				case 'S':
					outer: while (ar >= 0 && ar < H && ac >= 0 && ac < W && map[ar][ac] != '#' && map[ar][ac] != '*') {
						ar = ar + dr[dir];
						ac = ac + dc[dir];

						if (ar >= 0 && ar < H && ac >= 0 && ac < W && map[ar][ac] == '*') {
							map[ar][ac] = '.';
							break outer;
						}
					}
					break;

				case 'U':
					dir = 0;
					map[nr][nc] = '^';
					if (nr - 1 >= 0 && map[nr - 1][nc] == '.') {
						map[nr - 1][nc] = '^';
						map[nr][nc] = '.';
						nr = nr - 1;
					}
					break;

				case 'D':
					dir = 1;
					map[nr][nc] = 'v';
					if (nr + 1 < H && map[nr + 1][nc] == '.') {
						map[nr + 1][nc] = 'v';
						map[nr][nc] = '.';
						nr = nr + 1;
					}
					break;

				case 'L':
					dir = 2;
					map[nr][nc] = '<';
					if (nc - 1 >= 0 && map[nr][nc - 1] == '.') {
						map[nr][nc - 1] = '<';
						map[nr][nc] = '.';
						nc = nc - 1;
					}
					break;

				case 'R':
					dir = 3;
					map[nr][nc] = '>';
					if (nc + 1 < W && map[nr][nc + 1] == '.') {
						map[nr][nc + 1] = '>';
						map[nr][nc] = '.';
						nc = nc + 1;
					}
					break;

				} // 각 입력에 대한 switch문

			} // 사용자 입력 처리 for문

			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		} // tc for문

	} // solution

} // calss
