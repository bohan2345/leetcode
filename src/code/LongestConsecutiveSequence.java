package code;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if (num == null) {
			return 0;
		}
		Set<Integer> numbers = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			numbers.add(num[i]);
		}
		int maxLength = 0;
		for (int i = 0; i < num.length; i++) {
			int n = num[i];
			int length = 1;
			while (numbers.size() > 0) {
				if (numbers.contains(n + 1)) {
					length++;
					numbers.remove(n + 1);
					n = n + 1;
				} else {
					break;
				}
			}
			n = num[i];
			while (numbers.size() > 0) {
				if (numbers.contains(n - 1)) {
					length++;
					numbers.remove(n - 1);
					n = n - 1;
				} else {
					break;
				}
			}
			numbers.remove(n);
			maxLength = maxLength > length ? maxLength : length;
		}
		return maxLength;
	}
}
