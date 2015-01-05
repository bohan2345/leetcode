package code;

public class RemoveDuplicatesII {
	public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int count = 1;
        int j = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                A[j] = A[i];
                j++;
            }
        }
        return j;
    }
}
