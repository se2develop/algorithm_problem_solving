import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[10]; // 숫자를 저장할 배열
		int[] mod = new int[10]; // 42로 나눈 나머지를 저장할 배열
		int[] cnt = new int[10]; // 서로 값이 같은 개수
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < 10; i++) {
			mod[i] = num[i] % 42;
		}

		// 같은 값이 존재하면 cnt[i]를 1로 변경
		for (int i = 0; i < 9; i++) {
			for(int j = i+1; j< 10; j++) {
				if (mod[i] == mod[j]) {
					cnt[i] = 1;
				}
			}
		}
		for(int i=0; i<10;i++) 
			ans += cnt[i];
		
		System.out.println(10-ans);
	}
}