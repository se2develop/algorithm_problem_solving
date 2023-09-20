import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static int[] p; // i가 속한 그룹의 ㄴ루트를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수

		p = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			p[i] = i;
		} // makeSet 대신 대표자 자기자신으로 초기화

		// 간선배열([0]: 시작정점, [1]: 끝정점, [2]: 가중치)
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}

		// 최소신장트리 -> 가중치 기준으로 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		int ans = 0; // MST의 가중치
		int cnt = 0; // 뽑은 간선의 수
		for (int i = 0; i < E; i++) {
			// MST의 간선의 수 = 정점의 개수 - 1
			if (cnt == V - 1)
				break;

			int x = edges[i][0]; // 정점1
			int y = edges[i][1]; // 정점2

			// MST는 사이클이 없어야함 -> 루트가 같으면 사이클 생성됨
			if (findSet(x) != findSet(y)) {
				union(x, y); // 합치고
				ans += edges[i][2]; // 가중치 추가
				cnt++; // 뽑은 간선의 수++
			}
		}
		System.out.println(ans);

	} // main

	public static int findSet(int x) {
		// x가 x가 속한그룹의 루트가 아니라면
		if (x != p[x])
			// 찾아서 저장
			p[x] = findSet(p[x]);
		return p[x];
	} // findSet

	public static void union(int x, int y) {
		p[findSet(y)] = findSet(x);

	}
} // class