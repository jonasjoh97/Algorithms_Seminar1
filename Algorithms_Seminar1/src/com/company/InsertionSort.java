package com.company;
//https://www.techiedelight.com/insertion-sort-iterative-recursive/
//https://www.geeksforgeeks.org/recursive-insertion-sort/
//https://www.geeksforgeeks.org/insertion-sort/

public class InsertionSort {

    public void iterativeInsertionSort(int[] array){
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int selected = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > selected) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = selected;
        }

    }

    public void recursiveInsertionSort(int[] array, int low, int high){
        int value = array[low];
        int j = low;

        // Find index j within the sorted subset arr[0..i-1]
        // where element arr[i] belongs
        while (j > 0 && array[j - 1] > value)
        {
            array[j] = array[j - 1];
            j--;
        }

        array[j] = value;

        // Note that subarray arr[j..i-1] is shifted to
        // the right by one position i.e. arr[j+1..i]

        if (low + 1 <= high) {
            recursiveInsertionSort(array, low + 1, high);
        }
    }
}
