package code;

public class SearchInsert {
	public int searchInsert(int[] A, int target) {
		if (A[0] > target) {
			return 0;
		} else if (A[A.length - 1] < target) {
			return A.length;
		} else {
			return binarySearch(A, target, 0, A.length - 1);
		}
	}

	public int binarySearch(int[] A, int key, int imin, int imax) {
		if (imax < imin) {
			return imin;
		}
		int imid = (imin + imax) / 2;
		if (key > A[imid]) {
			return binarySearch(A, key, imid + 1, imax);
		} else if (key < A[imid]) {
			return binarySearch(A, key, imin, imid - 1);
		} else
			return imid;
	}

	public int binarySearchII(int[] A, int key, int imin, int imax) {
		while (imax >= imin) {
			int imid = (imin + imax) / 2;
			if (key > A[imid]) {
				imin = imid+1;
			} else if (key < A[imid]) {
				imax = imid - 1;
			} else{
				return imid;
			}
		}
		return imin;
	}
}
