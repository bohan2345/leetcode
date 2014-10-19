package code;

public class ReverseWords {
	public String reverseWords(String s) {
		s = s.trim();
		String[] strs = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			sb.append(strs[i]);
			if (i != 0) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
