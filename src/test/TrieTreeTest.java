package test;

import java.util.List;

import code.TrieTree;

public class TrieTreeTest {
	public static void main(String[] args) {
		TrieTree test = new TrieTree();
		test.add("trie");
		test.add("tree");
		test.add("treee");
		System.out.println(test.search("tree"));
//		test.delete("tree");
		System.out.println(test.search("tree"));
		System.out.println(test.search("treee"));
		List<String> res = test.prefixSearch("tre");
		System.out.println(res.toString());
	}
}
