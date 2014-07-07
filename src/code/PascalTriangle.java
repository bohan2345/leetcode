package code;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows > 0) {
			for (int i = 0; i < numRows; i++) {
				List<Integer> row = new ArrayList<Integer>();
				if (i == 0) {
					row.add(1);
				} else {
					List<Integer> temp = result.get(i - 1);
					for (int j = 0; j <= temp.size(); j++) {
						if (j == 0) {
							row.add(temp.get(j));
						} else if (j == temp.size()) {
							row.add(temp.get(j - 1));
						} else {
							row.add(temp.get(j - 1) + temp.get(j));
						}
					}
				}
				result.add(row);
			}
		}
		return result;
	}
}
