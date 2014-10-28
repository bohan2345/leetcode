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
}