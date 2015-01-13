package tc;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class SortMap {
	// Method for sorting the TreeMap based on values
	public static Map<String, Integer> sortByValues(final Map<String, Integer> map) {

		class ValueComparator implements Comparator<String>{
			@Override
			public int compare(String o1, String o2) {
				return map.get(o1).compareTo(map.get(o2));
			}
		}
		
		Comparator<String> valueComparator = new ValueComparator();

		Map<String, Integer> sortedByValues = new TreeMap<>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	public static void main(String args[]) {
		//
		Map<String, Integer> treemap = new TreeMap<>();

		// Put elements to the map
		treemap.put("Key1", 5);
		treemap.put("Key2", 4);
		treemap.put("Key3", 3);
		treemap.put("Key4", 2);
		treemap.put("Key5", 1);

		for (String s : treemap.keySet()) {
			System.out.print(s + " : ");
			System.out.println(treemap.get(s));
		}
		
		// // Calling the method sortByvalues
		treemap = sortByValues(treemap);
		
		for (String s : treemap.keySet()) {
			System.out.print(s + " : ");
			System.out.println(treemap.get(s));
		}
	}
}