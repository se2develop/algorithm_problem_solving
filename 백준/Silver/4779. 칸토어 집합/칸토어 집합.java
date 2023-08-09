
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            if (N == -1) {
                break;
            }

            int len = (int) Math.pow(3, N);
            char[] result = new char[len];
            for (int i = 0; i < len; i++) {
                result[i] = '-';
            }

            for (int size = 1; size <= len; size *= 3) {
                for (int i = 0; i < len; i += size * 3) {
                    for (int j = i + size; j < i + size * 2 && j < len; j++) {
                        result[j] = ' ';
                    }
                }
            }

            System.out.println(new String(result));
        }
    }
}