package code;

import java.util.ArrayList;
import java.util.List;

public class TrieTree {
	class TrieNode {
		public char content; // the character this node represent
		public int count;
		private TrieNode[] children;
		public boolean isEnd;

		public TrieNode(char c) {
			this.content = c;
			this.count = 1;
			this.children = new TrieNode[26];
		}

		public boolean hasChild(char c) {
			return this.children[c - 'a'] != null;
		}

		public TrieNode getChild(char c) {
			return this.children[c - 'a'];
		}

		public void addChild(char c) {
			TrieNode child = new TrieNode(c);
			this.children[c - 'a'] = child;
		}

		public void removeChild(char c) {
			this.children[c - 'a'] = null;
		}

		@Override
		public String toString() {
			return Character.toString(this.content);
		}
	}

	TrieNode root;

	public TrieTree() {
		this.root = new TrieNode(' ');
	}

	public void add(String word) {
		TrieNode node = this.root;
		node.count++;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.hasChild(c)) {
				node.getChild(c).count++;
			} else {
				node.addChild(c);
			}
			node = node.getChild(c);
		}
		node.isEnd = true;
	}

	public boolean delete(String word) {
		if (!search(word))
			return false;
		TrieNode node = this.root;
		for (char c : word.toCharArray()) {
			TrieNode child = node.getChild(c);
			if (child.count == 1) {
				node.removeChild(c);
				return true;
			} else
				node.count--;
			node = child;
		}
		node.isEnd = false;
		return true;
	}

	public List<String> prefixSearch(String prefix) {
		List<String> res = new ArrayList<>();
		TrieNode node = this.root;
		for (char c : prefix.toCharArray()) {
			if (!node.hasChild(c))
				return res;
			else
				node = node.getChild(c);
		}
		dfs(node, res, new StringBuilder(prefix.substring(0, prefix.length() - 1)));
		return res;
	}

	private void dfs(TrieNode root, List<String> res, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.content);
		if (root.isEnd) {
			res.add(sb.toString());
		}
		for (char i = 'a'; i <= 'z'; i++) {
			dfs(root.getChild(i), res, sb);
		}
		sb.deleteCharAt(sb.length() - 1);
	}

	public boolean search(String word) {
		TrieNode node = this.root;
		for (char c : word.toCharArray()) {
			if (!node.hasChild(c))
				return false;
			else
				node = node.getChild(c);
		}
		return node.isEnd;
	}
}