package code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		Map<String, Integer> numOfSubstrings = new LinkedHashMap<>();
		for (int i = 0; i < L.length; i++) {
			if (numOfSubstrings.containsKey(L[i])) {
				numOfSubstrings.put(L[i], numOfSubstrings.get(L[i]) + 1);
			} else {
				numOfSubstrings.put(L[i], 1);
			}
		}
		List<Integer> results = new ArrayList<>();
		int eachLength = L[0].length();
		for (int i = 0; i <= S.length() - L.length * eachLength; i++) {
			int count = 0;
			Map<String, Integer> temp = new LinkedHashMap<>(numOfSubstrings);
			for (int n = 0; n < L.length; n++) {
				String substring = S.substring(i + n * eachLength, i + (n + 1) * eachLength);
				if (temp.containsKey(substring) && (temp.get(substring) > 0)) {
					// temp.remove(substring);
					temp.put(substring, temp.get(substring) - 1);
					count++;
				} else {
					break;
				}
				if (count == L.length) {
					break;
				}
			}
			if (count == L.length) {
				results.add(i);
			}
		}
		return results;
	}
}
