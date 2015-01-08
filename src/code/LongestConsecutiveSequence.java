package code;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        Set<Integer> S = new HashSet<>();
        for (int i : num)
            S.add(i);
        int max = 0;
        for (int i : num) {
            int right = i + 1, left = i - 1, count = 1;
            while (S.contains(left)) {
                S.remove(left);
                left--;
                count++;
            }
            while (S.contains(right)) {
                S.remove(right);
                right++;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
