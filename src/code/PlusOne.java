package code;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits != null) {
			int i = digits.length - 1;
			while (true) {
				if (i == -1) {
					int[] newDigits = new int[digits.length + 1];
					newDigits[0] = 1;
					for (int j = 0; j < i; j++) {
						newDigits[j + 1] = digits[j];
					}
					digits = newDigits;
					break;
				}
				digits[i] = digits[i] + 1;
				if (digits[i] > 9) {
					digits[i] = digits[i] - 10;
					i--;
				} else
					break;
			}
		}
		return digits;
	}
}
