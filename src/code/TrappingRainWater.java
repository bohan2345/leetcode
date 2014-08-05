package code;

import java.util.ArrayList;

public class TrappingRainWater {
	public int trap(int[] A) {
		int sum = 0;
		if (A.length < 2) {
			return sum;
		}
		ArrayList<Integer> peaks = getAllPeaks(A);
		if (peaks.size() < 2) {
			return 0;
		}
		int j = 0;
		while (j < peaks.size() - 1) {
			int z = j + 1;
			int max = z;
			while (z < peaks.size()) {
				if (A[peaks.get(z)] > A[peaks.get(j)]) {
					max = z;
					sum += getWater(A, peaks.get(j), peaks.get(z));
					break;
				}
				max = A[peaks.get(z)] > A[peaks.get(max)] ? z : max;
				z++;
			}
			if(A[peaks.get(max)] > A[peaks.get(j)]){
			    j = max;
			    continue;
			}
			sum += getWater(A, peaks.get(j), peaks.get(max));
			j = max;
		}
		return sum;
	}

	public ArrayList<Integer> getAllPeaks(int[] A) {
		ArrayList<Integer> peaks = new ArrayList<Integer>();
		boolean decrease = false;
		for (int i = 1; i < A.length; i++) {
			// find decrease range
			if (A[i] - A[i - 1] < 0) {
				if (!decrease) {
					peaks.add(i - 1);
				}
				decrease = true;
			} else {
				decrease = false;
			}
		}
		if (!decrease) {
			peaks.add(A.length - 1);
		}
		return peaks;
	}

	public int getWater(int[] A, int left, int right) {
		int water = 0;
		int height = A[left] < A[right] ? A[left] : A[right];
		for (int i = left + 1; i < right; i++) {
			if (A[i] < height) {
				water += height - A[i];
			}
		}
		return water;
	}
}
