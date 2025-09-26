package org.edu.metrics;

public class Metrics {
    private long comparisons;
    private long time;

    public Metrics() {
        this.comparisons = 0;
        this.time = 0;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void print() {
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Time (ns): " + time);
    }
}

