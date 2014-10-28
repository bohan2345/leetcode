package code;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		if (num.length == 0)
			return res;
		boolean[] visited = new boolean[num.length];
		Arrays.sort(num);
		dfs(num, visited, new ArrayList<Integer>(), res);
		return res;
	}

	public void dfs(int[] num, boolean[] visited, List<Integer> tmp, List<List<Integer>> res) {
		if (tmp.size() == num.length) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				if (i > 0 && num[i] == num[i - 1] && !visited[i - 1])
					continue;
				tmp.add(num[i]);
				visited[i] = true;
				dfs(num, visited, tmp, res);
				visited[i] = false;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
