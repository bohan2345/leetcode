package code;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		List<String> res = new ArrayList<>();
		fullJustify(words, 0, L, res);
		return res;
	}

	void fullJustify(String[] words, int i, int L, List<String> res) {
		int line = words[i].length();
		int start = i;
		for (; i + 1 < words.length && line <= L; i++) {
			line += words[i + 1].length() + 1;
		}
		StringBuilder sb = new StringBuilder();
		int spaces = L - line;
		if (line > L) {
			spaces += words[i].length() + 1;
			i--;
			for (int j = start; j < i; j++) {
				sb.append(words[j]);
				int n = (int) Math.ceil((spaces * 1.0) / (i - j));
				spaces -= n;
				for (; n >= 0; n--)
					sb.append(' ');
			}
			sb.append(words[i]);
			for (; spaces > 0; spaces--)
				sb.append(' ');
			res.add(sb.toString());
			fullJustify(words, i + 1, L, res);
		} else {
			for (int j = start; j < i; j++)
				sb.append(words[j]).append(' ');
			sb.append(words[i]);
			for (; spaces > 0; spaces--)
				sb.append(' ');
			res.add(sb.toString());
		}
	}

	public static void main(String[] args) {
		String[] S = { "Listen", "to", "many,", "speak", "to", "a", "few." };
		List<String> L = new TextJustification().fullJustify(S, 6);
		for (String s : L)
			System.out.println(s);
	}
}
