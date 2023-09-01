import java.util.Scanner;

public class Solution {
	public static int cntWin; // 규영이가 이기는 경우의 수
	public static int cntLose; // 규영이가 지는 경우의 수
	public static int scoreK, scoreI;
	public static int[] kyu, in;
	public static boolean[] card;
	public static int[] result;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			card = new boolean[18]; // 규영이 선택 정보 저장

			kyu = new int[9]; // 규영이가 가진 카드(순서 고정)
			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				card[kyu[i] - 1] = true; // 규영이가 선택한 카드면 true
			}

			in = new int[9]; // 인영이가 가진 카드(순서 고정X)
			int idx = 0;
			for (int i = 0; i < 18; i++) {
				if (!card[i]) {
					in[idx++] = i + 1;
				}
			}

			result = new int[9]; // 인영이가 카드를 내는 경우의 수
			visited = new boolean[9];
			cntWin = 0; // 규영이가 이긴 횟수
			cntLose = 0; // 규영이가 진 횟수

			perm(0);

			System.out.println("#" + tc + " " + cntWin + " " + cntLose);
		} // tc for문

	} // main

	public static void perm(int idx) {
		if (idx == 9) {
			// 인영이가 내는 카드 순서에 따라 승패 계산
			cal(kyu, result);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i]) // 이미 사용한 원소면 건너뜀
				continue;

			result[idx] = in[i]; // 해당 i번째 원소를 저장
			visited[i] = true; // i번재 원소 사용했다고 표시
			perm(idx + 1);
			visited[i] = false; // 사용여부 원상복구
		}
	} // perm

	public static void cal(int[] arr1, int[] arr2) {
		scoreK = 0;
		scoreI = 0;
		for (int i = 0; i < 9; i++) {
			// 규영이가 이기면
			int score = arr1[i] + arr2[i]; // 이긴사람이 획득한 점수
			if (arr1[i] - arr2[i] > 0) {
				scoreK += score;
			}
			// 인영이가 이기면
			else {
				scoreI += score;
			}
		}

		// 규영이 총점이 더 높으면 규영이가 이긴 횟수 + 1
		if (scoreK > scoreI)
			cntWin++;
		else if (scoreK < scoreI)
			cntLose++;

	} // cal

} // class