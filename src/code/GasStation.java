package code;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] remainGas = new int[gas.length];
		for (int i = 0; i < gas.length; i++) {
			if (i == 0)
				remainGas[i] = gas[i] - cost[i];
			else
				remainGas[i] = remainGas[i - 1] + gas[i] - cost[i];
		}
		if (remainGas[remainGas.length - 1] < 0) {
			return -1;
		}
		int position = 0, min = 0;
		for (int i = 0; i < remainGas.length; i++) {
			if (min > remainGas[i]) {
				min = remainGas[i];
				position = i + 1;
			}
		}
		return position;
	}
}
