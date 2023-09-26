import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, K;
	public static int[] time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수빈이의 위치
		N = sc.nextInt();
		// 동생의 위치
		K = sc.nextInt();

		time = new int[100001];
		// 만약 둘의 위치가 같으면 바로 찾을 수 있음
		if (N == K) {
			System.out.println("0");
			return;
		}
		BFS(N);

	} // main

	public static void BFS(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		// 수빈이의 위치 queue에 넣고 시작
		queue.add(idx);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			// now가 동생의 위치랑 같으면 그 때의 time을 출력하고 종료
			if (now == K) {
				System.out.println(time[K]);
				return;
			}

			// x-1 탐색
			if (now - 1 >= 0 && now - 1 <= 100000 && time[now - 1] == 0) {
				queue.add(now - 1);
				time[now - 1] = time[now] + 1;
			}
			// x+1 탐색
			if (now + 1 >= 0 && now + 1 <= 100000 && time[now + 1] == 0) {
				queue.add(now + 1);
				time[now + 1] = time[now] + 1;
			}
			// x*2 탐색
			if (now * 2 >= 0 && now * 2 <= 100000 && time[now * 2] == 0) {
				queue.add(now * 2);
				time[now * 2] = time[now] + 1;
			}
		}
	}
} // class
