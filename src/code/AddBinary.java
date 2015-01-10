package code;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (b.length() > a.length())
            return addBinary(b, a);
        int carry = 0;
        int ai = a.length() - 1, bi = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (ai >= 0) {
            int ac = a.charAt(ai) - '0', bc = bi >= 0 ? b.charAt(bi) - '0' : 0;
            int sum = ac + bc + carry;
            carry = (sum / 2);
            sb.insert(0, sum % 2);
            ai--;
            bi--;
        }
        if (carry > 0) 
            sb.insert(0, carry);
        return sb.toString();
    }
    
	public String addBinaryII(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		int l = 0;
		while (i >= 0 && j >= 0) {
			int numa = Character.getNumericValue(a.charAt(i));
			int numb = Character.getNumericValue(b.charAt(j));
			int sum = numa + numb + l;
			l = 0;
			if (sum > 1) {
				l = 1;
				sum = sum - 2;
			}
			sb.append(sum);
			i--;
			j--;
		}
		int r = 0;
		String rString = null;
		if (i < 0) {
			r = j;
			rString = b;
		} else {
			r = i;
			rString = a;
		}
		for (; r >= 0; r--) {
			int sum = Character.getNumericValue(rString.charAt(r));
			if (l == 1) {
				sum = l + Character.getNumericValue(rString.charAt(r));
				l = 0;
				if (sum > 1) {
					l = 1;
					sum = sum - 2;
				}
			}
			sb.append(sum);
		}
		if (l == 1) {
			sb.append(1);
		}
		sb.reverse();
		return sb.toString();
	}
}
