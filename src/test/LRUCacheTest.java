package test;

import code.LRUCache;

public class LRUCacheTest {
	public static void main(String[] args) {
		LRUCache test = new LRUCache(1);
		test.set(2,1);
		System.out.println(test.get(2));
		test.set(3,2);
		System.out.println(test.get(2));
		System.out.println(test.get(3));
	}
}
