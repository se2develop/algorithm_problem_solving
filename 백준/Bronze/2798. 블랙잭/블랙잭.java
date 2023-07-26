import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int msum = sc.nextInt();
		int[] state = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			state[i] = sc.nextInt();
		}

		int temp = 0;
		int max = 0;

		for (int i = 0; i < cnt - 2; i++) {
			for (int j = i+1; j < cnt - 1; j++) {
				for (int k = j+1; k < cnt; k++) {
					temp = state[i] + state[j] + state[k];
					if(temp <= msum && temp > max) 
						max = temp;
				}
			}
		}
		System.out.println(max);

	}
}