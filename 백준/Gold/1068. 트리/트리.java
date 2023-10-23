import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, root, num, ans;
	public static ArrayList<Integer>[] tree;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 노드의 개수 (50보다 작거나 같은 자연수)
		N = sc.nextInt();

		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			int parent = sc.nextInt();
			// 부모가 -1이라면 루트
			if (parent == -1)
				root = i;
			else {
				tree[parent].add(i);
			}
		} // 트리 정보 저장

		// 노드 방문 정보 저장
		visited = new boolean[N];

		// 지울 노드의 번호
		num = sc.nextInt();
		// 지우기 시작 !!
		Delete(num);
//		// true 바뀐 노드들이 지워진거임!
//		System.out.println(Arrays.toString(visited));
		// 루트부터 전체 탐색하면서 리프노드 찾기 -> N이 1일 때 고려
		if(!visited[root])
			Search(root);
		System.out.println(ans);

	} // main

	// BFS 개념 사용
	public static void Delete(int num) {
		Queue<Integer> queue = new LinkedList<>();

		// num부터 하위 연결된 노드 전부 지우기 -> 방문 처리
		queue.add(num);
		visited[num] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int tmp : tree[curr]) {
				if (!visited[tmp]) {
					visited[tmp] = true;
					queue.add(tmp);
				}
			}
		}
	} // Delete

	// DFS 개념 사용
	public static void Search(int num) {
		// 1. 내가 가진 자식 노드가 이미 다 방문처리가 되어 있으면 -> 삭제된 거니까 리프노드
		int tmp = 0;
		for (int n : tree[num]) {
			if (visited[n])
				tmp++;
		}

		if (tmp == tree[num].size())
			ans++;

		for (int n : tree[num]) {
			// 2. 자식 노드가 있을 때
			if (!visited[n]) {
				visited[n] = true;
				// 그 자식노드가 더 이상 연결되어 있지 않으면 리프노드임
				if (tree[n].size() == 0)
					ans++;
				// 아니면 깊이 탐색
				else
					Search(n);
			}
		}

	} // Search
} // class