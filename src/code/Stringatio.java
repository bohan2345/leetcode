package code;

public class Stringatio {
    public int atoi(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        if (str.length() == 0)
            return 0;
        int flag = 1;
        int i = 0;
        if (str.charAt(i) == '-') {
            flag = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        int num = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            int n = 0;
            if (c <= '9' && c >= '0') {
                n = c - '0';
                if (num > Integer.MAX_VALUE / 10)
                    return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                if (num == Integer.MAX_VALUE / 10) {
                    if (n > 7 && flag > 0)
                        return Integer.MAX_VALUE;
                    if (n > 8 && flag < 0)
                        return Integer.MIN_VALUE;
                }
                num = num * 10 + n;
            } else {
                break;
            }
        }
        return flag * num;
    }
}
