package org.edu.selection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.edu.metrics.Metrics;

public class DeterministicSelectTest {
    @Test
    void testSelect() {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        int k = 4; // мы ищем 4-й по порядку элемент

        // Сортируем массив для поиска k-го элемента
        java.util.Arrays.sort(arr);  // отсортированный массив: {1, 2, 3, 4, 5, 6, 7, 8}

        // Теперь ожидаем, что 4-й элемент будет равен 4
        int result = DeterministicSelect.select(arr, 0, arr.length - 1, k, new Metrics());

        // Проверяем, что найденный элемент действительно 4-й
        assertEquals(4, result, "DeterministicSelect должен вернуть k-й элемент");
    }
}
