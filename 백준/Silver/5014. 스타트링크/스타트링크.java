import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int F, G, S, U, D;
	public static boolean[] visited;
	public static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 총 F층
		F = sc.nextInt();
		// 강호의 현재 위치
		S = sc.nextInt();
		// 스타트링크 위치
		G = sc.nextInt();
		// 위로 U층 가는 버튼
		U = sc.nextInt();
		// 아래로 D층 가는 버튼
		D = sc.nextInt();

		visited = new boolean[F + 1];
		cnt = new int[F + 1];
		BFS(S);

	} // main

	public static void BFS(int floor) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(floor);
		visited[floor] = true;
		

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == G) {
				System.out.println(cnt[now]);
				return;
			}

			if (now - D > 0 && now - D <= F && !visited[now - D]) {
				queue.add(now - D);
				visited[now - D] = true;
				cnt[now - D] = cnt[now] + 1;
			}
			if (now + U > 0 && now + U <= F && !visited[now + U]) {
				queue.add(now + U);
				visited[now + U] = true;
				cnt[now + U] = cnt[now] + 1;
			}
		}

		System.out.println("use the stairs");
	} // BFS
} // class
