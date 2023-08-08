import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			// 제한된 덤프 횟수
			int dump = sc.nextInt();
			// 상자의 초기 높이 저장할 배열
			int[] box = new int[100];
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}

			int cnt = 0; // 덤프 횟수
			int minIdx = 0; // 최소높이 위치
			int maxIdx = 0; // 최대높이 위치
			int diff = 0; // 최대높이 - 최소높이 차이

			while (cnt <= dump) {
				int min = 101; // 최소높이
				int max = 0; // 최대높이
				for (int i = 0; i < 100; i++) {
					if (box[i] <= min) {
						min = box[i];
						minIdx = i;
					}
				}
				for (int i = 0; i < 100; i++) {
					if (box[i] >= max) {
						max = box[i];
						maxIdx = i;
					}
				}
				// 최소위치의 박스는 -1, 최대위치의 박스는 +1
				box[minIdx]++;
				box[maxIdx]--;

				// 덤프 횟수 +1
				cnt++;

				diff = max - min;
				// 주어진 덤프 횟수 이내에 평탄화가 완료 되면 끝!
				if (diff == 1 || diff == 0) {
					break;
				}
			}
			System.out.println("#" + tc + " " + diff);
		}

	}
}