package code;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public int totalNQueens(int n) {
		return solveNQueens(n).size();
	}

	public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        solve(n, 0, new int[n], res);
        return res;
    }
    
    void solve(int n, int row, int[] pos, List<String[]> res) {
        if (row == n) {
            res.add(build(pos));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isValid(row, i, n, pos)) {
                pos[row] = i;
                solve(n, row + 1, pos, res);
                pos[row] = 0;
            }
        }
    }
    
    boolean isValid(int row, int col, int n, int[] pos) {
        for (int i = 0; i < n; i++) {
        	if (pos[i] == 0)
        		continue;
            if (pos[i] == col)
                return false;
            int d = Math.abs(row - i);
            if (pos[i] == col - d || pos[i] == col + d)
                return false;
        }
        return true;
    }
    
    String[] build(int[] pos) {
        String[] table = new String[pos.length];
        for (int i = 0; i < pos.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pos.length; j++) {
                if (pos[i] == j + 1)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            table[i] = sb.toString(); 
        }
        return table;
    }
}
