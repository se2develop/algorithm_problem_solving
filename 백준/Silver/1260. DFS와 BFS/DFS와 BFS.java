import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, M, V;
	public static int a, b;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 노드의 개수
		M = sc.nextInt(); // 간선의 개수
		V = sc.nextInt(); // 시작할 정점의 번호

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		// 간선은 양방향
		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}

		// 방문할 수 있는 정점이 여러 개인 경우 정점 번호가 작은 것부터 방문 -> 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1]; // visited배열 초기화
		DFS(V); // DFS
		System.out.println(); // 줄바꿈
		visited = new boolean[N + 1]; // visited배열 초기화
		BFS(V); // BFS
	} // main

	public static void DFS(int node) {
		// 방문한 노드의 방문배열값을 true로 바꾸고
		visited[node] = true;
		// 출력(방문했다는 의미)
		System.out.print(node + " ");
		// 인접 노드 중 방문하지 않은 노드 방문 DFS
		for (int idx : graph[node]) {
			if (visited[idx] == false)
				DFS(idx);
		}
	} // DFS

	public static void BFS(int node) {
		// BFS는 선입선출, 큐로 구현
		Queue<Integer> queue = new LinkedList<Integer>();
		// 방문한 노드를 큐에 삽입하고
		queue.add(node);
		// 방문배열값을 true로 바꿈
		visited[node] = true;

		// 큐에 노드가 없을 때 까지 반복
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			// 출력
			System.out.print(currentNode + " ");
			// 인접 노드 중 방문하지 않은 노드 방문 BFS
			for (int idx : graph[currentNode]) {
				if (visited[idx] == false) {
					visited[idx] = true;
					queue.add(idx);
				}
			}
		}
	} // BFS

} // class
