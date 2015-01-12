package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcatNumber {
	public String concat(int[] nums) {
		List<String> numString = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
			numString.add(Integer.toString(nums[i]));
		Collections.sort(numString, new MyComparator());
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < numString.size(); i++) {
			res.append(numString.get(i));
		}
		return res.toString();
	}

	class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			String n1 = o1 + o2;
			String n2 = o2 + o1;
			return n1.compareTo(n2);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 110, 1 };
		String s = new ConcatNumber().concat(nums);
		System.out.println(s);

		String x = "1101";
		String y = "1110";
		System.out.println(x.compareTo(y));
	}
}
