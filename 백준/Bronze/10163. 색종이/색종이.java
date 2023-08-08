import java.util.Scanner;

public class Main{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 색종이 장 수
		int[][] arr = new int[1001][1001]; // 색종이 놓을 평면

		for (int tc = 1; tc <= N; tc++) {
			int stx = sc.nextInt(); // 시작점 x좌표
			int sty = sc.nextInt(); // 시작점 y좌표
			int width = sc.nextInt(); // 색종이 너비
			int height = sc.nextInt(); // 색종이 높이

			// 색종이 크기만큼 평면 1칸을 tc로 할당
			for (int x = stx; x < stx + width; x++) {
				for (int y = sty; y < sty + height; y++) {
					arr[x][y] = tc;
				}
			}
		} // 색종이 N장 모두 붙이는 for문

		for (int tc = 1; tc <= N; tc++) {
			int area = 0; // 각 색종이가 붙여진 면적
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (arr[i][j] == tc)
						area++;
				}
			}
			System.out.println(area);
		}

	}
}
