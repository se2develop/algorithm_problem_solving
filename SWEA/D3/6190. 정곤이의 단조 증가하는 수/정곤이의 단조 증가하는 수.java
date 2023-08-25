import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 정수의 개수

			int[] num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			} // 정수 입력받기 끝!

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					list.add(num[i] * num[j]);
				}
			} // 입력된 정수 곱해서 list에 저장

			// 단조 증가하는 수 중 최댓값 저장

			int max = 0;
			for (int item : list) {
				int cnt = 0;
				// 한 자리씩 비교하기 위해서 문자열로 변환
				String str = item + "";

				if (str.length() > 1) {
					for (int i = 0; i < str.length() - 1; i++) {

						// 단조 증가하는 수 조건을 만족하면 cnt++
						if (str.charAt(i) <= str.charAt(i + 1)) {
							cnt++;
						}
					}

					// cnt가 (자릿 수 - 1)과 같으면 단조 조건 만족, item
					if (cnt == str.length() - 1 && item > max) {
						max = item;
					}
				}
			}

			if (max == 0)
				System.out.println("#" + tc + " " + -1);
			else
				System.out.println("#" + tc + " " + max);

		} // 테스트케이스 for문

	} // main

} // class