package test;

import tc.ArrayQueue;

public class ArrayQueueTest {
	public static void main(String[] args) {
		ArrayQueue<Integer> test = new ArrayQueue<>();
		test.offer(1);
		test.offer(2);
		test.offer(3);
		test.offer(4);
		test.offer(5);
		System.out.println(test.poll());
		System.out.println(test.poll());
		System.out.println(test.poll());
		test.offer(6);
		test.offer(7);
		test.offer(8);
		System.out.println(test.poll());
		System.out.println(test.poll());
		System.out.println(test.poll());
		System.out.println(test.poll());
		System.out.println(test.poll());
	}
}
