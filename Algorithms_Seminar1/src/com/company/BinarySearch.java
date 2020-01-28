package com.company;
//https://medium.com/@gustavo.ponce.ch/binary-search-with-java-recursive-iterative-java-collections-5a12a814a27c
//https://www.geeksforgeeks.org/binary-search/

public class BinarySearch {

    public boolean binarySearch(int search, int[] array) {

        int index = binarySearch(search, array, 0, array.length - 1);
        //converts int into boolean
        return index != -1;
    }

    private static int binarySearch(int search, int[] array, int low, int high) {

        if (high >= low) {
            int mid = high + ( low - high) / 2;


            if (array[mid] == search)
                return mid;
            //Int found

            if (array[mid] > search)
                return binarySearch(search, array, low, mid - 1);


            // array split into two and recursively splits and search the two halfs
            return binarySearch(search, array, mid + 1, high);
        }

        // When int being serach is not found in the array.
        return -1;
    }
}
