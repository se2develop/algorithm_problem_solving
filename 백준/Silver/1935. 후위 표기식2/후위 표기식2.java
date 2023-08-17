import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 피연산자 개수
		String postfix = sc.next(); // 후위 표기식
		int top = -1;
		int[] num = new int[N]; // 피연산자에 대응하는 값
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		} // 입력받기 끝

		double[] stackN = new double[postfix.length()];
		for (int i = 0; i < postfix.length(); i++) {
			char tmp = postfix.charAt(i);
			if (Character.isUpperCase(tmp)) {// 읽어온 문자가 영대문자라면
				int value = num[tmp - 'A'];
				stackN[++top] = value; // push
			} else { // 연산자라면, 순서 중요
				double b = stackN[top--]; // 늦게 들어간게 b
				double a = stackN[top--]; // 일찍 들어간게 a
				double cal = 0;
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
		double ans = stackN[top--];

		System.out.printf("%.2f", ans);
	}
}