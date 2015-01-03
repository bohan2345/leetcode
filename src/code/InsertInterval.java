package code;

import java.util.ArrayList;
import java.util.List;

import test.MergeIntervalsTest.Interval;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null || intervals.size() == 0) {
			List<Interval> res = new ArrayList<>();
			res.add(newInterval);
			return res;
		}
		// binary search
		int p = search(intervals, newInterval);
		// insert
		// merge with before
		if (p > 0) {
			Interval inteBefore = intervals.get(p - 1);
			if (inteBefore.end >= newInterval.start) {
				newInterval.start = inteBefore.start;
				if (inteBefore.end >= newInterval.end)
					return intervals;
				intervals.remove(p - 1);
				p--;
			}
		}
		// merge with after
		while (p < intervals.size()) {
			Interval inteAfter = intervals.get(p);
			if (inteAfter.start <= newInterval.end) {
				newInterval.end = Math.max(newInterval.end, inteAfter.end);
				intervals.remove(p);
			} else
				break;
		}
		intervals.add(p, newInterval);
		return intervals;
	}

	public int search(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			return 0;
		}
		int left = 0, right = intervals.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (newInterval.start == intervals.get(mid).start) {
				return mid;
			}
			if (newInterval.start < intervals.get(mid).start) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public List<Interval> insertII(List<Interval> intervals, Interval newInterval) {
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
