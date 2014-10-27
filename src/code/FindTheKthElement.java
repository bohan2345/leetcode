package code;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheKthElement {
	public int[] findBig(int[] A, int k) {
		int[] res = new int[k];
		Queue<Integer> Q = new PriorityQueue<>();
		for (int i = 0; i < A.length; i++) {
			Q.offer(A[i]);
			if (Q.size() == k + 1) {
				Q.poll();
			}
		}
		int x = 0;
		while (x < k) {
			res[x] = Q.poll();
			x++;
		}
		return res;
	}
}
