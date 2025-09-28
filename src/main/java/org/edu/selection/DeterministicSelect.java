package org.edu.selection;

import org.edu.metrics.Metrics;
import java.util.Arrays;

public class DeterministicSelect {
    public static int select(int[] arr, int left, int right, int k, Metrics metrics) {
        if (left == right) return arr[left];

        int pivot = medianOfMedians(arr, left, right);
        int pivotIndex = partition(arr, left, right, pivot, metrics);

        int len = pivotIndex - left + 1;
        if (k == len) return arr[pivotIndex];
        else if (k < len) return select(arr, left, pivotIndex - 1, k, metrics);
        else return select(arr, pivotIndex + 1, right, k - len, metrics);
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n < 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[left + n / 2];
        }
        int[] medians = new int[(n + 4) / 5];
        for (int i = 0; i < medians.length; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(arr, subLeft, subRight + 1);
            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }
        return medianOfMedians(medians, 0, medians.length - 1);
    }

    private static int partition(int[] arr, int left, int right, int pivot, Metrics metrics) {
        while (left <= right) {
            while (arr[left] < pivot) { left++; metrics.incrementComparisons(); }
            while (arr[right] > pivot) { right--; metrics.incrementComparisons(); }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return left - 1;
    }
}

