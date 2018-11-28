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
                countCompare++;
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
            countSwap++;

        }
        System.out.println("Swap count: " + countSwap);
        System.out.println("Compare count: " + countCompare);
    }

    public static void main(String[] args) {

        Random r = new Random(124);

        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(arr.length);
        }

        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

}
