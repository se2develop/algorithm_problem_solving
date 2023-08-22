import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static long loss;
	public static long tmp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 운동기구 개수
		long[] mLoss = new long[N]; // 각 운동기구의 근손실 정
		for (int i = 0; i < N; i++) {
			mLoss[i] = sc.nextLong();
		} // 입력받기 끝

		// 근손실정도 오름차순 정렬
		Arrays.sort(mLoss);

		// N이 홀수일 때 > (N/2)-1일 동안 2개, 마지막 날 1개 이용
		if (N % 2 == 1) {
			loss = mLoss[N - 1];
			for (int i = 0; i < N / 2; i++) {
				tmp = mLoss[i] + mLoss[(N - 2) - i];
				if (tmp > loss)
					loss = tmp;
			}
		}

		// N이 짝수일 때 > (N/2)일 동안 2개 이용
		if (N % 2 == 0) {
			loss = mLoss[0] + mLoss[N - 1];
			for (int i = 1; i < N / 2; i++) {
				tmp = mLoss[i] + mLoss[(N - 1) - i];
				if (tmp > loss)
					loss = tmp;
			}
		}
		System.out.println(loss);

	} // main

} // class