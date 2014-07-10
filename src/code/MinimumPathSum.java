package code;

import java.util.ArrayList;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		ArrayList<Integer> sums = new ArrayList<Integer>();
		pathSum(grid, 0, 0, sums, 0);
		if (sums.size() == 0)
			return 0;
		int min = sums.get(0);
		return min;
	}

	public void pathSum(int[][] grid, int i, int j, ArrayList<Integer> sums, int sum) {
		if (i < grid.length - 1 && j < grid[0].length - 1) {
			pathSum(grid, i + 1, j, sums, sum + grid[i][j]);
			pathSum(grid, i, j + 1, sums, sum + grid[i][j]);
		} else if (i < grid.length - 1 && j == grid[0].length - 1) {
			pathSum(grid, i + 1, j, sums, sum + grid[i][j]);
		} else if (i == grid.length - 1 && j < grid[0].length - 1) {
			pathSum(grid, i, j + 1, sums, sum + grid[i][j]);
		} else if (i == grid.length - 1 && j == grid[0].length - 1) {
			if (sums.size() > 0) {
				if (sums.get(0) > sum + grid[i][j]) {
					sums.remove(0);
					sums.add(sum + grid[i][j]);
				}
			} else
				sums.add(sum + grid[i][j]);
		}
	}
}
