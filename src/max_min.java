import java.util.Arrays;
import java.util.Collections;

public class max_min {

	public static void main(String[] args) {
		int[] ar = {1,5,2,6,4};
		maxmin(ar);
		System.out.println(Arrays.toString(ar));
	}
	static void maxmin(int[] ar) {
        int i = 0;
        while(i < ar.length-1) {
        	int j = i+1;
        	int m = i;
        	if(i%2==0) {
        		while(j < ar.length) {
            		if(ar[m] < ar[j])
            			m = j;
            		j++;
            	}
        	}else {
        		while(j < ar.length) {
            		if(ar[m] > ar[j])
            			m = j;
            		j++;
            	}
        	}
        	if(m!=i)
        		swap(ar, i, m);
        	i++;
        }
	}
	static void reverse(int[] ar) {
		int i = 0, j = ar.length-1;
		while(i < j) 
			swap(ar, i++, j--);
	}
	static void swap(int[] ar, int i, int j) {
		int t = ar[i];
		ar[i] = ar[j];
		ar[j] = t;
	}
}
