
public class assignment {

	public static void main(String[] args) {
		System.out.println(pow(2,0));
	}
	static int pow(int x, int n) {
		if(n == 0)
			return 1;
		return x * pow(x, n-1);
	}
	static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	static int linearSearch(int[] ar, int target, int n) {
		if(n == 0)
				return -1;
		else if(ar[n-1] == target)
				return n-1;
		return linearSearch(ar, target, n-1);
	}
	static int fact(int n) {
		return (n==0) ? 1 : fact(n-1)*n;
	}
	static int fibonacci(int n) {
		if(n <= 1)
			return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
