import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static int N, K, idx, tmp;
	public static String str;
	public static String[][] rotation;
	public static List<Integer> arr; // 생성 가능한 수 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 숫자의 개수
			K = sc.nextInt(); // 크기 순서
			str = sc.next(); // 16진수 숫자
			idx = N / 4; // 한 변에 들어가는 숫자의 개수
			rotation = new String[idx][4];
			arr = new ArrayList<>();

			// 한 변에 저장되는 숫자 개수 만큼 회전하는 것이 나올 수 있는 모든 경우의 수
			for (int i = 0; i < idx; i++) {
				for (int j = 0; j < 4; j++) {
					// 입력받은 문자열을 N/4개씩 잘라서 저장
					rotation[i][j] = str.substring(idx * j, idx * (j + 1));
					// 16진수로 변환
					int tmp = Integer.parseInt(rotation[i][j], 16);

					// 중복없어야 하니까 contain하고있지 않으면 추가
					if (!arr.contains(tmp))
						arr.add(tmp);
				}
				// 회전시킬때마다 가장 마지막에 있는 숫자가 맨 앞으로 오는 것 구현
				str = str.substring(N - 1) + str.substring(0, N - 1);
			}

			Collections.sort(arr); // 오름차순 정렬

			int cnt = 0; // K번째 잧기위한 cnt변수
			// 뒤에서 부터 탐색해서 K번째 출력
			for (int i = arr.size() - 1; i >= 0; i--) {
				cnt++;
				// K번째로 큰 값일 때
				if (cnt == K) {
					// 출력하고 종료
					System.out.println("#" + tc + " " + arr.get(i));
					break;
				}
			}

		} // tc for문

	} // main

} // class
