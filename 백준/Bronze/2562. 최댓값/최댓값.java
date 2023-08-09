import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int arr[] = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		int arr2[] = new int[9];
		for (int i = 0; i < 9; i++) {
			arr2[i] = arr[i];
		}

		int temp = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(arr[8]);
		for (int i = 0; i < 9; i++) {
			if (arr2[i] == arr[8])
				System.out.println(i + 1);
		}

	}
}