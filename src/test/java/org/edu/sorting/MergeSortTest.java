package org.edu.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.edu.metrics.Metrics;

public class MergeSortTest {

    @Test
    void testMergeSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};

        int[] buffer = new int[arr.length];
        MergeSort.sort(arr, buffer, 0, arr.length - 1, new Metrics());

        assertArrayEquals(expected, arr, "MergeSort должен отсортировать массив");
    }
}

