package test;

import java.util.ArrayList;
import java.util.List;

import code.Triangle;

public class TriangleTest {
	public static void main(String[] args) {
		Triangle test = new Triangle();
		List<List<Integer>> A = new ArrayList<>();
		List<Integer> a = new ArrayList<>();
		a.add(1);
		List<Integer> aa = new ArrayList<>();
		aa.add(2);
		aa.add(3);
		A.add(a);
		A.add(aa);
		List<Integer> aaa = new ArrayList<>();
		aaa.add(4);
		aaa.add(5);
		aaa.add(6);
		A.add(aaa);
		int s = test.minimumTotal(A);
		System.out.println(s);
	}
}
