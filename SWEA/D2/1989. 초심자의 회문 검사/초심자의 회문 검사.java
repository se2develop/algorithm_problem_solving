import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int len = str.length();
			int cnt = 0;

			for (int i = 0; i < len / 2; i++) {
				// (0,len-1), (1,len-2), ... 같으면 cnt++
				if (str.charAt(i) == str.charAt(len - 1 - i)) {
					cnt++;
				}
			}
			// 홀수더라도 가장 가운데는 비교할 필요 없으므로 cnt == 1en/2
			if (cnt == len / 2) {
				System.out.println("#" + tc + " 1");
			} else
				System.out.println("#" + tc + " 0");
		}
	}
}