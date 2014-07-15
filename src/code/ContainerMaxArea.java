package code;

public class ContainerMaxArea {
	public int maxArea(int[] height) {
		int area = 0, h = 0, w = 0, l = 0, r = height.length - 1;
		while (l < r) {
			w = r - l;
			if (height[l] < height[r]) {
				h = height[l];
				l++;
			} else {
				h = height[r];
				r--;
			}
			area = area > h * w ? area : h * w;
		}
		return area;
	}
}
