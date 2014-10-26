package code;

public class ValidPalindrome {
	public boolean isPalindromeII(String s) {
		s = s.replaceAll("\\W", "");
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		if (sb.toString().equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			char leftc = s.charAt(left);
			while (!isLetter(leftc)) {
				left++;
				if (left > right) {
					break;
				}
				leftc = s.charAt(left);
			}
			leftc = Character.toLowerCase(leftc);
			char rightc = s.charAt(right);
			while (!isLetter(rightc)) {
				right--;
				if (right < left)
					break;
				rightc = s.charAt(right);
			}
			if (right < left)
				break;
			rightc = Character.toLowerCase(rightc);
			if (rightc != leftc) {
				return false;
			} else {
				right--;
				left++;
			}
		}
		return true;
	}

	public boolean isLetter(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
			return true;
		else
			return false;
	}
}
