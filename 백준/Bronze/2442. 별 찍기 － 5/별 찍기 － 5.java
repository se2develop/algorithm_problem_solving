import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) { // 행 출력
			for (int j = 1; j < n - i; j++) { // 열 출력
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * (i + 1) - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}