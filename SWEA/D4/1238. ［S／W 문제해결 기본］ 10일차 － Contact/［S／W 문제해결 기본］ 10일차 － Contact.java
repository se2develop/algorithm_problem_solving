import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int start, len, ans;
	public static List<Integer>[] graph;
	public static int[] depth;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			// 데이터의 길이
			len = sc.nextInt();
			// 데이터의 시작점
			start = sc.nextInt();

			graph = new ArrayList[101];
			depth = new int[101];

			for (int i = 1; i < 101; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < len / 2; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();

				// 방향이 있는 그래프
				graph[st].add(ed);
			} // 그래프 정보 입력받기

			depth[start] = 1;
			BFS(start);

			int max = 0;
			for (int i = 0; i < 101; i++) {
				if (depth[i] >= max) {
					max = depth[i];
					ans = i;
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // tc for문
	} // main

	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();

		// 큐에 시작점 추가
		queue.add(node);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < graph[now].size(); i++) {
				// 인접한 사람 중 아직 연락을 받지 못한 사람이라면
				if (depth[graph[now].get(i)] == 0) {
					queue.add(graph[now].get(i));
					depth[graph[now].get(i)] = depth[now] + 1;
				}
			}
		}
	} // BFS
} // class