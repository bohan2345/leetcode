package test;

import java.util.ArrayList;
import java.util.List;

import code.InsertInterval;
import test.MergeIntervalsTest.Interval;

public class InsertIntervalTest {
	public static void main(String[] args) {
		Interval a = new Interval(1, 2);
		Interval b = new Interval(3, 4);
		Interval c = new Interval(5, 5);
		Interval d = new Interval(7, 8);
		Interval e = new Interval(0, 9);
		List<Interval> intervals = new ArrayList<>();
		intervals.add(a);
		intervals.add(b);
		intervals.add(c);
		intervals.add(d);
//		System.out.println(new InsertInterval().search(intervals, e));
		 new InsertInterval().insert(intervals, e);
		 System.out.println(intervals.toString());
	}
}
