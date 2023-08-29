import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		String[] ans = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };

		String[] pwd = new String[8]; // 암호문 저장
		int[] pwdInt = new int[8];

		for (int tc = 1; tc <= T; tc++) {
			String str = "";
			int N = sc.nextInt(); // 배열의 세로 크기
			int M = sc.nextInt(); // 배열의 가로 크기

			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < M; j++) {
					if (tmp.charAt(j) == '1') {
						str = tmp;
						break;
					}
				}
			}
			int start = 0, end = 0;

			outer: for (int i = M - 1; i > 0; i--) {
				if (str.charAt(i) == '1') {
					end = i;
					start = end - 55;
					break outer;
				}
			}

			int idx = 0;
			for (int i = start; i < end; i = i + 7) {
				pwd[idx] = str.substring(i, i + 7);
				idx++;
			} // 암호코드 추출 완료

			for (int i = 0; i < pwd.length; i++) {
				for (int j = 0; j < ans.length; j++) {
					if (pwd[i].equals(ans[j])) {
						pwdInt[i] = j;
					}
				}
			} // 암호코드 숫자로 변환

			int cal = 0, sum = 0;

			for (int i = 0; i < pwdInt.length; i++) {
				sum += pwdInt[i];
				// 홀수자리이면 += 암호코드 * 3
				if ((i + 1) % 2 == 1) {
					cal += pwdInt[i] * 3;
				} else { // 짝수자리이면 그냥 더함
					cal += pwdInt[i];
				}
			}

//			System.out.println(Arrays.toString(pwd));
//			System.out.println(Arrays.toString(pwdInt));
//			System.out.println(cal);
			// cal의 결과가 10의 배수이면 올바른 암호코드
			if (cal % 10 == 0) {
				System.out.println("#" + tc + " " + sum);
			} else {
				System.out.println("#" + tc + " 0");
			}

		} // tc for문

	} // main

} // class