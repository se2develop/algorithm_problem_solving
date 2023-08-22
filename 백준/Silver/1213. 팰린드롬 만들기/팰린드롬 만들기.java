import java.util.Scanner;

public class Main {
	public static String left = "";
	public static String right = "";
	public static String mid = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name = sc.next(); // 임한수의 영어이름
		int[] cnt = new int[26];

		for (int i = 0; i < name.length(); i++) {
			int idx = (int) name.charAt(i);
			cnt[idx - 65]++;
		}

		// 팰린드롬 불가능 판별 >> 홀수 개인 대문자가 2개 이상이면 팰린드롬 불가능함!
		int impossible = 0;
		int odd = 0; // 홀수 개 위치 저장해놨다가 >> 팰린드롬 출력에 이용
		for (int i = 0; i < 26; i++) {
			if (cnt[i] % 2 == 1) {
				odd = i;
				impossible++;
			}
		}

		if (impossible > 1) {
			System.out.println("I'm Sorry Hansoo");
		} // 팰린드롬 안되면 끝
		else {
			if (name.length() % 2 == 1) {
				// 홀수 개인 단어가 가운데에 들어와야함 !
				mid += (char) (odd + 65);
				cnt[odd]--;

				for (int i = 0; i < 26; i++) {
					// input에 있던 대문자라면
					for (int j = 0; j < cnt[i] / 2; j++) {
						// 개수의 절반만큼 사전순으로 더하고
						left += (char) (i + 65);
					}

				}

				for (int i = left.length() - 1; i >= 0; i--) {
					// 오른쪽은 역순으로 더함
					right += left.charAt(i);
				}
				System.out.println(left + mid + right);
			} // input이 홀수

			if (name.length() % 2 == 0) {
				for (int i = 0; i < 26; i++) {
					// input에 있던 대문자라면
					if (cnt[i] > 0) {
						for (int j = 0; j < cnt[i] / 2; j++) {
							// 개수의 절반만큼 사전순으로 더하고
							left += (char) (i + 65);
						}

					}
				}
				for (int i = left.length() - 1; i >= 0; i--) {
					// 오른쪽은 역순으로 더함
					right += left.charAt(i);
				}
				System.out.println(left + right);
			} // input이 짝수

		} // 팰린드롬 생성 구현

	} // main

} // class