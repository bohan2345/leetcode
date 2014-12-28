package code;

public class JumpGameII {
	public int jump(int[] A) {
		if (A == null || A.length == 0)
            return -1;
		int max = 0, step = 0, a = 0, b = 0;
		while (max < A.length - 1) {
			for (int i = a; i <= b; i++) {
				max = Math.max(max, i + A[i]);
			}
			if (max <= b)
				return -1;
			a = b + 1;
			b = max;
			step++;
		}
		return step;
	}
}
