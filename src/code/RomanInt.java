package code;

import java.util.HashMap;
import java.util.Map;

public class RomanInt {
	public int romanToInt(String s) {
		int sum = 0;
		char cur = 0, last = 0, previous = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			cur = s.charAt(i);
			if (i + 1 < s.length()) {
				last = s.charAt(i + 1);
			}
			if (i + 2 < s.length()) {
				previous = s.charAt(i + 2);
			}
			if (getInt(cur) > getInt(last)) {
				sum = sum + getInt(cur);
			} else if (getInt(cur) < getInt(last)) {
				sum = sum - getInt(cur);
			} else {
				if (getInt(cur) < getInt(previous)) {
					sum = sum - getInt(cur);
				} else {
					sum = sum + getInt(cur);
				}
			}
		}
		return sum;
	}

	public int getInt(char c) {
		if (c == 'I') {
			return 1;
		} else if (c == 'V') {
			return 5;
		} else if (c == 'X') {
			return 10;
		} else if (c == 'L') {
			return 50;
		} else if (c == 'C') {
			return 100;
		} else if (c == 'D') {
			return 500;
		} else if (c == 'M') {
			return 1000;
		} else
			return 0;

	}

	public String intToRoman(int num) {
		String roman = "";
		int[] x = new int[4];
		int a = 0, n = num, j = 0;
		while (n != 0) {
			a = n % 10;
			n = n / 10;
			x[j] = a;
			j++;
		}

		for (j = 0; j < x.length; j++) {
			if (x[j] == 0)
				continue;
			String tempR = getRoman(x[j], j);
			roman = tempR.concat(roman);
		}
		return roman;
	}

	public String getRoman(int n, int x) {
		char[] R = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int i = 0;
		if (x == 0) {
			i = 0;
		} else if (x == 1) {
			i = 2;
		} else if (x == 2) {
			i = 4;
		} else if (x == 3) {
			i = 6;
		}
		switch (n) {
		default:
			return "";
		case 1:
			char[] str = { R[i] };
			return new String(str);
		case 2:
			char[] str2 = { R[i], R[i] };
			return new String(str2);
		case 3:
			char[] str3 = { R[i], R[i], R[i] };
			return new String(str3);
		case 4:
			char[] str4 = { R[i], R[i + 1] };
			return new String(str4);
		case 5:
			char[] str5 = { R[i + 1] };
			return new String(str5);
		case 6:
			char[] str6 = { R[i + 1], R[i] };
			return new String(str6);
		case 7:
			char[] str7 = { R[i + 1], R[i], R[i] };
			return new String(str7);
		case 8:
			char[] str8 = { R[i + 1], R[i], R[i], R[i] };
			return new String(str8);
		case 9:
			char[] str9 = { R[i], R[i + 2] };
			return new String(str9);
		}
	}

	public String intToRomanII(int num) {
		String str = "";
		String symbol[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int value[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		for (int i = 0; num != 0; ++i) {
			while (num >= value[i]) {
				num -= value[i];
				str += symbol[i];
			}
		}
		return str;
	}
	
    public int romanToIntII(String s) {
		Map<String, Integer> table = new HashMap<>();
		table.put("M", 1000);
		table.put("CM", 900);
		table.put("D", 500);
		table.put("CD", 400);
		table.put("C", 100);
		table.put("XC", 90);
		table.put("L", 50);
		table.put("XL", 40);
		table.put("X", 10);
		table.put("IX", 9);
		table.put("V", 5);
		table.put("IV", 4);
		table.put("I", 1);
		int num = 0;
		while (s.length() > 0) {
		    String sub1 = s.substring(0, 1);
		    String sub2 = s.length() >= 2 ? s.substring(0, 2) : "";
		    if (table.containsKey(sub2)) {
		        num += table.get(sub2);
		        s = s.substring(2);
		    } else {
		        num += table.get(sub1);
		        s = s.substring(1);
		    }
		}
		return num;
    }
}
