package code;

import java.util.HashSet;
import java.util.Set;

public class LongestNoRepeatingSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int l = 0, r = 0, count = 0, max = 0;
        Set<Character> S = new HashSet<>();
        while (r < s.length()) {
            if (S.contains(s.charAt(r))) {
                S.remove(s.charAt(l));
                count--;
                l++;
            } else {
            	S.add(s.charAt(r));
                r++;
                count++;
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
