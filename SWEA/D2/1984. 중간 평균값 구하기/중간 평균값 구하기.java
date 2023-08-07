import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcase = sc.nextInt();

		for (int tc = 1; tc <= tcase; tc++) {
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			int temp = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = i + 1; j < 10; j++) {
					if (arr[i] > arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				sum += arr[i];
			}
			int ans = (int) Math.round(sum / 8.0);
			System.out.println("#" + tc + " " + ans);
		}
	}
}
