import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static class Edge implements Comparable<Edge> {
		int start, end;
		double weight;

		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		// 가중치를 기준으로 정렬해야 되니까 기준 생성
		public int compareTo(Edge e) {
			return Double.compare(this.weight, e.weight);
		}
	} // Edge

	public static int N, M, pick;
	public static double E, ans;
	public static int[][] islands;
	public static List<Edge>[] edges;
	public static boolean[] visited;
	public static PriorityQueue<Edge> pQueue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // 정점의 개수

			islands = new int[N][2]; // 섬의 좌표 받아오기
			for (int i = 0; i < 2; i++) {
				M = 0; // 간선의 개수
				for (int j = 0; j < N; j++) {
					M += j; // 모든 간선의 개수 계산
					islands[j][i] = sc.nextInt();
				}
			}

			E = sc.nextDouble(); // 환경 부담 세율

			edges = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				edges[i] = new ArrayList<Edge>();
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int st = i; // 시작 섬 번호
					int ed = j; // 끝 섬 번호
					double w = dist(islands[st], islands[ed]); // 환경 부담금

					edges[st].add(new Edge(st, ed, w));
					edges[ed].add(new Edge(ed, st, w));
				}
			} // 간선 정보 인접리스트에 저장

			visited = new boolean[N]; // 섬 방문 정보 배열
			pQueue = new PriorityQueue<>(); // 우선순위 큐 사용

			// 0번 섬 부터 시작
			visited[0] = true;
			pQueue.addAll(edges[0]);

			pick = 1; // 뽑은 간선의 개수
			ans = 0; // 최소 환경 부담금

			// MST는 간선의 개수 = 정점의 개수 - 1
			while (pick < N) {
				Edge e = pQueue.poll();

				// 끝 섬이 아직 방문 안했으면
				if (!visited[e.end]) {
					// 간선 선택
					pick++;
					// 가중치 더해주고
					ans += e.weight;
					pQueue.addAll(edges[e.end]);
					visited[e.end] = true;
				}
			}
			System.out.println("#" + tc + " " + Math.round(ans));
		} // tc for문
	} // main

	// 환경 부담금 = 환경 부담 세율(E) * (해저터널의 길이(L) ^ 2)
	public static double dist(int[] stPoint, int[] edPoint) {
		return E * (Math.pow(stPoint[0] - edPoint[0], 2) + Math.pow(stPoint[1] - edPoint[1], 2));
	}
} // class