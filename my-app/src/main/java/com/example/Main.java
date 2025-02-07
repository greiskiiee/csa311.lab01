package com.example;

import java.util.Arrays;

/**
 * Sort array.
 */
public class Main {

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }

        return arr;
    }

    /**
     * main function .
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] array = {2, 5, 3, 1, 6};

        System.out.println("Array sorted: " + Arrays.toString(sort(array)));
    }
}
