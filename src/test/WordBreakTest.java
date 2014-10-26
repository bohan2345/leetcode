package test;

import java.util.HashSet;
import java.util.Set;

import code.WordBreak;

public class WordBreakTest {
	public static void main(String[] args) {
		WordBreak test = new WordBreak();
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		test.wordBreak("catsanddog", dict);
	}
}
