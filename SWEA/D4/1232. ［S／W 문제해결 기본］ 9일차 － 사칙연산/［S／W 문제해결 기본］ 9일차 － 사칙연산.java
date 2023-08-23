import java.util.Scanner;

public class Solution {
	public static int N;
	public static String[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt(); // 정점의 개수
			sc.nextLine(); // 정수 입력받고 다음 줄로 이동

			tree = new String[N + 1][]; // 정점의 번호를 행 인덱스로 사용

			for (int i = 1; i < N + 1; i++) {
				tree[i] = sc.nextLine().split(" ");
			} // 트리 정보 입력받기 끝!

			// 후위연산으로 계산
			double ans = postorder(tree, 1);

			// 소수점 아래는 버리고 정수로 출력
			System.out.println("#" + tc + " " + (int) ans);
		} // 테스트 케이스 for문

	} // main

	// 후위 순회 LRV
	public static double postorder(String[][] arr, int i) {
		double cal = 0;
		// tree배열의 길이가 2이면 피연산자 >> 값 리턴
		if (arr[i].length == 2)
			return Integer.parseInt(tree[i][1]);

		if (i < N + 1) {
			// L 왼쪽 노드는 트리의 3번째 열에 저장된 정보
			double a = postorder(arr, Integer.parseInt(tree[i][2]));
			// R 오른쪽 노드는 트리의 3번째 열에 저장된 정보
			double b = postorder(arr, Integer.parseInt(tree[i][3]));

			if (arr[i][1].equals("*"))
				cal = a * b;
			else if (arr[i][1].equals("/"))
				cal = a / b;
			else if (arr[i][1].equals("+"))
				cal = a + b;
			else if (arr[i][1].equals("-"))
				cal = a - b;
		}

		return cal;

	} // postorder

} // class