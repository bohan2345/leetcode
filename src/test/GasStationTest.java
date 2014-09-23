package test;

import code.GasStation;

public class GasStationTest {
	public static void main(String[] args) {
		GasStation test = new GasStation();
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		int x = test.canCompleteCircuit(gas, cost);
		System.out.println(x);
	}
}
