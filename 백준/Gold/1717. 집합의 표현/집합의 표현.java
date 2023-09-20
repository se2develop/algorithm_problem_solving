import java.util.Scanner;

public class Main {
	public static int n, m, cal, x, y;
	public static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 집합의 개수
		m = sc.nextInt(); // 입력으로 주어지는 연산의 개수

		p = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			p[i] = i;
		} // Make-Set 연산

		for (int i = 0; i < m; i++) {
			cal = sc.nextInt(); // 연산 종류(0:합집합, 1:두 원소가 같은 집합에 포함되어 있는지 확인)
			x = sc.nextInt(); // 원소1
			y = sc.nextInt(); // 원소2

			switch (cal) {
			case 0:
				// 두 원소가 속해있는 집합을 합하기!
				union(x, y);
				break;
			case 1:
				// 두 원소의 대표가 같으면
				if (findset(x) == findset(y))
					// 같은 집합에 속해있으니까 1
					System.out.println("YES");
				// 아니면 0
				else
					System.out.println("NO");
				break;
			}
		} // m개의 연산 수행

	} // main

	public static int findset(int x) {
		// x가 대표가 아니라면
		if (x != p[x])
			// ((x가 속해있는 집합의 대표)가 속해있는 집합의 대표)를 저장
			p[x] = findset(p[x]); // 효율성 증가
		return p[x];
	} // findset

	public static void union(int x, int y) {
		// y의 대표에 x가 속해있는 집합의 대표를 넣음!
		p[findset(y)] = findset(x);
	} // union
} // class