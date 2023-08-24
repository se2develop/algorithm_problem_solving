import java.util.Scanner;

public class Solution {
	public static int[] heap;
	// 값이 마지막으로 push된 위치
	public static int heapSize;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스개수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 수행해야 하는 연산 수

			heap = new int[N + 1]; // 0번 인덱스는 사용하지 않을 것이기 때문에!
			heapSize = 0;

			System.out.print("#" + tc);
			for (int i = 0; i < N; i++) {
				int pop = 0; // heapPop에서 return된 값 저장

				// 연산이 1인지 2인지 입력받기
				int cal = sc.nextInt();
				// 입력받은 연산에 따라 push, pop 실행
				if (cal == 1) {
					// push할 값 입력받기
					int input = sc.nextInt();
					heapPush(input);
				} else if (cal == 2) {
					pop = heapPop();
					System.out.print(" " + pop);
				}

			} // 각 테케마다 연산 수행

			System.out.println();
		} // 테스트케이스 for문

	} // main

	// 삽입
	public static void heapPush(int item) {
		// 마지막 자리에 삽입
		heap[++heapSize] = item;

		// 자식 노드 위치
		int child = heapSize;
		// 부모 노드 위치
		int parent = child / 2;

		// 루트 노드 인덱스가 > 1 , 0번 인덱스는 사용하지 않음
		while (parent > 0 && heap[child] > heap[parent]) {
			// 부모-자식 비교해서 swap
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;

			// 부모 자식 한 레벨 위로 변경
			child = parent;
			parent = child / 2;

		}

	} // heapPush

	// 삭제 > 반환타입은 우리가 관리하고 있는 것과 동일
	public static int heapPop() {
		// 공백 상태이면 -1 return
		if (heapSize == 0)
			return -1;

		// 삭제는 무조건 루트 노드에서만 이뤄짐
		int item = heap[1];

		// 마지막 값을 루트 노드에 저장 >> 완전 이진 트리 유지하기 위해서
		// 그 후에 최대 힙 조건을 만족하는 값과 변경
		heap[1] = heap[heapSize--];

		int parent = 1;
		int child = parent * 2; // 왼쪽 자식 노드

		// 만약 오른쪽 자식노드가 있고, 오른쪽 자식노드의 값이 왼쪽 자식 노드의 값보다 크다면
		if (child + 1 <= heapSize && heap[child] < heap[child + 1])
			child += 1; // 오른쪽 자식 노드로 변경

		// 내려갈 수 있을 때까지 내려보내기
		// 최대 힙은 부모 부모 노드 >= 자식 노드 이므로 그 반대라면
		while (child <= heapSize && heap[parent] < heap[child]) {
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;

			// 부모 자식 한 레벨 아래로 변경
			parent = child;
			child = parent * 2;

			// 동일하게 오른쪽 자식노드 유무와 대소 비교
			if (child + 1 <= heapSize && heap[child] < heap[child + 1])
				child += 1;
		}
		return item;

	} // heapPop

} // class
