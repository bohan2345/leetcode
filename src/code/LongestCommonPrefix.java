package code;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		int len = 0;
		for (int j = 0; j < strs[0].length(); j++) {
			char tmp = strs[0].charAt(j);
			for (int i = 0; i < strs.length; i++) {
				if (j >= strs[i].length() || tmp != strs[i].charAt(j))
					return strs[0].substring(0, len);
			}
			len++;
		}
		return strs[0].substring(0, len);
	}
}
