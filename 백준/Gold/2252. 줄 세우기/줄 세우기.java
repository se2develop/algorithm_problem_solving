import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, M, cnt;
	public static List<Integer>[] adjList;
	public static int[] degree;
	public static boolean[] visited;
	public static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 학생 수
		M = sc.nextInt(); // 키를 비교한 횟수

		adjList = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		degree = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjList[A].add(B);
			degree[B]++;
		} // 방향 있는 그래프

		queue = new LinkedList<>();

		// 초기에 진입차수가 0인 값들 큐에 추가!
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}
		}

		// 출력한 횟수 저장
		cnt = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			System.out.print(now + " ");
			cnt++;
			// 정점의 수만큼 출력하면 return;
			if (cnt == N)
				return;

			// now와 인접한 정점들 중 아직 방문하지 않았으면 진입차수 감소
			for (int j = 0; j < adjList[now].size(); j++) {
				if (!visited[adjList[now].get(j)])
					degree[adjList[now].get(j)]--;

				// 진입차수가 0이 되면 큐에 넣음!
				if (degree[adjList[now].get(j)] == 0) {
					queue.add(adjList[now].get(j));
				}
			}
		}

	} // main
} // class