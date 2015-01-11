package code;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;
		if (s.length() == 0) {
			int i = 1;
			for (; i < p.length(); i = i + 2) {
				if (p.charAt(i) != '*')
					return false;
			}
			return i == p.length() + 1;
		}
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
				return isMatch(s.substring(1), p.substring(1));
			else
				return false;
		} else {
			if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
				return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
			} else
				return isMatch(s, p.substring(2));
		}
	}

	public static void main(String[] args) {
		boolean x = new RegularExpressionMatching().isMatch("bbbba", ".*a*a");
		System.out.println(x);
	}
}
