package code;

public class ReverseInteger {
	public int reverse(int x) {
		int[] digits = getDigits(x);
		int newint = 0;
		for (int i = 0; i < digits.length; i++) {
			newint = 10 * newint + digits[i];
		}
		return newint;
	}

	public int[] getDigits(int x) {
		int[] digits = new int[10];
		int n = 1, i = 0;
		while (x != 0) {
			n = x / 10;
			int a = (x - n * 10);
			digits[i] = a;
			i++;
			x = n;
		}
		int[] xxx = new int[i];
		for(int j=0;j<xxx.length;j++){
			xxx[j]=digits[j];
		}
		return xxx;
	}

	public static void main(String[] args) {
		int xx = (new ReverseInteger()).reverse(123000);
		System.out.print(xx);
	}
}
