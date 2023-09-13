import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static int N;
	public static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 승환이 앞에 서있는 학생의 수
		N = sc.nextInt();
		int num[] = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		} // 입력받기 끝

		int idx = 0;
		int order = 1;
		boolean flag = true;

		outer: while (flag) {
			// 스택이 비어있거나, 스택의 top이 order이 아니면 들어온 순서대로 push
			if (stack.isEmpty() || stack.peek() != order) {
				if (idx == N)
					break outer;
				stack.push(num[idx++]);
			}

			// 스택이 비어있지 않고, top이 order(지금 순서)이면 pop하고 다음순서로
			if (!stack.isEmpty() && stack.peek() == order) {
				stack.pop();
				order++;
			}

			if (order == N + 1)
				flag = false;
		}

		if (stack.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");
	}
}