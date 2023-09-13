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

		int idx = 0; // num배열 인덱스
		int order = 1; // 지금 간식을 받을 수 있는 순서

		// while문 종료조건
		boolean flag = true;

		outer: while (flag) {
			// 스택이 비어있거나, 스택의 top이 order이 아니면 들어온 순서대로 push
			if (stack.isEmpty() || stack.peek() != order) {
				// idx가 N이 되면 마지막 사람까지 본거니까 탈출
				if (idx == N)
					break outer;

				stack.push(num[idx++]);
			}

			// 스택이 비어있지 않고, top이 order(지금 순서)이면 pop하고 다음순서로
			if (!stack.isEmpty() && stack.peek() == order) {
				stack.pop();
				order++;
			}

			// order이 N + 1이 되면 결과는 nice일 듯
			// 다 pop됐으니까 while문 탈출
			if (order == N + 1)
				flag = false;
		}

		// 스택이 비어있으면 Nice, 아니면 Sad
		if (stack.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");
	}
}