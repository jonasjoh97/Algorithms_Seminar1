package com.company;

import java.io.File;
import java.util.Scanner;

public class Test {
    Menu menu = new Menu();
    private MergeSort mergeSort = new MergeSort();
    private InsertionSort insertionSort = new InsertionSort();
    private Timer timer = new Timer();
    private QuickSortRandom quickSortRandom = new QuickSortRandom();
    private BinarySearch binarySearch = new BinarySearch();

    public void test(){
        System.out.println("-----------100--------");
        for (int i = 0; i < 100; i++){
            int array[] = new int[100];
            fillArray(array);
            int n = 100;

            timer.startTimer();
           // quickSortRandom.recursiveQuickSort(array, 0, n - 1);
            //quickSortRandom.iterativeQuickSort(array, 0, n - 1);
            QuickSort3.recursiveQuickSort(array, 0, n - 1);
            //intersectionSort.recursiveIntersectionSort(array, 0, n - 1);
            //insertionSort.iterativeInsertionSort(array);
            //mergeSort.recursiveMergeSort(array, n);
            //mergeSort.iterativeMergeSort(array, n);
            //QuickSort3.iterativeQuickSort(array, 0, n - 1);
            timer.stopTimer();
            System.out.println(timer.toString());
        }
        System.out.println("-----------1000--------");
        for (int i = 0; i < 100; i++){
            int array[] = new int[1000];
            fillArray(array);
            int n = 1000;

            timer.startTimer();
            //quickSortRandom.recursiveQuickSort(array, 0, n - 1);
            //quickSortRandom.iterativeQuickSort(array, 0, n - 1);
            QuickSort3.recursiveQuickSort(array, 0, n - 1);
            //intersectionSort.recursiveIntersectionSort(array, 0, n - 1);
            //insertionSort.iterativeInsertionSort(array);
            //mergeSort.recursiveMergeSort(array, n);
            //mergeSort.iterativeMergeSort(array, n);
            //QuickSort3.iterativeQuickSort(array, 0, n - 1);
            timer.stopTimer();
            System.out.println(timer.toString());
        }
        System.out.println("-----------1000000--------");
        for (int i = 0; i < 20; i++){
            int array[] = new int[1000000];
            fillArray(array);
            int n = 1000000;

            timer.startTimer();
            //quickSortRandom.recursiveQuickSort(array, 0, n - 1);
            //quickSortRandom.iterativeQuickSort(array, 0, n - 1);
            QuickSort3.recursiveQuickSort(array, 0, n - 1);
            //intersectionSort.recursiveIntersectionSort(array, 0, n - 1);
            //insertionSort.iterativeInsertionSort(array);
            //mergeSort.recursiveMergeSort(array, n);
            //mergeSort.iterativeMergeSort(array, n);
            //QuickSort3.iterativeQuickSort(array, 0, n - 1);
            timer.stopTimer();
            System.out.println(timer.toString());
        }
    }

    private static void fillArray(int[] array) {
        try {
            Scanner scanner = new Scanner(new File("src/RandomNumbers.txt"));
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
