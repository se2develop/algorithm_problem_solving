import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		class A {
			int result;

			public int onoff(int n) {
				if (n == 0)
					result = 1;
				else if (n == 1)
					result = 0;
				return result;
			}
		}
		A a = new A();
		Scanner sc = new Scanner(System.in);

		// 입력받기
		// 스위치 개수
		int switchN = sc.nextInt(); // 스위치 개수
		// 스위치 상태 저장(On:1,Off:0)
		int[] state = new int[switchN];
		for (int i = 0; i < switchN; i++) {
			state[i] = sc.nextInt();
		}

		// 학생 수
		int studentN = sc.nextInt();
	
		for (int i = 0; i < studentN; i++) {
			// 학생 성별, 받은 스위치 번호 저장
			int gender = sc.nextInt();
			int point = sc.nextInt();
			if (gender == 1) {
				for (int idx = 0; idx < switchN; idx++) {
					if ((idx + 1) % point == 0) {
						state[idx] = a.onoff(state[idx]);
					}
				}
			} else if (gender == 2) {
				int idx = point - 1;
				int dist = 1;
				boolean con = true;
				state[idx] = a.onoff(state[idx]);
				while (con) {
					if (((idx - dist) >= 0) && ((idx + dist) < switchN) && state[idx - dist] == state[idx + dist]) {
						state[idx - dist] = a.onoff(state[idx - dist]);
						state[idx + dist] = a.onoff(state[idx + dist]);
						dist += 1;
					} else
						con = false;
				}

			}
		}
		for (int i = 0; i < switchN; i++) {
			System.out.print(state[i] + " ");
			if (i % 20 == 19) {
				System.out.println();
			}
		}
	}
}