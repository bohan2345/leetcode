package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] charArr = strs[i].toCharArray();
			Arrays.sort(charArr);
			String str = new String(charArr);
			if (map.containsKey(str)) {
				map.get(str).add(strs[i]);
			}
			else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(str, list);
			}
		}
		ArrayList<String> res = new ArrayList<String>();
		Iterator<ArrayList<String>> iter = map.values().iterator();
		while (iter.hasNext()) {
			ArrayList<String> item = iter.next();
			if (item.size() > 1)
				res.addAll(item);
		}
		return res;
	}
}
