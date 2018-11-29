package sort;

import java.util.Random;

/**
 *  Run for 100 times
 *  count every time it swab
 *
 */
public class sortMethod {
    static void  insertSort(int arr[])
    {
        int n = arr.length;
        // runtime
        // number of swap
        // number of comparison
        int countCompare = 0;
        int countSwap = 0;
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
        System.out.println("Swap count: " + countSwap);
        System.out.println("Compare count: " + countCompare);
    }

    private int partition (int arr[], int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);
        int countSwap = 0;
        int countCompare = 0;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                countCompare++;
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
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

    public static void main(String[] args) {

        Random r = new Random(124);
        Random t = new Random(113);

        sortMethod obj = new sortMethod();

        int arr[] = new int[100];
        int arr2[] = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(arr.length);
        }

        for (int j = 0; j < arr2.length; j++) {
            arr2[j] = t.nextInt(arr.length);
        }

        System.out.println("New array2: ");

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        System.out.println();

        System.out.println("Insertion sort");
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


        System.out.println();

        System.out.println("Quick sort");

        obj.quickSort(arr2, 0,arr2[arr.length-1]);

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }

}
