package code;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElement(int[] num) {
		int l = num.length;
		Map<Integer, Integer> counter = new HashMap<>();
		for (int i = 0; i < l; i++) {
			if (counter.containsKey(num[i])) {
				counter.put(num[i], counter.get(num[i]) + 1);
			} else {
				counter.put(num[i], 1);
			}
		}
		for (int n : counter.keySet()) {
			if (counter.get(n) > l / 2)
				return n;
		}
		return 0;
	}

	public int majorityElementII(int[] num) {
		int counter = 0;
		int candidate = num[0];
		for (int i = 0; i < num.length; i++) {
			if (counter == 0) {
				candidate = num[i];
				counter = 1;
			} else {
				if (num[i] == candidate)
					counter++;
				else
					counter--;
			}
		}
		return candidate;
	}
}
