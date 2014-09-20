package code;

public class CountAndSay {
	public String countAndSay(int n) {
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
}
