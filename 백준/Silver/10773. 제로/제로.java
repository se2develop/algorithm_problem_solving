import java.util.Scanner;

public class Main {
	public static int[] stack;
	public static int top = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		stack = new int[K];

		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
			if (num != 0) {
				push(num);
			} else {
				pop();
			}
		}
		int sum = 0; // 재민이가 적어낸 수의 합
		while (!isEmpty()) {
			sum += pop();
		}
		System.out.println(sum);
	}

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		return top == stack.length - 1;
	}

	public static void push(int n) {
		if (isFull()) {
			System.out.println("스택이 가득 찼음!");
			return;
		}
		stack[++top] = n;
	}

	public static int pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있음!");
			return 0;
		}
		return stack[top--];
	}
}