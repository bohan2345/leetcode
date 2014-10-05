package tc;

import java.util.ArrayList;
import java.util.List;

public class MedalTable {
	public String[] generate(String[] results) {
		List<Country> countries = new ArrayList<>();
		for (int i = 0; i < results.length; i++) {
			String[] result = results[i].split(" ");
			boolean a = false, b = false, c = false;
			for (int j = 0; j < countries.size(); j++) {
				Country country = countries.get(j);
				if (country.equals(result[0])) {
					country.gold++;
					a = true;
				}
				if (country.equals(result[1])) {
					country.silver++;
					b = true;
				}
				if (country.equals(result[2])) {
					country.bronze++;
					c = true;
				}
			}
			if (!a) {
				countries.add(new Country(result[0]));
				countries.get(countries.size() - 1).gold++;
			}
			if (!b) {
				countries.add(new Country(result[1]));
				countries.get(countries.size() - 1).silver++;
			}
			if (!c) {
				countries.add(new Country(result[2]));
				countries.get(countries.size() - 1).bronze++;
			}
		}
		// bubbleSortList(countries);
		// selectionSort(countries);
		insertionSort(countries);
		String[] medalTable = new String[countries.size()];
		for (int i = 0; i < medalTable.length; i++) {
			medalTable[i] = countries.get(i).toString();
		}
		return medalTable;
	}

	// bubble sort
	public void bubbleSortList(List<Country> countries) {
		int n = countries.size();
		boolean swap = true;
		while (swap) {
			swap = false;
			for (int i = 0; i < n - 1; i++) {
				if (countries.get(i + 1).isGreaterThan(countries.get(i))) {
					Country temp = countries.get(i);
					countries.set(i, countries.get(i + 1));
					countries.set(i + 1, temp);
					swap = true;
				}
			}
		}
	}

	public void selectionSort(List<Country> countries) {
		int max = 0;
		for (int i = 0; i < countries.size(); i++) {
			max = i;
			for (int j = i + 1; j < countries.size(); j++) {
				if (countries.get(j).isGreaterThan(countries.get(max))) {
					max = j;
				}
			}
			if (max != i) {
				Country temp = countries.get(i);
				countries.set(i, countries.get(max));
				countries.set(max, temp);
			}
		}
	}

	public void insertionSort(List<Country> countries) {
		for (int i = 0; i < countries.size(); i++) {
			Country temp = countries.get(i);
			for (int j = i - 1; j >= 0; j--) {
				if (temp.isGreaterThan(countries.get(j))) {
					countries.set(j + 1, countries.get(j));
					if (j == 0) {
						countries.set(0, temp);
					}
				} else {
					countries.set(j + 1, temp);
					break;
				}
			}
		}
	}

	class Country {
		public String name;
		public int gold;
		public int silver;
		public int bronze;

		public Country(String name) {
			this.name = name;
			this.gold = 0;
			this.silver = 0;
			this.bronze = 0;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(this.name).append(' ').append(this.gold).append(' ').append(this.silver).append(' ').append(this.bronze);
			return sb.toString();
		}

		public boolean equals(Country country) {
			if (this.name.equals(country.name)) {
				return true;
			} else {
				return false;
			}
		}

		public boolean equals(String country) {
			if (this.name.equals(country)) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isGreaterThan(Country country) {
			if (this.gold > country.gold) {
				return true;
			} else if (this.gold == country.gold) {
				if (this.silver > country.silver) {
					return true;
				} else if (this.silver == country.silver) {
					if (this.bronze > country.bronze) {
						return true;
					} else if (this.bronze == country.bronze) {
						int n = this.name.compareToIgnoreCase(country.name);
						if (n < 0) {
							return true;
						}
					}
				}
			}
			return false;
		}
	}
}
