package ctci;

public class Solution_17_3 {
	public static int countZero(int n) {
		int factor = 5;
		int count = 0;
		for (; factor <= n; factor = factor * 5) {
			for (int i = 1; i <= n; i++) {
				if (i % factor == 0) 
					count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countZero(25));
	}
}
