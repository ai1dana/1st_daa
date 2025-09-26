package org.edu.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.edu.metrics.Metrics;

public class MergeSortTest {
    @Test
    void testMergeSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};  // Исходный массив
        int[] expected = {1, 2, 5, 5, 6, 9};  // Ожидаемый отсортированный массив

        // Создаём буферный массив
        int[] buffer = new int[arr.length];

        // Вызываем метод sort с добавленными аргументами: buffer, left, right
        MergeSort.sort(arr, buffer, 0, arr.length - 1, new Metrics());

        // Проверяем, что результат сортировки соответствует ожиданиям
        assertArrayEquals(expected, arr, "MergeSort должен отсортировать массив");
    }
}
