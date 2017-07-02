package com.martianov.shapes.test;

import com.martianov.shapes.triangle.Triangle;
import com.martianov.shapes.triangle.TriangleType;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class TriangleTypeTest {
    @Test
    public void testScaleneTriangle() {
        Triangle<Long> triangle = Triangle.withSides(1L, 2L, 3L);

        Assert.assertEquals(TriangleType.SCALENE, TriangleType.typeOf(triangle));

        Assert.assertTrue(triangle.is(TriangleType.SCALENE));
        Assert.assertFalse(triangle.is(TriangleType.ISOSCELES));
        Assert.assertFalse(triangle.is(TriangleType.EQUILATERAL));
    }

    @Test
    public void testIsoscelesTriangle() {
        Triangle<Long> triangle = Triangle.withSides(1L, 3L, 3L);

        Assert.assertEquals(TriangleType.ISOSCELES, TriangleType.typeOf(triangle));

        Assert.assertFalse(triangle.is(TriangleType.SCALENE));
        Assert.assertTrue(triangle.is(TriangleType.ISOSCELES));
        Assert.assertFalse(triangle.is(TriangleType.EQUILATERAL));
    }


    @Test
    public void testEquilateralTriangle() {
        Triangle<Long> triangle = Triangle.withSides(3L, 3L, 3L);

        Assert.assertEquals(TriangleType.EQUILATERAL, TriangleType.typeOf(triangle));

        Assert.assertFalse(triangle.is(TriangleType.SCALENE));
        Assert.assertFalse(triangle.is(TriangleType.ISOSCELES));
        Assert.assertTrue(triangle.is(TriangleType.EQUILATERAL));
    }
}
