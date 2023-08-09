import java.util.Scanner;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 영역 가로세로
			int M = sc.nextInt(); // 파리채 가로세로
			int[][] area = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					area[i][j] = sc.nextInt();
				}
			} // 입력받기 끝!

			int max = 0; // 최대로 죽는 파리 수
			// 경계 넘지 않게 시작점(0,0)부터 (N-M+1,N-M+1)까지 
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0; // 각 영역에서 죽는 파리 수
					// 파리채 크기만큼의 영역의 파리 수 +
					for (int r = i; r < i + M; r++) {
						for (int c = j; c < j + M; c++) {
							sum += area[r][c];
						}
					}
					if (max < sum)
						max = sum;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}