import java.util.Scanner;

public class Solution {
	public static char[] stack;
	public static int top;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 10개
		for (int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스 길이
			int N = sc.nextInt();
			int ans = 1; // 유효성 여부

			stack = new char[N];
			top = -1;
			// 유효성 여부

			String str = sc.next();
			// N이 홀수이면 괄호 짝이 맞을 수 없으므로 유효하지 않음
			if (N % 2 == 1) {
				ans = 0;
			} else {
				outer: for (int i = 0; i < N; i++) {
					char ch = str.charAt(i);
					// 왼쪽 괄호이면 stack에 push
					if (ch == '(' || ch == '[' || ch == '{')
						push(ch);
					// 오른쪽 괄호이면 pop해서 짝이 맞는지 확인하고
					// 짝이 맞지 않으면 유효하지 않으므로 탈출
					else if (ch == ')' || ch == ']' || ch == '}') {
						char ch2 = pop();
						if (ch == ')') {
							if (ch2 != '(') {
								ans = 0;
								break outer;
							}
						} else if (ch == ']') {
							if (ch2 != '[') {
								ans = 0;
								break outer;
							}

						} else if (ch == '}') {
							if (ch2 != '{') {
								ans = 0;
								break outer;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
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