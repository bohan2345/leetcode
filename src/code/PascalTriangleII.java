package code;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        if (rowIndex < 0) return curRow;
        curRow.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < curRow.size(); j++) {
                newRow.add(curRow.get(j - 1) + curRow.get(j));
            }
            newRow.add(1);
            curRow = newRow;
        }
        return curRow;
    }
}
