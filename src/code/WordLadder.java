package code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		Queue<String> Q = new LinkedList<>();
		Q.offer(start);
		int level = 1;
		int cur = 1, next = 0;
		Set<String> visited = new HashSet<>();
		while (!Q.isEmpty()) {
			String str = Q.poll();
			char[] charseq = str.toCharArray();
			cur--;
			for (int i = 0; i < charseq.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (charseq[i] == c)
						continue;
					char tmp = charseq[i];
					charseq[i] = c;
					String newStr = new String(charseq);
					if (newStr.equals(end))
						return level + 1;
					if (dict.contains(newStr) && !visited.contains(newStr)) {
						Q.offer(newStr);
						next++;
					}
					charseq[i] = tmp;
				}
			}
			visited.add(str);
			if (cur == 0) {
				cur = next;
				next = 0;
				level++;
			}

		}
		return 0;
	}
}
