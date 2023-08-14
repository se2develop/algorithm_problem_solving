import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			// 찾아야 하는 회문의 길이
			int len = sc.nextInt();
			char[][] area = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					area[i][j] = str.charAt(j);
				}
			} // 입력받기 끝!

			int ans = 0; // 회문의 개수

			// 가로 방향
			// 0행부터 7행까지
			for (int i = 0; i < 8; i++) {
				// 0열부터 8-len열까지
				for (int j = 0; j <= 8 - len; j++) {
					String text = "";
					// len 길이만큼 추출
					for (int k = j; k < j + len; k++) {
						text += area[i][k];
					}
					int cnt = 0;
					// len /2 번 비교해서 같으면 cnt++;
					for (int idx = 0; idx < len / 2; idx++) {
						if (text.charAt(idx) == text.charAt(len - 1 - idx)) {
							cnt++;
						}
					}
					// cnt가 len/2와 같으면 회문임!
					if (cnt == len / 2)
						ans++;
				}

			}

			// 세로 방향
			// 0열부터 7열까지
			for (int i = 0; i < 8; i++) {
				// 0행부터 8-len행까지
				for (int j = 0; j <= 8 - len; j++) {
					String text = "";
					// len 길이만큼 추출
					for (int k = j; k < j + len; k++) {
						text += area[k][i];
					}
					int cnt = 0;
					// len /2 번 비교해서 같으면 cnt++;
					for (int idx = 0; idx < len / 2; idx++) {
						if (text.charAt(idx) == text.charAt(len - 1 - idx)) {
							cnt++;
						}
					}
					// cnt가 len/2와 같으면 회문임!
					if (cnt == len / 2)
						ans++;
				}

			}
			System.out.println("#" + tc + " " + ans);

		}
	}
}