import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] white = new int[100][100];

		int T = sc.nextInt();
		int area = 0;
		for (int i = 0; i < T; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			for (int idxr = r; idxr < r + 10; idxr++) {
				for (int idxc = c; idxc < c + 10; idxc++) {
					if (white[idxr][idxc] == 0)
						white[idxr][idxc] = 1;
				}
			}

		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				area += white[i][j];
			}
		}
		System.out.println(area);
	}
}
