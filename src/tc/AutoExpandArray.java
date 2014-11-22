package tc;

public class AutoExpandArray {
	int[] A;
	int capacity;
	int i;

	public AutoExpandArray(int n) {
		if (n < 1)
			throw new RuntimeException("capacity be positive");
		A = new int[n];
		i = 0;
		capacity = n;
	}

	public void add(int n) {
		try {
			A[i] = n;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("expanding!");
			//e.printStackTrace();
			capacity *= 2;
			int[] tmp = new int[capacity];
			for (int i = 0; i < A.length; i++) {
				tmp[i] = A[i];
			}
			A = tmp;
			A[i] = n;
		}
		i++;
	}

	public int getLastElement() {
		return this.A[this.i - 1];
	}

	public static void main(String[] args) {
		AutoExpandArray test = new AutoExpandArray(2);
		for (int i = 1; i < 10; i++)
			test.add(i);
		System.out.println(test.getLastElement());
	}
}
