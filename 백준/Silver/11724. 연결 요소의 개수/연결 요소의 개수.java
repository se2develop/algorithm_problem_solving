import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int N, M;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수

		graph = new ArrayList[N + 1]; // 그래프 데이터 저장
		visited = new boolean[N + 1]; // 방문 배열

		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		// 간선의 개수만큼 반복
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 방향이 없으므로 양쪽방향으로 모두 저장
			graph[a].add(b);
			graph[b].add(a);
		}

		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				cnt++;
				DFS(i);
			}
		}
		System.out.println(cnt);

	}

	public static void DFS(int i) {
		if (visited[i]) {
			return;
		}

		visited[i] = true;
		for (int idx : graph[i]) {
			// 인접 노드들 중 방문하지 않은 노드들 방문
			if (visited[idx] == false) {
				DFS(idx);
			}
		}
	}
}