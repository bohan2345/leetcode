package code;

public class RotateImage {
	public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            throw new IllegalArgumentException("hehe");
        int n = matrix.length;
        for (int l = 0; l < n / 2; l++) {
            for (int i = l; i < n - l - 1; i++) {
                int tmp = matrix[l][i];
                matrix[l][i] = matrix[n - i - 1][l];
                matrix[n - i - 1][l] = matrix[n - l - 1][n - i - 1];
                matrix[n - l - 1][n - i - 1] = matrix[i][n - l - 1];
                matrix[i][n - l - 1] = tmp;
            }
        }
    }
}
