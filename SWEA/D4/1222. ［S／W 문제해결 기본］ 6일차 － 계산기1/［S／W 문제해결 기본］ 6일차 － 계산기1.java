import java.util.Scanner;

public class Solution {
	// + 연산자 하나라 우선순위 모두 동일, 앃이는 경우가 없음
	public static char[] stack;
	public static int top;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // 문자열 계산식의 길이
			String infix = sc.next(); // 중위 표기법 입력받기

			String postfix = ""; // 후위 표기법

			// 1. 중위 -> 후위로 변경
			top = -1;
			stack = new char[2];
			for (int i = 0; i < N; i++) {
				char tmp = infix.charAt(i); // 중위 표기법 한글자씩 읽어오기
				if (tmp - '0' >= 0 && tmp - '0' <= 9) // 읽어온 문자가 피연산자라면
					postfix += infix.charAt(i); // 그냥 출력
				else if (tmp == '+') { // 읽어온 문자가 연산자라면(+ 하나뿐)
					if (isEmpty()) {
						push(tmp);
					} // 1) 스택이 공백상태이면 그냥 push
					else {
						postfix += pop();
						push(tmp);
					} // 2) 공백이 아니라면 우선순위 확인(여기선 + 하나)
				}
			}
			while (!isEmpty()) {
				postfix += pop();
			} // 스택이 공백이 될 때까지 pop

			// 2. 후위표기법 >> 계산
			top = -1;
			stack = new char[2];
			for (int i = 0; i < N; i++) {
				char tmp = postfix.charAt(i);
				if (tmp - '0' >= 0 && tmp - '0' <= 9) // 읽어온 문자가 피연산자라면
					push(tmp); // push
				else if (tmp == '+') { // 연산자라면
					// 순서 중요 (a + b)
					int b = pop() - '0'; // 늦게 들어간게 b
					int a = pop() - '0'; // 일찍 들어간게 a
					char sum = (char) (a + b + '0'); // 연산 후 char 변환
					push(sum); // 연산결과 다시 push
				}
			}
			// 끝났으면 pop해서 결과 출력
			int ans = pop() - '0';

			System.out.println("#" + tc + " " + ans);
		} // 테스트 케이스만큼 반복

	}

	// 빈 스택인지 확인
	public static boolean isEmpty() {
		return top == -1;
	}

	// 가득찼는지 확인
	public static boolean isFull() {
		return top == stack.length - 1;
	}

	public static void push(char ch) {
		if (isFull()) {
			System.out.println("스택이 가득 찼습니다!");
			return;
		}
		stack[++top] = ch;
	}

	public static char pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다!");
			return 0;
		}
		return stack[top--];
	}
}