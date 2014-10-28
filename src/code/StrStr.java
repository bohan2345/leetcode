package code;

public class StrStr {
	public String strStr(String haystack, String needle) {
		int len = needle.length();
		for (int i = 0; i <= haystack.length() - len; i++) {
			if (equal(haystack, i, i + len, needle))
				return haystack.substring(i);
		}
		return null;
	}

	public boolean equal(String S, int start, int end, String needle) {
		for (int i = start; i < end; i++) {
			if (S.charAt(i) != needle.charAt(i - start))
				return false;
		}
		return true;
	}
}
