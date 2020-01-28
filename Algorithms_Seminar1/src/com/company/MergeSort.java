package com.company;
//https://www.geeksforgeeks.org/merge-sort/
//https://www.baeldung.com/java-merge-sort
//https://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html

public class MergeSort {
    private void recursiveMerge(int array[], int left[], int right[], int low, int high) {

        //Int i for left, int j for right, int k for array
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            //If left is equal of smaller then right, int k and i increase, array k also = to left i (Placing in order)
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        //Being copied to original array
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }


    }

    public void recursiveMergeSort(int array[], int high) {
        if (high < 2) {
            return;
        }
        int mid = high / 2;
        //calculates size of the sub arrays
        int subArrayLeft = mid;
        int subArrayRight = high - mid;

        //inizilaing temp arrays with the calculated size
        int left[] = new int[subArrayLeft];
        int right[] = new int[subArrayRight];

        //filling subarrays with data
        for (int i = 0; i < subArrayLeft; i++) {
            left[i] = array[i];
        }
        for (int j = mid; j < high; j++) {
            right[j - mid] = array[j];
        }

        recursiveMergeSort(left, mid);
        recursiveMergeSort(right, high - mid);

        recursiveMerge(array, left, right, mid, high - mid);
    }


    static void iterativeMergeSort(int array[], int n) {


        int currentSize;

        int leftStart;

        for (currentSize = 1; currentSize <= n - 1;
             currentSize = 2 * currentSize) {

            // Pick starting point of different
            // subarrays of current size
            for (leftStart = 0; leftStart < n - 1;
                 leftStart += 2 * currentSize) {
                // Find ending point of left
                // subarray. mid+1 is starting
                // point of right
                int mid = Math.min(leftStart + currentSize - 1, n - 1);

                int rightEnd = Math.min(leftStart
                        + 2 * currentSize - 1, n - 1);

                // Merge Subarrays arr[left_start...mid]
                // & arr[mid+1...right_end]
                iterativeMerge(array, leftStart, mid, rightEnd);
            }
        }
    }

    /* Function to merge the two haves arr[l..m] and
    arr[m+1..r] of array arr[] */
    private static void iterativeMerge(int array[], int l, int m, int r) {
        int i, j, k;
        int left = m - l + 1;
        int right = r - m;

        /* create temp arrays */
        int leftArray[] = new int[left];
        int rightArray[] = new int[right];

        /* Copy data to temp arrays L[]
        and R[] */
        for (i = 0; i < left; i++)
            leftArray[i] = array[l + i];
        for (j = 0; j < right; j++)
            rightArray[j] = array[m + 1 + j];

        /* Merge the temp arrays back into
        arr[l..r]*/
        i = 0;
        j = 0;
        k = l;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        /* Copy the remaining elements of
        L[], if there are any */
        while (i < left) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        /* Copy the remaining elements of
        R[], if there are any */
        while (j < right) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
