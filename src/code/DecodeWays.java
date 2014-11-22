package code;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		int[] number = new int[s.length() + 1];
		number[0] = 1;
		number[1] = 1;
		int tmp;
		for (int i = 2; i <= s.length(); i++) {
			// 检查当前字符是不是'0'
			tmp = Integer.parseInt(s.substring(i - 1, i));
			if (tmp != 0) {
				number[i] = number[i - 1];
			}
			// 检查当前字符和前一个字符组合在一起是否在10-26之间
			tmp = Integer.parseInt(s.substring(i - 2, i));
			if (tmp >= 10 && tmp <= 26) {
				number[i] +=  number[i - 2];
			}
		}
		return number[s.length()];
	}
}
