import java.util.Scanner;

public class Solution {
	public static int[] receipt;
	public static int top;
	public static int sum;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			// 테스트 케이스마다 새로운 스택 생성
			receipt = new int[100000];
			top = -1;

			// 액수의 개수
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int price = sc.nextInt();
				// 0이면 최근에 썼던 수 지움!
				if (price == 0) {
					pop();
				} // 아니면 해당 수를 작성
				else if (price != 0) {
					push(price);
				}
			}
			int sum = 0; // 재민이가 받아 적은 수의 합
			while (!isEmpty()) {
				sum += pop();
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		return top == receipt.length - 1;
	}

	// 삽입
	public static void push(int price) {
		if (isFull()) {
			System.out.println("스택이 가득 찼음!");
			return;
		}
		receipt[++top] = price;
	}

	// 삭제
	public static int pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있음!");
			return 0;
		}
		return receipt[top--];
	}
}