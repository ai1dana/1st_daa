package org.edu.geometry;

import java.util.*;

public class ClosestPair {
    public static class Point {
        public double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closestPair(Point[] points) {
        Arrays.sort(points, Comparator.comparingDouble(p -> p.x));
        return closest(points, 0, points.length - 1);
    }

    private static double closest(Point[] points, int left, int right) {
        if (right - left <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = left; i <= right; i++)
                for (int j = i + 1; j <= right; j++)
                    min = Math.min(min, dist(points[i], points[j]));
            return min;
        }
        int mid = (left + right) / 2;
        double d1 = closest(points, left, mid);
        double d2 = closest(points, mid + 1, right);
        double d = Math.min(d1, d2);

        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++)
            if (Math.abs(points[i].x - points[mid].x) < d)
                strip.add(points[i]);
        strip.sort(Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < strip.size(); i++)
            for (int j = i + 1; j < strip.size() && strip.get(j).y - strip.get(i).y < d; j++)
                d = Math.min(d, dist(strip.get(i), strip.get(j)));

        return d;
    }

    private static double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}

