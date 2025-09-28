package org.edu.cli;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void testMainGeneratesCSV() throws IOException {
        // Удаляем файл CSV если он существует
        File file = new File("results.csv");
        if (file.exists()) file.delete();

        // Запускаем Main с аргументами для MergeSort
        Main.main(new String[]{"mergesort", "10"});

        // Проверяем, что файл создан
        assertTrue(file.exists(), "CSV файл должен быть создан");

        // Проверяем, что в файле есть хотя бы одна строка
        List<String> lines = Files.readAllLines(file.toPath());
        assertTrue(lines.size() > 0, "CSV должен содержать хотя бы одну строку");
        assertTrue(lines.get(0).startsWith("mergesort"), "Первая строка должна быть для MergeSort");
    }
}

