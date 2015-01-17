package code;

public class ReverseInteger {
	public int reverseII(int x) {
        int f = 1;
        String s = "";
        if (x < 0) {
            f = -1;
            s = Integer.toString(x * -1);
        } else {
            s = Integer.toString(x);
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        try {
            return Integer.valueOf(s) * f;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
	
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
