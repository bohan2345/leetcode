package test;

import code.SearchInsert;

public class SearchInsertTest {
	public static void main(String[] args){
		SearchInsert test = new SearchInsert();
		int[] A = {1,2,3,5,6,9,11};
		int target = 12;
		System.out.print(test.searchInsert(A, target));
	}
}
