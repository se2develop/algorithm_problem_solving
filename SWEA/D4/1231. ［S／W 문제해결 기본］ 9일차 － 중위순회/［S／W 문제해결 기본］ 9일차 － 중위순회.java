import java.util.Scanner;

public class Solution {
	public static int N;
	public static char[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 10개
		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt(); // 트리가 갖는 정점의 총 수
			arr = new char[N + 1]; // 트리의 정보를 저장할 배열

			for (int i = 0; i < N; i++) {
				int idx = sc.nextInt();
				arr[idx] = sc.next().charAt(0);
				// 해당 정점의 자식 정보 >> 필요없음
				String str = sc.nextLine();
			}

			// 테스트 케이스 번호 출력
			System.out.print("#" + tc + " ");
			inorder(1);
			System.out.println();
		} // 테스트 케이스 for문
	} // main

	// 중위 순회 LVR
	public static void inorder(int i) {
		if (i <= N) {
			// 공백이면 그냥 return
			if (arr[i] == ' ')
				return;
//			System.out.print(i + " ");

			inorder(i * 2); // L
			if (arr[i] != ' ')
				System.out.print(arr[i]); // V
			inorder(i * 2 + 1); // R
		}
	} // inorder

} // class