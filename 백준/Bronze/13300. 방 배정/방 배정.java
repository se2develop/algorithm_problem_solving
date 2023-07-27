import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 참가 학생 수
		int K = sc.nextInt(); // 한 방에 배정 할 수 있는 최대 학생 수
		int[][] student = new int[2][6];

		// 성별, 학년별로 정보 저장
		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			student[gender][grade-1] += 1;
		}

		int ans = 0; // 필요한 방의 개수

		// else if student[i][j]가 0명이면 ans는 증감없음;
		// else if student[i][j] <= K*1 이면 ans += 1;
		// else if student[i][j] <= K*2이면 ans += 2;
		// 배열 12칸 모두 확인 후 
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if (student[i][j] == 0)
					continue;
				else {
					double rcnt = Math.ceil(student[i][j] / (double)K);
					ans += rcnt;
				}
			}
		}
		System.out.println(ans);
	}
}