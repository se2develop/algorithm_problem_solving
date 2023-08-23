import java.util.Scanner;

// 계산기 풀었던 것처럼 후위식으로 입력받아서 계산
public class Solution {
	public static int N; // 정점의 개수
	public static String[][] tree; // 사칙연산으로 구성된 트리
	public static int idx; // postfix 배열 인덱스
	public static String[] postfix; // 후위연산식 저장
	public static double[] stack; // 후위연산식 계산할 때 피연산자 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt(); // 정점의 개수
			sc.nextLine(); // 정수 입력받고 다음 줄로 이동
			tree = new String[N + 1][];

			// 테스트 케이스마다 postfix 배열 초기화
			idx = 0;
			postfix = new String[N];
			stack = new double[N];

			tree = new String[N + 1][]; // 정점의 번호를 행 인덱스로 사용

			for (int i = 1; i < N + 1; i++) {
				tree[i] = sc.nextLine().split(" ");
			} // 트리 정보 입력받기 끝!

			// 트리로 표현된 사칙연산 >> 후위연산식으로 변경
			postorder(1);
			
			int top = -1; // 스택 위치 인덱스

			// 후위 연산식 계산
			for (int i = 0; i < N; i++) {
				String str = postfix[i];
				// str이 연산자가 아니라면 양의 정수
				if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
					// 스택에 push
					stack[++top] = Integer.parseInt(str);
				} else {
					// 순서 중요
					double b = stack[top--];
					double a = stack[top--];
					double cal = 0;

					if (str.equals("*")) {
						cal = a * b;

					} else if (str.equals("/")) {
						cal = a / b;

					} else if (str.equals("+")) {
						cal = a + b;

					} else if (str.equals("-")) {
						cal = a - b;
					}

					stack[++top] = cal;

				}
			}
			double ans = stack[top--];
			System.out.println("#" + tc + " " + (int) ans);

		} // 테스트 케이스 for문

	} // main

	// 후위 순회 LRV
	public static void postorder(int i) {
		if (tree[i].length == 2) {
			postfix[idx++] = tree[i][1];
			return;
		}

		if (i < N + 1) {
			postorder(Integer.parseInt(tree[i][2])); // L
			postorder(Integer.parseInt(tree[i][3])); // R
			postfix[idx++] = tree[i][1]; // V

		}

	} // postorder

} // class