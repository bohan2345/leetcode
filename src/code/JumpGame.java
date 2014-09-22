package code;

public class JumpGame {
	public boolean canJump(int[] A) {
		int x = jump(A, A.length - 1);
		if (x >= 0)
			return true;
		else
			return false;
	}

	public int jump(int[] A, int target) {
		if (target == 0) {
			return 0;
		}
		for (int i = target - 1; i >= 0; i--) {
			if (A[i] >= target - i) {
				return jump(A, i);
			}
		}
		return -1;
	}
}
