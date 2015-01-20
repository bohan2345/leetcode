package test;

import java.util.List;

import code.Combinations;

public class CombinationsTest {
	public static void main(String[] args) {
		Combinations test = new Combinations();
		List<List<Integer>> c = test.combine(1, 1);

		for (int i = 0; i < c.size(); i++) {
			List<Integer> cc = c.get(i);
			for (int j = 0; j < cc.size(); j++) {
				System.out.print(cc.get(j) + " ");
			}
			System.out.println("");
		}
	}
}
