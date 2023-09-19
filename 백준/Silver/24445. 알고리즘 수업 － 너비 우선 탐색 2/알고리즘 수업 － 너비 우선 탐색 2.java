import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, M, R, order;
	public static ArrayList<Integer>[] graph;
	public static int[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점의 수
		M = sc.nextInt(); // 간선의 수
		R = sc.nextInt(); // 시작 정점
		graph = new ArrayList[N + 1];
		visited = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		} // 입력받기 끝

		// 내림차순 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		order = 1; // 해당 인덱스(노드)방문 순서
		BFS(R);

		// 출력
		for (int i = 1; i < N + 1; i++) {
			sb.append(visited[i] + "\n");
		}
		System.out.println(sb);

	} // main

	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		// 시작 정점 큐에 넣고, 방문순서 1로 저장
		queue.add(node);
		visited[node] = order++;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			// 인접 노드 중 방문하지 않은 노드 탐색
			for (int n : graph[now]) {
				if (visited[n] == 0) {
					visited[n] = order++;
					queue.add(n);
				}
			}
		}

	} // BFS
} // class