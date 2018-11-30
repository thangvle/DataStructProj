package sort;

import java.util.Random;

/**
 *  Run for 100 times
 *  count every time it swab
 *
 */
public class sortMethod {
    public static int countCompare = 0;
    public static int countSwap = 0;

    //Insert Sort
    static void  insertSort(int arr[])
    {
        int n = arr.length;
        // runtime
        // number of swap
        // number of comparison
        countCompare = 0;
        countSwap = 0;
        for (int i=1; i<n; ++i)
        {

            int key = arr[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
                countSwap++;

            }
            countCompare++;
            arr[j+1] = key;


        }

    }

    private int partition (int arr[], int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);
        //countSwap = 0;
        //countCompare = 0;

        for (int j = start; j < end; j++) {
            countCompare++;
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
                countSwap++;
            }
        }
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        countSwap++;

        return i + 1;
    }

    void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    //Merge Sort
    void merge (int arr[], int l, int m, int r) {
        //set up sub-array
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1]; //  left
        int R[] = new int [n2]; //  right

        //Copying data to sub-array
        for (int i = 0; i < n1; i++){
            L[i] = arr[ l + i];
        }
        for (int j = 0; j < n2; j++){
            R[j] = arr[m + 1 + j];
        }

        //  initializing the first and second sub-arrays
        int i = 0, j = 0, k = l;


        while (i < n1 && j < n2) {
            countCompare++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                //countSwap++;
                i++;
            }
            else {
                arr[k] = R[j];
                //countSwap++;
                j++;
            }
            k++;
        }

        //  Copying remaining of left sub-array
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        //  Copying remaining of right sub-array
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {

        Random r1 = new Random(124);
        Random r2 = new Random(113);
        Random r3 = new Random(141);

        sortMethod obj = new sortMethod();

        int arr[] = new int[5];
        int arr2[] = new int[5];
        int arr3[] = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r1.nextInt(arr.length);
        }

        for (int j = 0; j < arr2.length; j++) {
            arr2[j] = r2.nextInt(arr.length);
        }

        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = r3.nextInt(arr.length);
        }

        System.out.println("Array 1: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Array 2: ");

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        System.out.println();

        System.out.println("Array 3: ");

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }


        System.out.println();
        System.out.println();

        System.out.println("Insertion sort");
        long startTime = System.nanoTime();
        insertSort(arr);
        long estimateTime = System.nanoTime()-startTime;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }



        System.out.println();

        System.out.println("Count Swap: " + countSwap);
        System.out.println("Count Compare: " + countCompare);
        System.out.println("Time elapsed: " + estimateTime + " nanosecond");

        countCompare = 0;
        countSwap = 0;
        System.out.println();

        System.out.println("Quick sort");

        long startTime2 = System.nanoTime();
        obj.quickSort(arr2, 0, arr.length-1);
        long estimateTime2 = System.nanoTime() - startTime2;

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        System.out.println("Count Swap: " + countSwap);
        System.out.println("Count Compare: " + countCompare);
        System.out.println("Time elapsed: " + estimateTime2 + " nanosecond");

        System.out.println();

        System.out.println("Merge sort");
        countSwap = 0;
        countCompare = 0;

        long startTime3 = System.nanoTime();
        obj.mergeSort(arr3, 0,arr3.length-1);
        long estimateTime3 = System.nanoTime() - startTime3;

        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();

        System.out.println("Count Swap: " + countSwap);
        System.out.println("Count Compare: " + countCompare);
        System.out.println("Time elapsed: " + estimateTime3 + " nanosecond");
    }

}
