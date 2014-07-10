package code;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		// ArrayList<Integer> sums = new ArrayList<Integer>();
		// pathSum(grid, 0, 0, sums, 0);
		// if (sums.size() == 0)
		// return 0;
		// int min = sums.get(0);
		int i = grid.length;
		if (i <= 0) {
			return 0;
		}
		int j = grid[0].length;
		int[][] sums = new int[i][j];
		sums[0][0] = grid[0][0];
		int a, b;
		for (a = 1; a < i; a++) {
			sums[a][0] = sums[a - 1][0] + grid[a][0];
		}
		for (b = 1; b < j; b++) {
			sums[0][b] = sums[0][b - 1] + grid[0][b];
		}
		for (a = 1; a < i; a++) {
			for (b = 1; b < j; b++) {
				sums[a][b] = (sums[a - 1][b] > sums[a][b - 1] ? sums[a][b - 1] : sums[a - 1][b]) + grid[a][b];
			}
		}
		return sums[i - 1][j - 1];

		// if (grid.length <= 0)
		// return 0;
		// else
		// return findMin(grid.length - 1, grid[0].length - 1, grid);
	}

	// public void pathSum(int[][] grid, int i, int j, ArrayList<Integer> sums,
	// int sum) {
	// if (i < grid.length - 1 && j < grid[0].length - 1) {
	// pathSum(grid, i + 1, j, sums, sum + grid[i][j]);
	// pathSum(grid, i, j + 1, sums, sum + grid[i][j]);
	// } else if (i < grid.length - 1 && j == grid[0].length - 1) {
	// pathSum(grid, i + 1, j, sums, sum + grid[i][j]);
	// } else if (i == grid.length - 1 && j < grid[0].length - 1) {
	// pathSum(grid, i, j + 1, sums, sum + grid[i][j]);
	// } else if (i == grid.length - 1 && j == grid[0].length - 1) {
	// if (sums.size() > 0) {
	// if (sums.get(0) > sum + grid[i][j]) {
	// sums.remove(0);
	// sums.add(sum + grid[i][j]);
	// }
	// } else
	// sums.add(sum + grid[i][j]);
	// }
	// }

	public int findMin(int i, int j, int[][] grid) {
		if (i == 0 && j == 0) {
			return grid[i][j];
		} else if (i == 0 && j > 0) {
			return findMin(i, j - 1, grid) + grid[i][j];
		} else if (i > 0 && j == 0) {
			return findMin(i - 1, j, grid) + grid[i][j];
		} else if (i > 0 && j > 0) {
			return (findMin(i, j - 1, grid) > findMin(i - 1, j, grid) ? findMin(i - 1, j, grid) : findMin(i, j - 1, grid)) + grid[i][j];
		} else
			return 0;
	}
}
