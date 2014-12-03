package code;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		List<Integer> temp = new ArrayList<>();
		for (int level = 0; level < triangle.size(); level++) {
			temp.clear();
			for (int i = 0; i < triangle.get(level).size(); i++) {
				if (i == 0) {
					temp.add(result.get(i) + triangle.get(level).get(i));
				} else if (i == triangle.get(i).size() - 1) {
					temp.add(result.get(i - 1) + triangle.get(level).get(i));
				} else {
					temp.add(Math.min(result.get(i - 1), result.get(i)) + triangle.get(level).get(i));
				}
			}
			result.clear();
			result.addAll(temp);
		}
		int min = result.get(0);
		for (int i = 0; i < result.size(); i++) {
			min = min < result.get(i) ? min : result.get(i);
		}
		return min;
	}

	public int minimumTotalII(List<List<Integer>> triangle) {
		if (triangle == null)
			throw new IllegalArgumentException("hehe");
		int n = triangle.get(triangle.size() - 1).size();
		int[] lastRow = new int[n];
		int[] curRow = new int[n];
		curRow[0] = triangle.get(0).get(0);
		lastRow[0] = triangle.get(0).get(0);
		for (int level = 1; level < triangle.size(); level++) {
			List<Integer> l = triangle.get(level);
			for (int i = 0; i < l.size(); i++) {
				if (i == 0)
					curRow[i] = lastRow[0] + l.get(i);
				else if (i == l.size() - 1)
					curRow[i] = lastRow[i - 1] + l.get(i);
				else
					curRow[i] = Math.min(lastRow[i] + l.get(i), lastRow[i - 1] + l.get(i));
			}
			lastRow = curRow.clone();
		}
		int min = curRow[0];
		for (int i = 0; i < curRow.length; i++) {
			min = Math.min(curRow[i], min);
		}
		return min;
	}
}
