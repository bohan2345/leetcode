package code;

import java.util.HashMap;

public class SingleNumberII {
	public int singleNumber(int[] A) {
		HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				numbers.put(A[i], 1);
			} else {
				if (numbers.containsKey(A[i])) {
					count = numbers.get(A[i]) + 1;
					if (count == 3) {
						numbers.remove(A[i]);
					} else {
						numbers.put(A[i], count);
					}
				} else {
					numbers.put(A[i], 1);
				}
			}
		}
		return numbers.keySet().iterator().next();
	}
}
