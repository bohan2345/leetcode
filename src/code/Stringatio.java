package code;

public class Stringatio {
	public int atoi(String str) {
        if (str == null)
            throw new IllegalArgumentException("hehe");
        str = str.trim();
        if (str.length() == 0) 
            return 0;
        int num = 0;
        int flag = 1;
        int i = 0;
        if (str.charAt(0) == '+') {
            i++;
        }
        else if (str.charAt(0) == '-') {
            flag = -1;
            i++;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9'){
                if (num > 214748364)
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                if (num == 214748364) {
                    if (flag == 1 && c <= '7')
                        num = num * 10 + Character.getNumericValue(c);
                    else if (flag == -1 && c <= '8')
                        num = num * 10 + Character.getNumericValue(c);
                    else
                        return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else 
                    num = num * 10 + Character.getNumericValue(c);
            } else 
                break;
        }
        return flag == 1 ? num : num * -1;
    }
}
