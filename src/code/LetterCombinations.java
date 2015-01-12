package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	public List<String> letterCombinations(String digits) {
		List<String> results = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return results;
		}
		Map<Character, char[]> keyMapping = new HashMap<>();
		char[] one = {};
		char[] two = { 'a', 'b', 'c' };
		char[] three = { 'd', 'e', 'f' };
		char[] four = { 'g', 'h', 'i' };
		char[] five = { 'j', 'k', 'l' };
		char[] six = { 'm', 'n', 'o' };
		char[] seven = { 'p', 'q', 'r', 's' };
		char[] eight = { 't', 'u', 'v' };
		char[] nine = { 'w', 'x', 'y', 'z' };
		char[] zero = { ' ' };
		char[] star = { '+' };
		char[] pound = {};
		keyMapping.put('1', one);
		keyMapping.put('2', two);
		keyMapping.put('3', three);
		keyMapping.put('4', four);
		keyMapping.put('5', five);
		keyMapping.put('6', six);
		keyMapping.put('7', seven);
		keyMapping.put('8', eight);
		keyMapping.put('9', nine);
		keyMapping.put('0', zero);
		keyMapping.put('*', star);
		keyMapping.put('#', pound);
		digits.length();

		for (int i = 0; i < digits.length(); i++) {
			char digit = digits.charAt(i);
			char[] key = keyMapping.get(digit);
			List<String> newResults = new ArrayList<>();
			for (int n = 0; n < results.size(); n++) {
				String temp = results.get(n);
				StringBuffer sb = new StringBuffer(temp);
				for (int j = 0; j < key.length; j++) {
					sb.append(key[j]);
					newResults.add(sb.toString());
				}
			}
			results = newResults;
		}
		return results;
	}
	
	void helper(String digits, int i, List<String> res, StringBuilder tmp, Map<Integer, List<Character>> table) {
        if (i == digits.length()) {
            res.add(tmp.toString());
            return;
        }
        List<Character> A = table.get(digits.charAt(i) - '0');
        for (int j = 0; j < A.size(); j++) {
            tmp.append(A.get(j));
            helper(digits, i + 1, res, tmp, table);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
