package org.edu.geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {

    @Test
    void testTwoPoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(5.0, result, 1e-6);
    }

    @Test
    void testThreePoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(5, 5)
        };

        double result = ClosestPair.closestPair(points);
        assertEquals(Math.sqrt(2), result, 1e-6);
    }

    @Test
    void testRandomPoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(Math.sqrt(2), result, 1e-6);
    }

    @Test
    void testIdenticalPoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(2, 2)
        };
        double result = ClosestPair.closestPair(points);
        assertEquals(0.0, result, 1e-6);
    }
}

