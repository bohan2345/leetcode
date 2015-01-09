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
        s = s.trim().toLowerCase();
        if (s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l < r && !isAlpha(s.charAt(l))) {
                l++;
            }
            while (r > l && !isAlpha(s.charAt(r))) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    
    boolean isAlpha(char c) {
        return (c <= 'z' && c >= 'a') || (c >= '0' && c <= '9');
    }
}
