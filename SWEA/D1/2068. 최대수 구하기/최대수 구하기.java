import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tcase = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= tcase; tc++) {
			int[] arr = new int[10]; 
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}

			int temp = 0; // 값 임시보관 장소
			// 버블정렬 구현
			for (int i = 0; i < 9; i++) {
				for (int j = i + 1; j < 10; j++) {
					if (arr[i] > arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			// 정렬 후 > 최대값은 배열 마지막인덱스
			System.out.println("#" + tc + " " + arr[9]);
		}
	}
}