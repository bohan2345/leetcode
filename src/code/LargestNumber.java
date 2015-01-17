package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	public String largestNumber(int[] num) {
		List<String> list = new ArrayList<>();
		for (int n : num)
			list.add(Integer.toString(n));
		Collections.sort(list, new MyComparator());
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < list.size() && list.get(i).equals("0"))
			i++;
		for (; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

	class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			String n1 = o1 + o2;
			String n2 = o2 + o1;
			return n2.compareTo(n1);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 110, 1 };
		String s = new LargestNumber().largestNumber(nums);
		System.out.println(s);

		String x = "1101";
		String y = "1110";
		System.out.println(x.compareTo(y));
	}
}
