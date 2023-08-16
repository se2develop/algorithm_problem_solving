import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] arr = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(i, str.length());
		}

		// 정렬
		Arrays.sort(arr);
		for (int i = 0; i < str.length(); i++) {
			System.out.println(arr[i]);
		}
	}
}