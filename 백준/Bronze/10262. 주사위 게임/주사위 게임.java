import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 꿍의 주사위 2개의 최소-최대값
		int[] A = new int[4];
		for (int i = 0; i < 4; i++) {
			A[i] = sc.nextInt();
		}

		// 석의 주사위 2개의 최소-최대값
		int[] B = new int[4];
		for (int i = 0; i < 4; i++) {
			B[i] = sc.nextInt();
		}

		// 두 명의 주사위의 최소-최대값의 차
		int[] diff = new int[4];
		int win = 0;
		for (int i = 0; i < 4; i++) {
			diff[i] = B[i] - A[i];
			win += diff[i];
		}

		// 석 - 꿍
		if (win > 0)
			System.out.println("Emma"); // 양수면 석이 승률이 높고
		else if (win == 0)
			System.out.println("Tie"); // 같으면 동률
		else
			System.out.println("Gunnar"); // 음수면 꿍의 승률이 높음
	}
}