/*
 * 1은 따로 작성
 * 2-7 		6개의 숫자는 2번 방문
 * 8-19 	12개의 숫자는 3번 방문
 * 20-37 	18개의 숫자는 4번 방문하는 규칙 이용! 
 * */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int cnt = 0;
		int sq = 1;

		if (num == 1)
			System.out.println(1);
		else {

			for (int i = 2; i <= num; i++) {
				cnt++;
				if (cnt > 6 * sq) {
					cnt = 1;
					sq = sq + 1;
				} else if (cnt == 6 * sq) {
					cnt = 6 * sq;
				}
			}
			System.out.println(sq + 1);
		}
	}
}
