package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

class Menu {

    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private int n;
    private MergeSort mergeSort = new MergeSort();
    private InsertionSort insertionSort = new InsertionSort();
    private Timer timer = new Timer();
    private QuickSortRandom quickSortRandom = new QuickSortRandom();
    private BinarySearch binarySearch = new BinarySearch();


    public void menu() {
        while (running) {
            int m = 0;

            System.out.println("---------------MENU--------------");
            System.out.println("1. recursive quick sort");
            System.out.println("2. iterative quick sort");
            System.out.println("3. recursive insertion sort");
            System.out.println("4. iterative insertion sort");
            System.out.println("5. recursive merge sort");
            System.out.println("6. iterative merge sort");
            System.out.println("7. binary search");
            System.out.println("8. End program");
            System.out.println("Enter the corresponding number");
            boolean input = false;
            while (!input) {
                m = scanner.nextInt();
                if (m > 0 && m < 9) {
                    input = true;
                } else {
                    System.out.println("wrong input, please input an integer from 1 - 8");
                }
            }
            if (m != 8) {
                System.out.println("---------------------------------");
                System.out.println("1. 100");
                System.out.println("2. 1000");
                System.out.println("3. 1000000");
                System.out.println("input the corresponding numbers to select array length:");
                input = false;
                while (!input) {
                    int menuLength = scanner.nextInt();
                    switch (menuLength) {
                        case 1:
                            n = 100;
                            input = true;
                            break;
                        case 2:
                            n = 1000;
                            input = true;
                            break;
                        case 3:
                            n = 1000000;
                            input = true;
                            break;
                        default:
                            System.out.println("Wrong input, please input integer from 1 - 3");
                    }
                }
                int[] array = new int[n];
                array = fillArray(array);

                try {

                    switch (m) {
                        case 1:
                            System.out.println("---------------------------------");
                            System.out.println("1. median-of-three pivot");
                            System.out.println("2. random pivot");
                            System.out.println("3. pivot = array[0]");
                            System.out.println("please enter the corresponding number ");
                            int quick = scanner.nextInt();
                            switch (quick) {
                                case 1:
                                    timer.startTimer();
                                    QuickSort3.recursiveQuickSort(array, 0, n - 1);
                                    break;
                                case 2:
                                    timer.startTimer();
                                    quickSortRandom.recursiveQuickSort(array, 0, n - 1);
                                    break;
                                case 3:
                                    timer.startTimer();
                                    QuickSort.recursiveQuickSort(array, 0, n - 1);
                                    break;
                                default:
                                    System.out.println("incorrect input");
                            }
                            break;
                        case 2:
                            System.out.println("---------------------------------");
                            System.out.println("1. median-of-three pivot");
                            System.out.println("2. random pivot");
                            System.out.println("3. pivot = array[0]");
                            System.out.println("please enter the corresponding number ");
                            quick = scanner.nextInt();
                            switch (quick) {
                                case 1:
                                    timer.startTimer();
                                    QuickSort3.iterativeQuickSort(array, 0, n - 1);
                                    break;
                                case 2:
                                    timer.startTimer();
                                    quickSortRandom.iterativeQuickSort(array, 0, n - 1);
                                    break;
                                case 3:
                                    timer.startTimer();
                                    QuickSort.iterativeQuickSort(array, 0, n - 1);
                                    break;
                                default:
                                    System.out.println("incorrect input");
                            }

                            break;
                        case 3:
                            timer.startTimer();
                            insertionSort.recursiveInsertionSort(array, 1, n - 1);
                            break;
                        case 4:
                            timer.startTimer();
                            insertionSort.iterativeInsertionSort(array);
                            break;
                        case 5:
                            timer.startTimer();
                            mergeSort.recursiveMergeSort(array, n);
                            break;
                        case 6:
                            timer.startTimer();
                            mergeSort.iterativeMergeSort(array, n);
                            break;
                        case 7:
                            System.out.println("---------------------------------");
                            System.out.println("Which number do you wish to search?");
                            int search = scanner.nextInt();
                            mergeSort.recursiveMergeSort(array, n);
                            timer.startTimer();
                            boolean found = binarySearch.binarySearch(search, array);
                            System.out.println(found);


                            break;
                        default:
                    }
                    timer.stopTimer();
                    System.out.println("time taken to sort in seconds: " + timer.toString());
                    saveArray(array);
                    System.out.println("Sorted Array saved to src/SortedNumber.txt");
                } catch (StackOverflowError error) {
                    System.err.println("An error has happened:");
                    System.err.println(error);
                }


            } else {
                running = false;
            }
            System.out.println("Press enter to return back to menu");
            scanner.nextLine();
            scanner.nextLine();


        }
    }

    private static int[] fillArray(int[] array) {
        try {
            Scanner scanner = new Scanner(new File("src/RandomNumbers.txt"));
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return array;
    }


    private static void saveArray(int array[]) {
        try {
            PrintWriter pr = new PrintWriter("src/SortedNumber.txt");

            for (int anArray : array) {
                pr.println(anArray);
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
}

