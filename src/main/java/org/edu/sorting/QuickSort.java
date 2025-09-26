package org.edu.sorting;

import org.edu.metrics.Metrics;
import java.util.Random;

public class QuickSort {
    private static final Random rand = new Random();

    public static void sort(int[] arr, int left, int right, Metrics metrics) {
        while (left < right) {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivot = arr[pivotIndex];
            int i = left, j = right;
            while (i <= j) {
                while (arr[i] < pivot) { i++; metrics.incrementComparisons(); }
                while (arr[j] > pivot) { j--; metrics.incrementComparisons(); }
                if (i <= j) {
                    swap(arr, i, j);
                    i++; j--;
                }
            }
            if (j - left < right - i) {
                if (left < j) sort(arr, left, j, metrics);
                left = i;
            } else {
                if (i < right) sort(arr, i, right, metrics);
                right = j;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}

