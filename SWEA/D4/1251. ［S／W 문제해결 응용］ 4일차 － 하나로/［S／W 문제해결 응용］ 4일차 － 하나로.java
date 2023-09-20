import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static int N, M, idx;
	public static double E, ans;
	public static int[][] islands;
	public static double[][] edges;
	public static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 섬의 개수

			// i번째 섬의 x좌표: islands[i][0], i번째 섬의 x좌표: islands[i][1]
			islands = new int[N][2];

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					islands[j][i] = sc.nextInt();
				}
			} // 섬 좌표 입력 끝!

			E = sc.nextDouble(); // 환경 부담 세율

			M = 0; // 간선의 개수
			for (int i = 1; i < N; i++)
				M += i;

			// 간선배열 [0]:시작 섬의 번호, [1]:끝 섬의 번호, [2]:환경부담금
			edges = new double[M][3];
			idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					edges[idx++][2] = cost(islands[i], islands[j]);
				}
			}

			// 환경부담금 기준 오름차순 정렬
			Arrays.sort(edges, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});

//			for (double[] e : edges) {
//				System.out.println(Arrays.toString(e));
//			}

			p = new int[N + 1]; // 대표자 저장

			for (int i = 1; i < N + 1; i++) {
				p[i] = i;
			} // 기본 대표자는 자기로 초기화

			// 최소 비용 신장트리의 간선의 개수 = 정점의 개수 - 1;
			int cnt = 0; // 뽑은 간선의 수 저장
			idx = 0; // 간선배열 idx
			ans = 0; // 최소 환경부담금 저장
			while (cnt < N - 1) {
				int x = (int) edges[idx][0];
				int y = (int) edges[idx][1];
				// 사이클 생성하지 않기 위해서
				if (findset(x) != findset(y)) {
					union(x, y);
					ans += edges[idx][2];
					cnt++; // 뽑힌 간선 개수 증가
				}
				idx++; // 뽑았든 안뽑았든 간선배열 idx 증가
			}
			System.out.println("#" + tc + " " + Math.round(ans));
		} // tc for문
	} // main

	// 환경 부담금 계산
	public static double cost(int[] a, int[] b) {
		return E * (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
	} // cost

	public static int findset(int x) {
		// x가 자기가 속해있는 그룹의 대표가 아니면
		if (x != p[x])
			// 대표를 찾아서 p[x]에 저장
			p[x] = findset(p[x]);
		return p[x];
	} // findset

	public static void union(int x, int y) {
		// y가 속해있는 그룹의 대표를 x가 속해있는 그룹의 대표로 -> 합집합
		p[findset(y)] = findset(x);

	} // union

} // class
