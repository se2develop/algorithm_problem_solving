import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배달해야 하는 설탕 무게
		int N = sc.nextInt();
		// 가져가야 할 봉지 개수
		int cnt = 0;

		if (N == 4 || N == 7) {
			cnt = -1;
		}
		else if (N % 5 == 0) {
			cnt =  N / 5;
		}
		else if (N % 5 == 1 || N % 5 == 3) {
			cnt = (N / 5) + 1;
		}
		else if (N % 5 == 2 || N % 5 == 4) {
			cnt = (N / 5) + 2;
		}
		System.out.println(cnt);
	}

}
