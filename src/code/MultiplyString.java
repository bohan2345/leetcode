package code;

public class MultiplyString {
    public String multiply(String num1, String num2) {
    	if (num1.equals("0") || num2.equals("0"))
    		return "0";
        if (num1.length() < num2.length())
            multiply(num2, num1);
        if (num2.length() == 0) {
            return num1;
        }
        String res = "0";
        for (int i = 0; i < num2.length(); i++) {
        	res = add(res, multiplyOne(num1, num2.substring(i, i + 1), num2.length() - i - 1));
        }
        return res;
    }
    
	String add(String num1, String num2) {
		if (num1.length() < num2.length())
			return add(num2, num1);
		int carry = 0;
		int l1 = num1.length(), l2 = num2.length();
		StringBuilder res = new StringBuilder();
		for (int i = 1; i <= l1; i++) {
			int n1 = Character.getNumericValue(num1.charAt(l1 - i));
			int n2 = i <= l2 ? Character.getNumericValue(num2.charAt(l2 - i)) : 0;
			int n = n1 + n2 + carry;
			carry = n / 10;
			n = n % 10;
			res.insert(0, n);
		}
		if (carry > 0)
			res.insert(0, carry);
		return res.toString();
	}
	
	String multiplyOne(String num1, String num2, int x) {
		if (num2.equals("0"))
			return "0";
	    int carry = 0;
	    StringBuilder res = new StringBuilder();
	    for (int i = num1.length() - 1; i >= 0; i--) {
	        int n1 = Character.getNumericValue(num1.charAt(i));
	        int n2 = Character.getNumericValue(num2.charAt(0));
	        int n = n1 * n2 + carry;
	        carry = n / 10;
	        n = n % 10;
	        res.insert(0, n);
	    }
	    if (carry > 0)
			res.insert(0, carry);
	    for (; x > 0; x--)
	    	res.append(0);
	    return res.toString();
	}

	public static void main(String[] args) {
		MultiplyString test = new MultiplyString();
		String s1 = test.add("99", "99");
		String s2 = test.multiply("0", "52");
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
