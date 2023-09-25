import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static List<Integer>[] adjList;
	public static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 컴퓨터의 수(정점)
		int M = sc.nextInt(); // 연결 간선의 수

		adjList = new ArrayList[N + 1];

		// 각 컴퓨터에는 1번부터 차례대로 번호가 ~
		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();

			adjList[st].add(ed);
			adjList[ed].add(st);
		} // 연결정보 입력받기 끝

		visited = new int[N + 1];

		BFS(1);

		int ans = 0;
		for (int i = 2; i < N + 1; i++)
			ans += visited[i];

		System.out.println(ans);
	} // main

	public static void BFS(int com) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(com);
		visited[com] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < adjList[now].size(); i++) {
				if (visited[adjList[now].get(i)] == 0) {
					queue.add(adjList[now].get(i));
					visited[adjList[now].get(i)] = 1;
				}
			}
		}
	}
} // class
