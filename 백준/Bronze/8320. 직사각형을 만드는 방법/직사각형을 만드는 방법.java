import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			double cnt = 0; // 약수의 개수
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					cnt += 1;
				}
			}
			ans += Math.ceil(cnt / 2);
		}
        System.out.println(ans);
	}
}