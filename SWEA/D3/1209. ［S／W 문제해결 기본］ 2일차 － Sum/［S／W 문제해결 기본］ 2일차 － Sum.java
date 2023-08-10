import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int tCase = sc.nextInt(); // 테스트케이스 번호
			int arr[][] = new int[100][100]; // 100*100크기의 2차원 배열 생성

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 입력받기 끝!

			int max = 0; // 행, 열, 대각선 별로 합의 최댓값

			// 1) 각 행의 합 & 각 열의 합 계산
			for (int i = 0; i < 100; i++) {
				int sumR = 0; // 각 행의 합
				int sumC = 0; // 각 열의 합
				for (int j = 0; j < 100; j++) {
					sumR += arr[i][j];
					sumC += arr[j][i];
				}
				if (sumR > max)
					max = sumR;
				if (sumC > max)
					max = sumC;
			}

			// 2) 대각선의 합 2개 계산
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < 100; i++) {
				sumA += arr[i][i];
				sumB += arr[i][(arr.length-1) - i];
			}
			if (sumA > max)
				max = sumA;
			if (sumB > max)
				max = sumB;

			// 출력
			System.out.println("#" + tCase + " " + max);
		}
	}
}