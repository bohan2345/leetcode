package tc;

import tc.myinterface.MyInterface;

public class functionReference implements MyInterface {
	public void callback(int x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		run(A, new functionReference());
	}
	
	public static void run(int[] A, MyInterface m) {
		for (int a : A) {
			m.callback(a);
		}
	}
}
