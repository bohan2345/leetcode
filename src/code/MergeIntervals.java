package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import test.MergeIntervalsTest.Interval;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null)
			return res;
		Collections.sort(intervals, new IntervalComparator());
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			int start = interval.start;
			int end = interval.end;
			for (int j = i + 1; j < intervals.size(); j++) {
				if (end >= intervals.get(j).start) {
					end = Math.max(intervals.get(j).end, end);
					i = j;
				} else {
					break;
				}
			}
			res.add(new Interval(start, end));
		}
		return res;
	}

	class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start)
				return 1;
			else if (o1.start == o2.start)
				return 0;
			else
				return -1;
		}
	}
}
