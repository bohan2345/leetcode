package test;

import code.BestTimeStock;
import code.BestTimeStockN;

public class BestTimeStockTest {
	public static void main(String[] args) {
		int[] p = { 1, 3, 5, 3, 7, 8, 4, 2, 9 };
		int m = (new BestTimeStock()).maxProfit(p);

		System.out.println(m);
		BestTimeStockN test = new BestTimeStockN();
		int[] A = { 1, 3, 5, 3, 7, 8, 4, 2, 9 };
		System.out.println(test.maxProfit(A, 2));
	}
}
