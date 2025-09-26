package org.edu.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.edu.metrics.Metrics;

public class QuickSortTest {
    @Test
    void testQuickSort() {
        int[] arr = {3, 7, 2, 8, 1};
        int[] expected = {1, 2, 3, 7, 8};

        // Создаём буферный массив
        int[] buffer = new int[arr.length];

        // Вызываем метод QuickSort с буфером и индексами
        QuickSort.sort(arr, 0, arr.length - 1, new Metrics());

        // Проверяем, что результат сортировки соответствует ожиданиям
        assertArrayEquals(expected, arr, "QuickSort должен отсортировать массив");
    }
}

