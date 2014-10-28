package test;

import tc.ArrayQueue;

public class ArrayQueueTest {
	public static void main(String[] args) {
		ArrayQueue test = new ArrayQueue();
		test.offer(1);
		test.offer(1);
		test.offer(1);
		test.offer(1);
		test.offer(1);
		test.poll();
		test.poll();
		test.poll();
		test.offer(1);
		test.offer(1);
		test.offer(1);
		test.poll();
		test.poll();
		test.poll();
		test.poll();
		test.poll();
	}
}
