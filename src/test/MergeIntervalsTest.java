package test;

import java.util.ArrayList;
import java.util.List;

import code.MergeIntervals;

public class MergeIntervalsTest {
	public static class Interval {
		public int start;
		public int end;

		public Interval() {
			start = 0;
			end = 0;
		}

		public Interval(int s, int e) {
			start = s;
			end = e;
		}
		
		public String toString() {
			return start + " -> " + end;
		}
	}

	public static void main(String[] args) {
		Interval i = new Interval(1, 4);
		Interval ii = new Interval(1, 5);
		List<Interval> l = new ArrayList<>();
		l.add(i);
		l.add(ii);
		MergeIntervals test = new MergeIntervals();
		List<Interval> x = test.merge(l);
		System.out.println(x.toString());
	}
}
