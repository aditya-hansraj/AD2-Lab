import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ar = {2, 1, 4, 6, 3, 1, 0, -1, 6};
		System.out.println("Before Sorting: ");
		System.out.println(Arrays.toString(ar));
		selectionSortR(ar);
		System.out.println("After Sorting: ");
		System.out.println(Arrays.toString(ar));
	}
	private static void swap(int[] ar, int i, int j) {
		ar[i] = ar[i] + ar[j];
		ar[j] = ar[i] - ar[j];
		ar[i] = ar[i] - ar[j];
	}
	static void bubbleSort(int[] ar) {
		int i=0, j = ar.length-1;
		while(j > 0) {
			i=0;
			while(i < j) {
				if(i < ar.length-1 && ar[i] > ar[i+1])
					swap(ar, i, i+1);
				i++;
			}
			j--;
		}
		
	}
	static void bubbleSortR(int[] ar) { // recursive
		bubbleSort(ar, ar.length);		//		|
	}									//		|
	private static void bubbleSort(int arr[], int n) 
    {  
        if (n == 1) 
            return; 
  
         int count = 0; 
        for (int i=0; i<n-1; i++) 
            if (arr[i] > arr[i+1]) 
            { 
                swap(arr, i, i+1);
                 count++; 
            } 
        if (count == 0) 
            return; 
        bubbleSort(arr, n-1); 
    } 
	static void insertionSort(int[] arr) {
		int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
	}
	static void insertionSortR(int[] ar) {
		if(ar.length == 0)
			return;
		insertionSort(ar, 1);
	}
	private static void insertionSort(int[] ar, int i) {
		if(i == ar.length)
			return;
		int j = i-1, k = ar[i];
		while(j >= 0 && ar[j] > k)
			ar[j+1] = ar[j--];
		ar[j+1] = k;
		insertionSort(ar, i+1);
	}
	
	static void selectionSort(int[] ar) {
		for(int i = 0; i < ar.length; i++) {
			int min = i;
			for(int j = i; j < ar.length; j++) 
				if(ar[j] < ar[min])
					min = j;
			
			if(i != min)
				swap(ar, i, min);
		}
	}
	//recursive
	public static void selectionSortR(int[] ar) {
		if(ar.length <= 1)
			return;
		selectionSort(ar, 0);
	}
	private static void selectionSort(int[] ar, int i) {
		if(i == ar.length)
			return;
		int m = i;
		for(int j = i; j < ar.length; j++)
			if(ar[j] < ar[m])
				m = j;
		if(i != m)
			swap(ar, i, m);
		selectionSort(ar, i+1);
	}
}
