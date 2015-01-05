package code;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) 
            return false;
        int top = 0, bot = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int line = 0;
        while (top <= bot) {
            int mid = top + (bot - top) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        line = Math.max(bot, 0);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[line][mid] == target) 
                return true;
            if (matrix[line][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
