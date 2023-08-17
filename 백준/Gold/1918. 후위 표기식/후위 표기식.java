import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static int top;
	public static char[] stack; // 연산자 저장할 스택

	public static void main(String[] args) {
		// 연산자 우선순위 부여(push 할 때)
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);

		Scanner sc = new Scanner(System.in);

		String infix = sc.next(); // 중위 표기법 입력받기
		String postfix = ""; // 후위 표기법

		top = -1;
		stack = new char[infix.length()];
		for (int i = 0; i < infix.length(); i++) {
			char tmp = infix.charAt(i); // 중위 표기법 한글자씩 읽어오기
			if (Character.isUpperCase(tmp)) // 읽어온 문자가 피연산자라면
				postfix += tmp; // 그냥 출력
			else { // 피연산자가 아니라면
				if (top == -1) {
					stack[++top] = tmp;
				} // 1) 스택이 공백상태이면 그냥 push
				else {
					// 2-1) 여는 괄호라면
					if (tmp == '(') {
						stack[++top] = tmp;
					} // 2-2) 닫는 괄호라면
					else if (tmp == ')') {
						while (top != -1 && stack[top] != '(') {
							postfix += stack[top--];
						}
						if (top != -1)
							top--; // '(' 는 출력하지 않고 pop만하기
					} else {
						// 3-1) 나보다 우선순위가 낮거나 '('이면 push
						if (stack[top] == '(' || priority.get(stack[top]) < priority.get(tmp)) {
							stack[++top] = tmp;
						} else {
							// 3-2) 나보다 우선순위가 낮을 때 까지 pop, 그 후 push
							while (top != -1 && priority.get(stack[top]) >= priority.get(tmp)) {
								postfix += stack[top--];
								// '('를 만나면 pop 멈추기
								if (top != -1 && stack[top] == '(')
									break;
							}
							stack[++top] = tmp;

						} // 3) 공백이 아니라면 우선순위 확인
					}
				}
			}
		}
		while (top != -1) {
			postfix += stack[top--];
		} // 스택이 공백이 될 때까지 pop
		System.out.println(postfix);
	}
}
