package tc;

import java.util.ArrayList;
import java.util.Collections;
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
		// insertionSort(countries);

		Collections.sort(countries);
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
				if (countries.get(i + 1).compareTo(countries.get(i)) > 0) {
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
				if (countries.get(j).compareTo(countries.get(max)) > 0) {
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
				if (temp.compareTo(countries.get(j)) > 0) {
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

	class Country implements Comparable<Country> {
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

		@Override
		public boolean equals(Object country) {
			Country cou = null;
			if (country instanceof Country) {
				cou = (Country) country;
			} else {
				return false;
			}
			if (this.name.equals(cou.name)) {
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

		@Override
		public int hashCode() {
			int hashCode = 0;
			for (int i = 0; i < this.name.length(); i++) {
				hashCode += (int) this.name.charAt(i);
			}
			return hashCode;
		}

		@Deprecated
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

		@Override
		public int compareTo(Country country) {
			if (this.gold > country.gold) {
				return -1;
			} else if (this.gold == country.gold) {
				if (this.silver > country.silver) {
					return -1;
				} else if (this.silver == country.silver) {
					if (this.bronze > country.bronze) {
						return -1;
					} else if (this.bronze == country.bronze) {
						int n = this.name.compareToIgnoreCase(country.name);
						if (n < 0) {
							return -1;
						} else if (n == 0) {
							return 0;
						}
					}
				}
			}
			return 1;
		}
	}
}
