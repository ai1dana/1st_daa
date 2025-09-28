package org.edu.bench;

import org.edu.sorting.MergeSort;
import org.edu.sorting.QuickSort;
import org.edu.selection.DeterministicSelect;
import org.edu.metrics.Metrics;

public class Bench {
    public static void main(String[] args) {
        int n = 1000;
        int[] arr;
        int[] buffer;
        Metrics metrics;

        arr = new int[n];
        buffer = new int[n];
        metrics = new Metrics("bench_merge.csv");  // ✅ передаем имя файла
        for (int i = 0; i < n; i++) arr[i] = (int)(Math.random() * 1000);
        long start = System.nanoTime();
        MergeSort.sort(arr, buffer, 0, n - 1, metrics);
        long end = System.nanoTime();
        System.out.println("MergeSort n=" + n + " time=" + (end - start) + " ns");

        arr = new int[n];
        metrics = new Metrics("bench_quick.csv");  // ✅ передаем имя файла
        for (int i = 0; i < n; i++) arr[i] = (int)(Math.random() * 1000);
        start = System.nanoTime();
        QuickSort.sort(arr, 0, n - 1, metrics);
        end = System.nanoTime();
        System.out.println("QuickSort n=" + n + " time=" + (end - start) + " ns");

        arr = new int[n];
        metrics = new Metrics("bench_select.csv");
        for (int i = 0; i < n; i++) arr[i] = (int)(Math.random() * 1000);
        start = System.nanoTime();
        DeterministicSelect.select(arr, 0, n - 1, n / 2, metrics);
        end = System.nanoTime();
        System.out.println("DeterministicSelect n=" + n + " time=" + (end - start) + " ns");
    }
}


