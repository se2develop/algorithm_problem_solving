import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int ans = 0; // 단어의 개수

		// 공백의 개수 = 단어의 개수로 생각
		// 단어가 공백으로 시작하거나 끝나지 않으면 (공백의 수 = 단어 개수 - 1) 이므로
		// ans++; 하고 시작!
		if (str.charAt(0) != ' ' && str.charAt(str.length() - 1) != ' ')
			ans++;
		// 양 쪽 끝이 모두 공백이면 (공백의 수 = 단어 개수 + 1) 이므로
		// ans--; 하고 시작!
		if (str.charAt(0) == ' ' && str.charAt(str.length() - 1) == ' ')
			ans--;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				ans++;
		}
		System.out.println(ans);
	}
}
