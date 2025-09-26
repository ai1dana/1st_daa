package org.edu.metrics;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private FileWriter writer;

    public CsvWriter(String filename) throws IOException {
        writer = new FileWriter(filename);
        // заголовки для CSV
        writer.write("algorithm,n,time_ns,comparisons,depth\n");
    }

    public void writeRow(String algorithm, int n, long time, long comparisons, int depth) throws IOException {
        writer.write(algorithm + "," + n + "," + time + "," + comparisons + "," + depth + "\n");
    }

    public void close() throws IOException {
        writer.close();
    }
}

