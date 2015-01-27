package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	class Node {
		String val;
		Node from;

		public Node(String str, Node fr) {
			this.val = str;
			this.from = fr;
		}

		public String toString() {
			return this.val;
		}
	}

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<>();
		if (start.equals(end))
			return res;
		Queue<Node> Q = new LinkedList<>();
		Q.offer(new Node(start, null));
		int cur = 1, next = 0;
		boolean f = false;
		List<Node> endList = new ArrayList<>();
		Set<String> S = new HashSet<>();
		while (!Q.isEmpty()) {
			Node node = Q.poll();
			cur--;
			char[] charArray = node.val.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == charArray[i])
						continue;
					char tmp = charArray[i];
					charArray[i] = c;
					String newStr = new String(charArray);
					Node newNode = new Node(newStr, node);
					if (newStr.equals(end)) {
						f = true;
						endList.add(newNode);
					} else if (dict.contains(newStr)) {
						Q.offer(newNode);
						S.add(newStr);
						next++;
					}
					charArray[i] = tmp;
				}
			}
			if (cur == 0) {
				dict.removeAll(S);
				if (f) {
					break;
				}
				cur = next;
				next = 0;
			}
		}
		for (int i = 0; i < endList.size(); i++) {
			Node node = endList.get(i);
			List<String> tmp = new ArrayList<>();
			while (node != null) {
				tmp.add(0, node.val);
				node = node.from;
			}
			res.add(tmp);
		}
		return res;
	}
}
