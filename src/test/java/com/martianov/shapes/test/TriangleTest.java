package com.martianov.shapes.test;

import com.martianov.shapes.triangle.Triangle;
import com.martianov.shapes.exceptions.IllegalSideLength;
import com.martianov.shapes.exceptions.IllegalSidesCount;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class TriangleTest {
    @Test
    public void testTriangle() {
        Triangle<Long> triangle = Triangle.withSides(1L, 3L, 3L);

        Assert.assertEquals(triangle.getSide(0), new Long(1L));
        Assert.assertEquals(triangle.getSide(1), new Long(3L));
        Assert.assertEquals(triangle.getSide(2), new Long(3L));
    }

    @Test(expected = IllegalSidesCount.class)
    public void testMoreThanThreeSides() {
       Triangle.withSides(1L, 3L, 3L, 4L);
    }

    @Test(expected = IllegalSideLength.class)
    public void testTriangleInequalityViolationX() {
        Triangle.withSides(100L, 1L, 1L);
    }

    @Test(expected = IllegalSideLength.class)
    public void testTriangleInequalityViolationY() {
        Triangle.withSides(1L, 100L, 1L);
    }

    @Test(expected = IllegalSideLength.class)
    public void testTriangleInequalityViolationZ() {
        Triangle.withSides(1L, 1L, 100L);
    }
}
