package code;

import java.util.HashMap;
import java.util.Map;

/*
 * convert integer to string 1 = A, 26 = Z, 27 = AA;
 */
public class Base26 {
	public String convert(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("hehe");
		Map<Integer, Character> table = new HashMap<>();
		for (int i = 0; i <= 26; i++) {
			table.put(i, (char) ('A' + i - 1));
		}
		StringBuilder res = new StringBuilder();
		while (n > 0) {
			res.append(table.get(n % 26));
			n = n / 26;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String s = new Base26().convert(0);
		System.out.println(s);
	}
}
