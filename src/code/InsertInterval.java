package code;

import java.util.ArrayList;
import java.util.List;

import test.MergeIntervalsTest.Interval;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		List<Interval> affectIntervals = new ArrayList<>();
		affectIntervals.add(newInterval);
		for (int i = 0; i < intervals.size(); i++) {
			if (overlap(intervals.get(i), newInterval))
				affectIntervals.add(intervals.get(i));
			else
				res.add(intervals.get(i));
		}
		res.addAll(new MergeIntervals().merge(affectIntervals));
		return res;
	}

	private boolean overlap(Interval a, Interval b) {
		if (a.end >= b.start || a.start <= b.end)
			return true;
		else
			return false;
	}
}
