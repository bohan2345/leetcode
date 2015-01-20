package code;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {
	public List<Integer> grayCode(int n) {
		List<Integer> nums = new ArrayList<Integer>();
		if (n == 0) {
		    nums.add(0);
		    return nums;
		}
		nums = grayCode(n - 1);
		int add = 1 << n - 1;
		for (int i = nums.size() - 1; i >= 0; i--)
		    nums.add(nums.get(i) + add);
		return nums;
	}
}
