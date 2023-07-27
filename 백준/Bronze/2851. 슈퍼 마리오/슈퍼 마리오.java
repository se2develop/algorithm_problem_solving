import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] csum = new int[10]; // 누적 합
		int[] diff = new int[10]; // 100과의 차이 저장
		int min = 100; // 최소 차이나는 값, 100으로 초기화
		int idx = 0; // 최소 차이나는 인덱스 저장

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				csum[i] = sc.nextInt();
			} else {
				int num = sc.nextInt();
				csum[i] = csum[i - 1] + num;
			}
			diff[i] = Math.abs(100 - csum[i]);

			// 100과의 차이 계산에서 최소로 차이나는 합 구하기
			if (diff[i] < min) {
				min = diff[i];
				idx = i;
			} else if (diff[i] == min) {
				idx = i;
			}
		}
		System.out.println(csum[idx]);
	}
}