package com.company;
//http://www.java2s.com/Tutorial/Java/0140__Collections/Quicksortwithmedianofthreepartitioning.htm
//https://gist.github.com/epomp447/4c0d0676d9f013788647cbe6e60ae0df
//https://www.java-forums.org/algorithms/7565-quick-sort-median-three-partitioning.html


public class QuickSort3 {
    public static void recursiveQuickSort(int[] array, int left, int right) {
        int size = right - left  + 1;
        if (size <= 3)
            manualSort(array, left, right);
        else {
            double median = medianOf3(array, left, right);
            int partition = partition(array, left, right - 1, median);
            recursiveQuickSort(array, left, partition - 1);
            recursiveQuickSort(array, partition + 1, right);
        }
    }

    public static void iterativeQuickSort(int[] array, int low, int high) {


        int size = high - low + 1;
        //if size is less than 3 we can manual sort.
        if (size <= 3)
            manualSort(array, low, high);
        else {
            //Creating temp array
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

                //calculate the median and the index
                int mid = medianOf3(array, low, high);
                int index = partition(array, low, high, mid) - 1;

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


    }


    private static int medianOf3(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        // order left & center
        if (array[left] > array[mid])
            swap(array, left, mid);
        // order left & right
        if (array[left] > array[right])
            swap(array, left, right);
        // order center & right
        if (array[mid] > array[right])
            swap(array, mid, right);

        swap(array, mid, right - 1); //right of pivot
        return array[right - 1]; //returns the median value
    }

    private static void swap(int[] array, int TempInt1, int TempInt2) {
        int temp = array[TempInt1];
        array[TempInt1] = array[TempInt2];
        array[TempInt2] = temp;
    }

    private static int partition(int[] intArray, int left, int right, double pivot) {
        int leftPointer = left; //right of first element
        int rightPointer = right; //left of pivot

        while (true) {
            while (intArray[++leftPointer] < pivot) //find bigger
                ;
            while (intArray[--rightPointer] > pivot) //find smaller
                ;
            if (leftPointer >= rightPointer) //if the pointers cross, partition ends
                break;
            else
                swap(intArray, leftPointer, rightPointer); //if not crossed elements are swapped
        }
        swap(intArray, leftPointer, right); //place pivot back to original location
        return leftPointer; //returns the new pivot
    }

    private static void manualSort(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            //if size is 1 or less no need to sort.
            return;
        //if only two elements they are compared then swapped if needed
        if (size == 2) {
            if (array[left] > array[right])
                swap(array, left, right);
            return;
            //if 3, compare left to center, left to right then right to center and swap accordingly
        } else {
            if (array[left] > array[right - 1])
                swap(array, left, right - 1);
            if (array[left] > array[right])
                swap(array, left, right);
            if (array[right - 1] > array[right])
                swap(array, right - 1, right);
        }
    }




}
