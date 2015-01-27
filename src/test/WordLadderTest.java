package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import code.WordLadderII;

public class WordLadderTest {
	public static void main(String[] args) {
		WordLadderII test = new WordLadderII();
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		List<List<String>> res = test.findLadders("hit", "cog", dict);
		for (List<String> l : res) {
			System.out.println(l.toString());
		}
	}
}
