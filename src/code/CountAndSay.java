package code;

public class CountAndSay {
	public String countAndSayII(int n) {
		String x = String.valueOf(1);
		int m = 1;
		String result = String.valueOf(n);
		while (m < n) {
			char[] N = new char[x.length()];
			for (int i = 0; i < x.length(); i++) {
				N[i] = x.charAt(i);
			}
			int count = 1;
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < x.length(); j++) {
				if (j == x.length() - 1) {
					sb.append(count);
					sb.append(N[j]);
					count = 1;
					break;
				}
				if (N[j] == N[j + 1]) {
					count++;
				} else {
					sb.append(count);
					sb.append(N[j]);
					count = 1;
				}
			}
			result = sb.toString();
			x = result;
			m++;
		}
		return result;
	}

	public String countAndSay(int n) {
		return hehe(n, 1, "1");
	}

	public String hehe(int n, int x, String tmp) {
		if (n == x)
			return tmp;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tmp.length();) {
			char c = tmp.charAt(i);
			int count = 0;
			while (i < tmp.length() && c == tmp.charAt(i)) {
				count++;
				i++;
			}
			builder.append(count).append(c);
		}
		return hehe(n, x + 1, builder.toString());
	}
}
