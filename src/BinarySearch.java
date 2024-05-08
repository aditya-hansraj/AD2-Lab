import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.print("Enter element you want to search: ");
		int n = sc.nextInt();
		int position = binarySearch(ar, n);
		if(position == -1)
			System.out.println(n+" not found !");
		else
			System.out.println(n+" found at index "+position);
	}
	static Scanner sc = new Scanner(System.in);
	static void inputArray(int[] ar) {
		for(int i = 0; i < ar.length; i++) {
			ar[i] = sc.nextInt();
		}
	}
	
	static int binarySearchIterative(int[] ar, int n) { // Iterative
		int i = 0, j = ar.length-1;
		int m;
		while(i <= j) {
			m = i + (j-i)/2;
			if(ar[m] == n)
				return m;
			else {
				if(ar[m] < n)
					i = m+1;
				else
					j = m-1;
			}
		}
		return -1;
	}
	
	static int binarySearch(int[] ar, int n) {
		return binarySearch(ar, n, 0, ar.length-1);
	}
	private static int binarySearch(int[] ar, int n, int i, int j) {
		int m = i + (j-i)/2;
		if(i>j)
			return -1;
		if(ar[m] == n)
			return m;
		else if(ar[m] < n)
			return binarySearch(ar, n, m+1, j);
		else
			return binarySearch(ar, n, i, m-1);
	}

}
