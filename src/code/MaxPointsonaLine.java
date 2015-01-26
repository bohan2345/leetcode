package code;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {
	static class Point {
		int x;
		int y;

		public Point() {
			x = 0;
			y = 0;
		}

		public Point(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}

	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		if (points.length < 2)
			return points.length;
		Map<Double, Integer> table = new HashMap<>();
		int dup = 1, max = 0;
		for (int i = 0; i < points.length; i++) {
			table.clear();
			dup = 1;
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					dup++;
				} else {
					double k;
					if (points[i].x == points[j].x) {
						k = Double.MAX_VALUE;
					} else {
						k = (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x);
					}
					if (table.containsKey(k)) {
						table.put(k, table.get(k) + dup);
					} else {
						table.put(k, 1 + dup);
					}
					dup = 1;
					max = Math.max(max, table.get(k));
				}
				max = Math.max(dup, max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaxPointsonaLine test = new MaxPointsonaLine();
		Point[] points = new Point[4];
		points[0] = new Point(3, 1);
		points[1] = new Point(12, 3);
		points[2] = new Point(3, 1);
		points[3] = new Point(-6, -1);
		int i = test.maxPoints(points);
		System.out.println(i);
	}
}
