package code;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(row);
        for (int i = 1; i < numRows; i++) {
            row = res.get(res.size() - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < row.size(); j++) {
                newRow.add(row.get(j - 1) + row.get(j));
            }
            newRow.add(1);
            res.add(newRow);
        }
        return res;
    }
}
