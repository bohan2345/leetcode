package code;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		boolean[] F = new boolean[p.length() + 1];
		F[0] = true;
		for (int j = 1; j <= p.length(); j++) {
			F[j] = F[j - 1] && p.charAt(j - 1) == '*';
		}
		boolean last = false;
		for (int i = 1; i <= s.length(); i++) {
			boolean[] tmp = new boolean[p.length() + 1];
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) == '?' || (s.charAt(i - 1) == p.charAt(j - 1)))
					tmp[j] = F[j - 1];
				else if (p.charAt(j - 1) == '*')
					tmp[j] = F[j - 1] || last || F[j];
				last = tmp[j];
			}
			F = tmp;
		}
		return F[p.length()];
	}

	public boolean isMatchII(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		if (plen == 0) {
			if (slen == 0)
				return true;
			else
				return false;
		}
		int i = 0;
		int j = 0;
		int nxts = -1;
		int nxtp = -1;
		// here only use i as ending condition, for the case j reach the end with no match,
		// it can go back to recorded index and match again
		while (i < slen) {
			if (j < plen && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				i++;
				j++;
			} else if (j < plen && p.charAt(j) == '*') {
				nxtp = j;
				nxts = i;
				// only increase j
				j++;
			} else {
				if (nxtp == -1) {
					return false;
				} else {
					nxts++;
					i = nxts;
					// only increase i by 1 from previous recorded index,
					// which means include s[i] to the match of *
					// (not set i up to the failure point)
					j = nxtp + 1;
				}
			}
		}
		// if p has character left, only can be true if all the left are *
		while (j < plen && p.charAt(j) == '*') {
			j++;
		}
		return j == plen;
	}
}
