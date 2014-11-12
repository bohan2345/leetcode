package test;

import tc.BuildTreeFromArray;

public class BuildTreeFromArrayTest {
	public static void main(String[] args) {
		BuildTreeFromArray test = new BuildTreeFromArray();
		// int[] A = { 1, -1, 2, -1, -1 };
		int[] A = { 1, 2, 3, -1, 5, -1, -1, -1, 4, -1, -1 };
		TreeNode x = test.build(A);
		System.out.println(BinaryTreeUtil.toList(x).toString());
	}
}
