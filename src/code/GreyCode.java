package code;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {
	public List<Integer> grayCode(int n) {
		List<Integer> nums = new ArrayList<Integer>();
		if (n > 0) {
			List<Integer> temp = grayCode(n - 1);
			int size = temp.size();

			int add = 1 << n - 1;
			for (int i = size; i > 0; i--) {
				temp.add(temp.get(i - 1) + add);
			}
			nums = temp;
		} else {
			nums.add(0);
		}
		return nums;
	}
}
