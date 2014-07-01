package test;

import code.BestTimeStock;

public class BestTimeStockTest {
	public static void main(String[] args){
		int[] p = {1,4,9,2,8};
		int m= (new BestTimeStock()).maxProfit(p);
		
		System.out.print(m);
	}
}
