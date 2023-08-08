import java.util.Scanner;

class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tcase = sc.nextInt();

		for (int tc = 1; tc <= tcase; tc++) {
			// 테스트 케이스 번호
			int order = sc.nextInt();

			// 1000명의 점수를 받아올 배열
			int[] score = new int[1000];
			for (int i = 0; i < 1000; i++) {
				score[i] = sc.nextInt();
			}

			// 각 점수에 해당하는 빈도 수 계산
			int[] cnt = new int[101];
			for (int i = 0; i < 1000; i++) {
				cnt[score[i]]++;
			}

			int max = -1; // 최대 빈도
			int mode = 0; // 최대 빈도에 해당하는 수

			for (int i = 0; i < 101; i++) {
				if (cnt[i] >= max) {
					max = cnt[i];
					mode = i;
				}
			}
			System.out.println("#" + order + " " + mode);
		}
	}
}