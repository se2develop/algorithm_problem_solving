import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, K, root, check;
	public static ArrayList<Integer>[] tree;
	public static int depth[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 정점의 수
		N = sc.nextInt();
		// 부여된 값 k의 노드의 깊이 출력!
		K = sc.nextInt();

		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		// 간선 정보 -> 부모 정점 p, 자식 정점 c 순서대로 주어짐
		for (int i = 0; i < N - 1; i++) {
			// 부모 정점
			int p = sc.nextInt();
			// 자식 정점
			int c = sc.nextInt();

			// 부모 -> 자식 방향만 기록
			tree[p].add(c);
		}

		
		// 내가 찾아야 할 값이 저장되어 있는 정점의 번호 얻기
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			
			if (n == K) 
				check = i;
		}

		
		// 각 정점의 깊이를 저장
		depth = new int[N];
		// 루트(0번 정점)에 저장된 값
		BFS(0);
	} // main

	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			// 현재 뽑은 정점의 번호가 내가 찾는 번호이면
			if (curr == check) {
				// 그 정점의 깊이를 반환하고 종료
				System.out.println(depth[check]);
				return;
			}

			for (int n : tree[curr]) {
				// 자식 노드들 중 방문 하지 않았으면
				if (depth[n] == 0) {
					queue.add(n);
					// 트리의 깊이 갱신
					depth[n] = depth[curr] + 1;
				}
			}
		}
	} // BFS
} // class
