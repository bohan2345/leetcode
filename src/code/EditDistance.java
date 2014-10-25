package code;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int[][] table = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			table[i][0] = i;
		}
		for (int j = 0; j <= word2.length(); j++) {
			table[0][j] = j;
		}
		for (int i = 1; i <= word1.length(); i++) {
			char a = word1.charAt(i - 1);
			for (int j = 1; j <= word2.length(); j++) {
				char b = word2.charAt(j - 1);
				if (a == b) {
					table[i][j] = table[i - 1][j - 1];
				} else {
					table[i][j] = Math.min(table[i - 1][j - 1] + 1, Math.min(table[i][j - 1] + 1, table[i - 1][j] + 1));
				}
			}
		}
		return table[word1.length()][word2.length()];
	}
}
