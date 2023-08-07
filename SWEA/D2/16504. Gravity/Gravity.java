import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		// 낙차가 큰 값을 구해라
		// 2차원으로 생긴 것 처럼 보이지만 실제로 1차원이라고 봐도 무방함 !!
		// 실제로 회전할 필요 없음!

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // 테스트 케이스 개수

		for (int i = 1; i <= tc; i++) { // 테스트 케이스 개수 만큼 반복
			int n = sc.nextInt(); // 방의 가로 길이
			int[] box = new int[n]; // 각 방에 쌓여 있는 상자의 수
			for (int j = 0; j < n; j++) {
				box[j] = sc.nextInt();
			}
			int max = 0;
			for (int j = 0; j < n - 1; j++) {
				int diff = 0; // 그 때의 낙차를 계산해서 max와 비교
				for (int k = j + 1; k < n; k++) {
					if (box[j] > box[k]) {
						diff++;
					}
				}
				if (max < diff) {
					max = diff;
				}
			}
			System.out.println("#" + i + " " + max);
		}
		sc.close();
	}
}