import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 과목의 수
		int N = sc.nextInt();
		// 선수 조건의 수
		int M = sc.nextInt();

		// 인접리스트
		List<Integer>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 진입차수
		int[] degree = new int[N + 1];
		// 몇 학기 이수 가능인지 저장
		int[] visited = new int[N + 1];

		for (int i = 0; i < M; i++) {
			// 선수 조건 정보 저장
			int st = sc.nextInt();
			int ed = sc.nextInt();

			adjList[st].add(ed);
			degree[ed]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		// 진입 차수가 0인 과목들 큐에 저장
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				queue.add(i);
				visited[i] = 1;
			}
		}

		int cnt = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			cnt++;

			if (cnt == N) {
				for (int i = 1; i < N + 1; i++) {
					System.out.print(visited[i] + " ");
				}
				System.out.println();
				return;
			}

			// 내가 지금 탐색중인 정점과 인접한 정점 중
			for (int i = 0; i < adjList[now].size(); i++) {
				// 아직 방문하지 않았으면
				if (visited[adjList[now].get(i)] == 0) {
					// 진입 차수는 감소시키고
					degree[adjList[now].get(i)]--;
				}

				// 진입차수가 0이 되면 queue에 추가
				if (degree[adjList[now].get(i)] == 0) {
					queue.add(adjList[now].get(i));
					visited[adjList[now].get(i)] = visited[now] + 1;
				}
			}
		}

	} // main
} // class
