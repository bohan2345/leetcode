package code;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int d = 1000000000;
		int a = x / d, b = x % 10;
		while (a == 0 && d != 0) {
			d = d / 10;
			a = d == 0 ? x : x / d;
		}
		while (d != 0) {
			a = (x / d) % 10;
			d = d / 100;
			b = x % 10;
			x = x / 10;
			if (a != b)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome(12331));
	}
}
