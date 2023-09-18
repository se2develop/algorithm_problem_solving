import java.util.Scanner;

public class Solution {
	public static int[] gyu, in, tmp;
	public static boolean[] flag, visited;
	public static int gscore, iscore, gwin, glose;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수
		gyu = new int[9]; // 규영이가 갖는 수
		in = new int[9]; // 인영이가 갖는 수
		visited = new boolean[9];
		tmp = new int[9]; // 각 순열을 저장할 배열

		for (int tc = 1; tc <= T; tc++) {
			flag = new boolean[19]; // 규영이가 갖은 수의 정보 저장해서 인영이에게 주려고!
			gwin = 0; // 규영이가 이기는 횟수
			glose = 0; // 규영이가 지는 횟수

			for (int i = 0; i < 9; i++) {
				gyu[i] = sc.nextInt(); // 규영이 카드와 내는 순서를 받으며
				flag[gyu[i]] = true; // 받은 카드 정보를 체크
			}

			// 인영이는 규영이가 갖고있지 않는 수
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (flag[i] == false) { // 규영이가 받지 않은 카드면
					in[idx++] = i; // 인영이에게!
				}
			}

			perm(0); // 계산해보자!
			System.out.println("#" + tc + " " + gwin + " " + glose);

		} // tc for문
	} // main

	public static void perm(int cnt) {
		// 여기서 규영이와 인영이 카드 비교
		if (cnt == 9) {
			// 각 경우 둘의 점수는 0에서 시작
			gscore = 0;
			iscore = 0;
			// 9장의 카드를 비교
			for (int i = 0; i < 9; i++) {
				// 규영이 카드가 크면 규영이가 점수얻고

				if (gyu[i] > tmp[i])
					gscore += gyu[i] + tmp[i];
				// 인영이 카드가 크면 인영이가 점수얻고
				else
					iscore += gyu[i] + tmp[i];
			}

			// 규영이의 점수가 크면
			if (gscore > iscore)
				gwin++; // 이긴횟수++
			// 규영이의 점수가 작으면
			else if (gscore < iscore)
				glose++; // 진횟수++
		}

		// 사용할 수 있는 모든 원소를 체크!
		for (int i = 0; i < 9; i++) {
			if (visited[i]) // 이미 사용했으면 건너뜀
				continue;

			tmp[cnt] = in[i]; // i번째 원소 저장
			visited[i] = true; // 사용여부 표시
			perm(cnt + 1);
			visited[i] = false; // 사용여부 원상복구
		}

	} // perm

} // class