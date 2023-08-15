import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정수의 개수
		int N = sc.nextInt();
		int[] arr = new int[N];

		int min = 1000000;
		int max = -1000000;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			if (arr[i] < min)
				min = arr[i];
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.println(min + " " + max);
	}
}
