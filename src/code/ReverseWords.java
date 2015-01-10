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
	
    public String reverseWordsII(String s) {
        if (s == null || s.length() == 0)
            return "";
        s = s.trim();
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        while (r <= s.length()) {
            if (r == s.length()) {
                sb.insert(0, ' ');
                sb.insert(0, s.substring(l, r));
                r++;
            } else if (s.charAt(r) == ' ') {
                String sub = s.substring(l, r);
                sb.insert(0, ' ');
                sb.insert(0, sub);
                while (r < s.length() && s.charAt(r) == ' ')
                    r++;
                l = r;
            } else 
                r++;
        }
        return sb.toString().trim();
    }
}
