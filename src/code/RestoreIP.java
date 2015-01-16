package code;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
	public List<String> restoreIpAddresses(String s) {
		List<String> results = new ArrayList<>();
		if (s == null || s.length() < 4)
			return results;
		find(s, new StringBuilder(), results, 1, 0);
		return results;
	}

	// x = 1, 2, 3, 4 the current part of the IP; j is the current position in String s
	public void find(String s, StringBuilder sb, List<String> results, int x, int j) {
		if (j >= s.length())
			return;
		if (x == 4) {
			String sub = s.substring(j);
			if (sub.length() <= 3 && Integer.valueOf(sub) <= 255) {
				if (sub.charAt(0) == '0' && sub.length() != 1)
					return;
				sb.append(sub);
				results.add(sb.toString());
				sb.delete(sb.length() - sub.length(), sb.length());
			}
			return;
		}
		for (int k = 1; k <= 3; k++) {
			String s1 = "";
			if (j + k <= s.length())
				s1 = s.substring(j, j + k);
			else
				s1 = s.substring(j);
			if (Integer.valueOf(s1) <= 255) {
				if (s1.charAt(0) == '0' && s1.length() != 1)
					continue;
				sb.append(s1);
				sb.append('.');
				find(s, sb, results, x + 1, j + k);
				sb.delete(sb.length() - s1.length() - 1, sb.length());
			}
		}
	}
	
    public List<String> restoreIpAddressesII(String s) {
        List<String> res = new ArrayList<>();
        restore(s, 0, res, "", 4);
        return res;
    }
    
    void restore(String s, int i, List<String> res, String tmp, int n) {
    	if ((s.length() - i) > 3 * n)
    		return;
        if (n == 0) {
            res.add(tmp.substring(1));
            return;
        }
        for (int j = i + 1; j <= s.length() && j <= i + 3; j++) {
            String sub = s.substring(i, j);
            if (Integer.valueOf(sub) <= 255 && !(sub.length() != 1 && sub.charAt(0) == '0'))
                restore(s, j, res, tmp + "." + sub, n - 1);
        }
    }
}
