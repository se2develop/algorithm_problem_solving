import java.util.Scanner;

public class Solution {
	public static int N, M, ans;
	public static int[][] town, edges;
	public static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // 창용 마을에 사는 사람의 수
			M = sc.nextInt(); // 서로를 알고 있는 사람의 관계 수
			p = new int[N + 1]; // 무리의 대표 저장

			for (int i = 1; i < N + 1; i++) {
				p[i] = i;
			} // Make-Set

			// 간선배열 -> 가중치 1
			edges = new int[M][2];
			for (int i = 0; i < M; i++) {
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
			} // 서로 알고있는 관계 저장

			for (int i = 0; i < M; i++) {
				int x = edges[i][0];
				int y = edges[i][1];
				
				union(x, y); // 합해줌!

			}

			// 무리의 개수
			ans = 0;
			// 대표자가 == 나 이면 내가 그 무리의 대표
			for (int i = 1; i < N + 1; i++) {
				if (p[i] == i)
					ans++;
			}

			System.out.println("#" + tc + " " + ans);
		} // tc for문
	} // main

	public static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	} // findset

	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	} // union

} // class