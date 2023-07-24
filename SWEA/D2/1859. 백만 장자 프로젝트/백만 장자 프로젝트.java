import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 개수

		for (int test_case = 1; test_case <= T; test_case++) {

			int cnt = sc.nextInt(); // 각 테스트 케이스 내의 자연수 N
			long profit = 0; // 이익
			int max = 0; // 최대 매매가
			int[] price = new int[cnt];

			for (int i = 0; i < cnt; i++) {
				price[i] = sc.nextInt();
			}

			for (int i = cnt - 1; i >= 0; i--) {
				if (max > price[i]) {
					profit += max - price[i];
				} else {
					max = price[i];
				}
			}
			System.out.println("#" + test_case + " " + profit);
		}
		sc.close();
	}
}
