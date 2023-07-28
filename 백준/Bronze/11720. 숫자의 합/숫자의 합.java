import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 숫자의 개수
		int n = sc.nextInt();
		String str = sc.next();
		int a = 0;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			// .charAt(idx) 값은 아스키코드
			// 우리가 사용할 int로 바꾸기 위해선 -'0'!
			a = str.charAt(i) - '0';
			ans += a;
		}
		System.out.println(ans);
	}
}