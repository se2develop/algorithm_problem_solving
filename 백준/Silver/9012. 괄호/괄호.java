import java.util.Scanner;

public class Main {
	public static char[] stack;
	public static int top;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 개수
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 괄호 문자열
			String str = sc.next();

			stack = new char[str.length()];
			top = -1;

			// stack 여부 판단
			String ans = "YES";

			outer: for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				// 왼쪽 괄호이면 push
				if (ch == '(') {
					push(ch);
				} // 오른쪽 괄호일 때
				else {
					// pop할게 없으면 올바르지 않음
					if (isEmpty()) {
						ans = "NO";
						// pop한게 '('가 아니면 올바르지 않음
					} else {
						char ch2 = pop();
						if (ch2 != '(') {
							ans = "NO";
							break outer;
						}
					}
				}

			}
			// 다 끝냈을 때 스택이 비어있지 않으면 올바르지 않음
			if (!isEmpty())
				ans = "NO";
			System.out.println(ans);
		}

	}

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		return top == stack.length - 1;
	}

	public static void push(char ch) {
		if (isFull()) {
			System.out.println("스택이 가득 찼음!");
			return;
		}
		stack[++top] = ch;
	}

	public static char pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있음!");
			return 0;
		}
		return stack[top--];
	}
}
