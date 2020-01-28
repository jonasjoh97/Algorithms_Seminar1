package com.company;
//https://www.geeksforgeeks.org/hoares-vs-lomuto-partition-scheme-quicksort/
//https://www.geeksforgeeks.org/iterative-quick-sort/


public class QuickSort {

    public static void recursiveQuickSort(int[] array, int low, int high) {
        //returns if left pivot is smaller than right pivot
        if (low < high) {
            //Calculates the partition index
            int index = partition(array, low, high);
            //recursively calls quickSort
            //Low half
            recursiveQuickSort(array, low, index);
            //High Half
            recursiveQuickSort(array, index + 1, high);

        }


    }

    public static void iterativeQuickSort(int[] array, int low, int high) {

        //Creating temp array to
        int[] stack = new int[high - low + 1];

        //int top is equal to the total length of the stack
        int top = -1;

        //Push the first low and high values into the stack
        stack[++top] = low;
        stack[++top] = high;

        //Keep looping while stack not empty
        while (top >= 0) {

            //remove high and low from stack
            high = stack[top--];
            low = stack[top--];

            //calculate the index
            int index = partition(array, low, high);

            //If low is less than index set the low to the stack
            if (index > low) {
                stack[++top] = low;
                stack[++top] = index;
            }

            //If high is more than index, set high to stack
            if (index + 1 < high) {
                stack[++top] = index + 1;
                stack[++top] = high;
            }
            //If number not moved, already in right place.
        }


    }


    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low - 1, j = high + 1;

        while (true) {
            // Find leftmost element greater
            // than or equal to pivot
            do {
                i++;
            } while (array[i] < pivot);
            // Find rightmost element smaller
            // than or equal to pivot
            do {
                j--;
            } while (array[j] > pivot);

            // If two pointers met.
            if (i >= j)
                return j;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            //swap(arr[i], arr[j]);
        }
    }

}