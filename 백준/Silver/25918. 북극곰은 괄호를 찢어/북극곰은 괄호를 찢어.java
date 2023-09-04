import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static int N, cnt, ans;
	public static Stack<Character> stack, tmpStack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 원하는 문자열 길이

		String tmp = sc.next();
		stack = new Stack<>();
		// 각 경우에 스택에 들어있는 문자열 개수
		cnt = 0;
		// 한 번에 들어가있던 최대 문자열 개수
		// ((( 이였으면 ((())) 최소 3일이 걸리는셈!
		ans = 0;

		// 문자열 길이만큼 반복하면서
		for (int i = 0; i < N; i++) {
			// 스택이 비어있거나, 스택의 top이 i번째 문자열과 같으면 (((( 또는 )))) 등!
			if (stack.isEmpty() || stack.peek() == tmp.charAt(i)) {
				// 스택에 push
				stack.push(tmp.charAt(i));
				cnt++;
			} else { // () )( 모양은 둘이 다르니 pop()되서 사라짐
				if (cnt > ans)
					ans = cnt;
				stack.pop();
				cnt--;
			}
		}

		// 모든 문자열 탐색했는데 스택이 비어있지 않으면 짝이 맞지 않는거임!
		if (!stack.isEmpty())
			System.out.println(-1);
		else
			System.out.println(ans);

	} // main
} // class