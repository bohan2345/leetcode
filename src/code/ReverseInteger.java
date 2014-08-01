package code;

public class ReverseInteger {
	// public int reverse(int x) {
	// int[] digits = getDigits(x);
	// int newint = 0;
	// for (int i = 0; i < digits.length; i++) {
	// newint = 10 * newint + digits[i];
	// }
	// return newint;
	// }
	//
	// public int[] getDigits(int x) {
	// int[] digits = new int[10];
	// int n = 1, i = 0;
	// while (x != 0) {
	// n = x / 10;
	// int a = (x - n * 10);
	// digits[i] = a;
	// i++;
	// x = n;
	// }
	// int[] xxx = new int[i];
	// for(int j=0;j<xxx.length;j++){
	// xxx[j]=digits[j];
	// }
	// return xxx;
	// }
	public int reverse(int x) {
		int isNagetive = 1;
		if (x < 0) {
			isNagetive = -1;
			x = x * isNagetive;
		}
		int newN = 0, left = 0;
		while (x != 0) {
			left = x % 10;
			if (newN == Integer.MAX_VALUE / 10) {
				if (left > Integer.MAX_VALUE % 10) {
					return -1;
				}
			} else if (newN > Integer.MAX_VALUE / 10) {
				return -1;
			}
			newN = newN * 10 + left;
			x = x / 10;
		}
		return newN * isNagetive;
	}

	public static void main(String[] args) {
		int xx = (new ReverseInteger()).reverse(123000);
		System.out.print(xx);
	}
}
