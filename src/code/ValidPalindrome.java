package code;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.replaceAll("\\W", "");
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		if (sb.toString().equals(s)) {
			return true;
		} else {
			return false;
		}
	}
}
