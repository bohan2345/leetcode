package code;

public class UniqueBST {
	public int numTrees(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		int num = 0;
		for (int i = 0; i < n; i++) {
			num = num + numTrees(i) * numTrees(n - i - 1);
		}
		return num;
	}
}
