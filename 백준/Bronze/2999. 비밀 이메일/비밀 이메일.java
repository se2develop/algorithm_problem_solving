import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int N = str.length();
		char[] temp = new char[N];
		int R = 0;
		int C = 0;
		int rcnt = 0;
		int ccnt = 0;

		for (int i = 1; i <= N; i++) {
			temp[i - 1] = str.charAt(i - 1);
			if (N % i == 0) {
				R = i;
				C = N / R;
			}
			if (R <= C) {
				rcnt = R;
				ccnt = C;
			}
		}

		char[][] pwd = new char[rcnt][ccnt];
		int idx = 0;
		for (int i = 0; i < ccnt; i++) {
			for (int j = 0; j < rcnt; j++) {
				pwd[j][i] = temp[idx++];
			}
		}

		for (int i = 0; i < rcnt; i++) {
			for (int j = 0; j < ccnt; j++) {
				System.out.print(pwd[i][j]);
			}
		}
	}
}
