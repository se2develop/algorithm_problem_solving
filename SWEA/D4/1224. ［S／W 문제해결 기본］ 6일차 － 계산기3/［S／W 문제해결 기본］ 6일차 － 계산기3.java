import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static int top;
	public static char[] stack; // 연산자 저장할 스택
	public static int[] stackN; // 피연산자 저장할 스택

	public static void main(String[] args) {
		// 연산자 우선순위 부여(push 할 때)
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // 테스트 케이스의 길이
			String infix = sc.next(); // 중위 표기법 입력받기

			String postfix = ""; // 후위 표기법
			// 1. 중위 -> 후위로 변경
			top = -1;
			stack = new char[N];
			for (int i = 0; i < N; i++) {
				char tmp = infix.charAt(i); // 중위 표기법 한글자씩 읽어오기
				if (tmp - '0' >= 0 && tmp - '0' <= 9) // 읽어온 문자가 피연산자라면
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
									if (stack[top] == '(')
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

			// 2. 후위표기법 >> 계산
			top = -1;
			stackN = new int[postfix.length()];
			for (int i = 0; i < postfix.length(); i++) {
				char tmp = postfix.charAt(i);
				if (tmp - '0' >= 0 && tmp - '0' <= 9) // 읽어온 문자가 피연산자라면
					stackN[++top] = tmp - '0'; // push
				else { // 연산자라면, 순서 중요
					int b = stackN[top--]; // 늦게 들어간게 b
					int a = stackN[top--]; // 일찍 들어간게 a
					int cal = 0;
					if (tmp == '*') {
						cal = a * b;
					} else if (tmp == '/') {
						cal = a / b;
					} else if (tmp == '+') {
						cal = a + b;
					} else if (tmp == '-') {
						cal = a - b;
					}
					stackN[++top] = cal; // 숫자 pop해서 계산하고 결과 다시 push
				}
			}
			// 끝났으면 pop해서 결과 출력
			int ans = stackN[top--];

//			System.out.println("#" + tc + " " + postfix);
			System.out.println("#" + tc + " " + ans);
		}
	}
}
