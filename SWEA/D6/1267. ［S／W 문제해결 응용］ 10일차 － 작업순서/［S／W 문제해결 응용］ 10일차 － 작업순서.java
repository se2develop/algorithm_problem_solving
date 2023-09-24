import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int V, E, cnt;
	public static List<Integer>[] adjList;
	public static int[] degree;
	public static boolean[] visited;
	public static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			// 정점의 개수
			V = sc.nextInt();
			// 간선의 개수
			E = sc.nextInt();

			adjList = new ArrayList[V + 1];
			for (int i = 1; i < V + 1; i++) {
				adjList[i] = new ArrayList<>();
			} // 초기화

			// 진입 차수 저장
			degree = new int[V + 1];
			// 정점 방문 정보 저장
			visited = new boolean[V + 1];

			for (int i = 0; i < E; i++) {
				// 시작 정점
				int st = sc.nextInt();
				// 끝 정점
				int ed = sc.nextInt();
				// 유향 그래프니까 한 쪽 방향만 추가해줌
				adjList[st].add(ed);
				// 끝 정점의 인접차수 증가
				degree[ed]++;
			} // 인접리스트 정보 입력받기 끝!

			queue = new LinkedList<>();

			// 진입차수가 0인 정점들을 큐에 넣고 방문 정보 기록
			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0) {
					queue.add(i);
					visited[i] = true;
				}
			}

			// 테스트 케이스 번호 출력
			System.out.print("#" + tc + " ");

			// 꺼낸 정점의 개수
			cnt = 0;
			outer: while (!queue.isEmpty()) {
				// 정점을 하나 꺼내서 탐색 시작
				int now = queue.poll();
				cnt++;
				System.out.print(now + " ");

				if (cnt == V) {
					System.out.println();
					break outer;
				}

				// now와 인접한 정점들 중 아직 방문하지 않았으면 진입차수 감소
				for (int i = 0; i < adjList[now].size(); i++) {
					if (!visited[adjList[now].get(i)])
						degree[adjList[now].get(i)]--;

					// 진입차수가 0이 되면 큐에 넣음!
					if (degree[adjList[now].get(i)] == 0)
						queue.add(adjList[now].get(i));
				}
			}

		} // tc for문
	} // main
} // class