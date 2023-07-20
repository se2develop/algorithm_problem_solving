import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ans = "";

		for (char x : str.toCharArray()) {
			if (Character.isUpperCase(x))
				ans += Character.toLowerCase(x);
			else
				ans += Character.toUpperCase(x);
		}
		System.out.println(ans);
	}
}