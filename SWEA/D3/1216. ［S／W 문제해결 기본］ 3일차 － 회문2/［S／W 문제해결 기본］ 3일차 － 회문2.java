import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			// 테스트케이스 개수
			int tc = sc.nextInt();
			// 100 * 100 글자판
			char[][] area = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				for (int j = 0; j < 100; j++) {
					area[i][j] = str.charAt(j);
				}
			} // 입력받기

			int max = 0;

			// 100의 길이부터 시작해서 회문을 찾으면 종료!
			outer: for (int len = 100; len > 0; len--) { // 회문의 길이 len
				// 행,열 고정
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j <= 100 - len; j++) {
						// 가로
						boolean vflag = true; // 회문 여부
						// len / 2 번 비교해서 같지 않으면 false
						for (int idx = 0; idx < len / 2; idx++) {
							if (area[i][j + idx] != area[i][j + len - 1 - idx]) {
								vflag = false;
								break;
							}
						}
						// 세로
						boolean hflag = true; // 회문 여부
						// len / 2 번 비교해서 같지 않으면 false
						for (int idx = 0; idx < len / 2; idx++) {
							if (area[j + idx][i] != area[j + len - 1 - idx][i]) {
								hflag = false;
								break;
							}
						}
						if (vflag || hflag) {
							max = len;
							break outer;
						}
					}
				} // 행-열고정
			} // outer for문
			System.out.println("#" + tc + " " + max);
		}
	}
}