import java.util.Scanner;

public class Solution {
	public static void main(String[] args)  {
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

			for (int len = 1; len <= 100; len++) { // 회문의 길이 len
				// 가로
				for (int i = 0; i < 100; i++) { // 0행부터 99행까지 탐색
					for (int j = 0; j <= 100 - len; j++) { // 0열부터 100-len열까지
						String text = "";
						for (int k = j; k < j + len; k++) { // len 길이만큼 추출
							text += area[i][k];
						}
						boolean flag = true; // 회문 여부
						// len / 2 번 비교해서 같지 않으면 false
						for (int idx = 0; idx < len / 2; idx++) {
							if (text.charAt(idx) != text.charAt(len - 1 - idx)) {
								flag = false;
								break;
							}
						}
						// 회문이면 max=len, len이 커지면서 비교 중이므로 대소비교 필요 X
						if (flag) {
							max = len;
						}
					}
				}
				// 세로
				for (int i = 0; i < 100; i++) { // 0행부터 99행까지 탐색
					for (int j = 0; j <= 100 - len; j++) { // 0열부터 100-len열까지
						String text = "";
						for (int k = j; k < j + len; k++) { // len 길이만큼 추출
							text += area[k][i];
						}
						boolean flag = true; // 회문 여부
						// len / 2 번 비교해서 같지 않으면 false
						for (int idx = 0; idx < len / 2; idx++) {
							if (text.charAt(idx) != text.charAt(len - 1 - idx)) {
								flag = false;
								break;
							}
						} 
						// 회문이면 max=len, len이 커지면서 비교 중이므로 대소비교 필요 X
						if (flag) {
							max = len;
						} 
					}
				}
			}
			System.out.println("#" + tc + " " + max);

		}
	}
}