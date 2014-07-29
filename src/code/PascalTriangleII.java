package code;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<Integer>();
		List<Integer> lastRow = new ArrayList<Integer>();
		lastRow.add(1);
		if (rowIndex <= 0) {
			return lastRow;
		}

		for (int i = 0; i < rowIndex; i++) {
			for (int j = 0; j <= lastRow.size(); j++) {
				int tempNum = 0;
				if (j == 0) {
					tempNum = lastRow.get(j);
				} else if (j == lastRow.size()) {
					tempNum = lastRow.get(j - 1);
				} else {
					tempNum = lastRow.get(j - 1) + lastRow.get(j);
				}
				row.add(tempNum);
			}
			lastRow.clear();
			lastRow.addAll(row);
			row.clear();
		}
		return lastRow;
	}
}
