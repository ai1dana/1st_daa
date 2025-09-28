package org.edu.cli;

import org.edu.sorting.MergeSort;
import org.edu.sorting.QuickSort;
import org.edu.selection.DeterministicSelect;
import org.edu.geometry.ClosestPair;
import org.edu.metrics.Metrics;

import java.io.FileWriter;ы
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            // Парсинг аргументов
            String algorithm = args.length > 0 ? args[0].toLowerCase() : "mergesort";
            int n = args.length > 1 ? Integer.parseInt(args[1]) : 10;

            Metrics metrics = new Metrics();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = (int)(Math.random() * 100);
            int[] buffer = new int[n];

            // Запуск алгоритма
            switch (algorithm) {
                case "mergesort":
                    MergeSort.sort(arr, buffer, 0, n - 1, metrics);
                    break;
                case "quicksort":
                    QuickSort.sort(arr, 0, n - 1, metrics);
                    break;
                case "select":
                    int k = n / 2;
                    DeterministicSelect.select(arr, 0, n - 1, k, metrics);
                    break;
                case "closest":
                    ClosestPair.Point[] points = new ClosestPair.Point[n];
                    for (int i = 0; i < n; i++) {
                        points[i] = new ClosestPair.Point(Math.random() * 100, Math.random() * 100);
                    }
                    ClosestPair.closestPair(points);
                    break;
                default:
                    System.out.println("Unknown algorithm: " + algorithm);
                    return;
            }

            // Запись результатов в CSV
            try (FileWriter fw = new FileWriter("results.csv", true)) {
                fw.write(algorithm + "," + n + "," + metrics.getTime() + "," + metrics.getComparisons() + "\n");
            }

            System.out.println("Algorithm: " + algorithm + " completed for n=" + n);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


