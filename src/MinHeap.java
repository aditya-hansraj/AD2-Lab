import java.util.Arrays;

public class MinHeap {
    public static void heapSort(int[] ar) {
        int n = ar.length;
        buildHeap(ar);
        for (int i = n - 1; i > 0; i--) {
            int temp = ar[0];
            ar[0] = ar[i];
            ar[i] = temp;
            heapify(ar, i, 0);
        }
    }
    private static void buildHeap(int[] ar) {
    	int n = ar.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(ar, n, i);
        }
    }

    private static void heapify(int[] ar, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && ar[left] < ar[smallest]) {
            smallest = left;
        }

        if (right < n && ar[right] < ar[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int swap = ar[i];
            ar[i] = ar[smallest];
            ar[smallest] = swap;

            heapify(ar, n, smallest);
        }
    }

    public static void main(String[] args) {
        int[] ar = {12, 11, 13, 5, 6, 7};
        heapSort(ar);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(ar));
    }
}
