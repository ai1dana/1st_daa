package org.edu.metrics;

public class Metrics {
    private String name;
    private long time;
    private long comparisons;
    private int depth;

    public Metrics(String name) {
        this.name = name;
        this.comparisons = 0;
        this.depth = 0;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void print() {
        System.out.println("[" + name + "] Time: " + time +
                " ns, Comparisons: " + comparisons +
                ", Depth: " + depth);
    }

    public String getName() { return name; }
    public long getTime() { return time; }
    public long getComparisons() { return comparisons; }
    public int getDepth() { return depth; }
}
