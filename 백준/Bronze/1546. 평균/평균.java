import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int sum = 0;
        int max = 0;
        int[] score = new int[N];

        for(int i = 0; i < N ; i++) {
            score[i] = sc.nextInt();
            sum += score[i];
            if(score[i] > max)
                max = score[i];
        }

        double avg = ( sum * 100.0 ) / ( max * N );
        System.out.println(avg);
    }
}