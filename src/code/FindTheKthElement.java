package code;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheKthElement {
	public int[] findBig(int[] A, int k) {
		int[] res = new int[k];
		Queue<Integer> Q = new PriorityQueue<>(k);
		for (int i = 0; i < A.length; i++) {
			Q.offer(A[i]);
		}
		int x = 0;
		while (x < k) {
			res[x] = Q.poll();
			x++;
		}
		return res;
	}
}
