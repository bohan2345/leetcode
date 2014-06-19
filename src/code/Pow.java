package code;

public class Pow {
//	public double pow(double x, int n) {
//		if (n == 0)
//			return 1;
//		double temp = pow(x, n / 2);
//		if (n % 2 == 0)
//			return temp * temp;
//		else if (n > 0 && n % 2 != 0) {
//			return temp * temp * x;
//		} else if (n < 0 && n % 2 != 0) {
//			return temp * temp / x;
//		} else
//			return 0;
//	}
	
	public double pow(double x, int n) {
        if (n == 0)
			return 1;
		double temp=0;
		if (n % 2 == 0)
			temp = pow(x,n/2) * pow(x,n/2);
		else if (n > 0) {
			temp = pow(x,n/2) * pow(x,n/2) * x;
		} else{
			temp = pow(x,n/2) * pow(x,n/2) / x;
		} 
			return temp;
    }
	
	public int climbStairs(int n) {
        if (n<3) return 1;
        int temp=climbStairs(n-1)+climbStairs(n-2);
        return temp;
    }

	public static void main(String[] arg) {
		Pow p = new Pow();
//		System.out.print(p.climbStairs(7));
		System.out.print(p.pow(2, -1));
	}
}
