package test;

import tc.MedalTable;

public class MedalTableTest {
	public static void main(String[] args) {
		MedalTable test = new MedalTable();
		String[] results = { "ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE" };
		String[] s = test.generate(results);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}
