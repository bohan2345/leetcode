package code;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, 0, res, new ArrayList<String>());
        return res;
    }
    
    void dfs(String s, int start, int end, List<List<String>> res, List<String> tmp) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(tmp));
            return;
        }
        for (; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                tmp.add(s.substring(start, end + 1));
                dfs(s, end + 1, end + 1, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
