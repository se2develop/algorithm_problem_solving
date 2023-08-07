import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			for (int tc = 1; tc <= 10; tc++) {
				int n = sc.nextInt(); // 건물 개수
				int[] h = new int[n]; // 건물 n개의 높이를 저장할 배열
				for (int i = 0; i < n; i++) {
					h[i] = sc.nextInt();
				}

				int cnt = 0; // 조망권이 확보된 세대의 개수
				for (int i = 2; i < n - 2; i++) {
					int min = 0;
					// 본인건물 기준으로 양옆 2개씩 확인
					if (h[i - 2] < h[i] && h[i - 1] < h[i] && h[i + 1] < h[i] && h[i + 2] < h[i]) {
						int tmp = h[i] - h[i - 2];
						int j = i - 2;
						while (j < i + 3) {
							if (h[i] - h[j] < tmp && h[i] - h[j] > 0)
								tmp = h[i] - h[j];
							min = tmp;
							j++;
						}
					}
					cnt += min;
				}
				System.out.println("#" + tc + " " + cnt);
			}

		
	}
}