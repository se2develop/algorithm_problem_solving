import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] sArr = new long[N];
        long[] cArr = new long[M];
        long ans = 0;

        // 구간 합 배열 저장
        sArr[0] = sc.nextLong();
        for(int i = 1; i < N ; i++) {
            sArr[i] = sArr[i - 1] + sc.nextLong();
        }

        // 합 배열을 M으로 나눈 나머지 값 저장
        for (int i = 0; i < N ; i++) {
            int remain = (int) (sArr[i] % M);
            // 0이면 0~i까지의 구간합이 M으로 나누어 떨어짐
            if(remain == 0) {
                ans++;
            }
            cArr[remain]++;
        }

        for(int i = 0 ; i < M ; i++) {
            // i가 나머지인 인덱스에서 2가지를 뽑는 경우의 수 더하기
            if(cArr[i] > 1) {
                ans = ans + (cArr[i] * (cArr[i] - 1) / 2);
            }
        }
        System.out.println(ans);
    }
}