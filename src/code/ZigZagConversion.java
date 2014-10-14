package code;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}
		char[][] table = new char[nRows][s.length()];
		int index = 0, col = 0, row = 0;
		boolean goDown = true, goUp = false;
		while (index < s.length()) {
			table[row][col] = s.charAt(index);
			if (goDown) {
				row++;
				if (row == nRows - 1) {
					goDown = false;
					goUp = true;
				}
			}else if (goUp) {
				col++;
				row--;
				if (row == 0) {
					goDown = true;
					goUp = false;
				}
			}
			index++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < s.length(); j++) {
				if (table[i][j] != 0)
					sb.append(table[i][j]);
			}
		}
		return sb.toString();
	}
}
