package com.martianov.shapes.test;

import com.martianov.shapes.triangle.Triangle;
import com.martianov.shapes.exceptions.IllegalSideLength;
import com.martianov.shapes.exceptions.IllegalSidesCount;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests on Triangle class:
 * - sides verification on triangle creation;
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class TriangleTest {
    /**
     * Test on valid triangle creation.
     * */
    @Test
    public void testTriangle() {
        Triangle<Long> triangle = Triangle.withSides(1L, 3L, 3L);

        Assert.assertEquals(triangle.getSide(0), new Long(1L));
        Assert.assertEquals(triangle.getSide(1), new Long(3L));
        Assert.assertEquals(triangle.getSide(2), new Long(3L));
    }

    /**
     * Can't create triangle using more than 3 sides.
     * */
    @Test(expected = IllegalSidesCount.class)
    public void testMoreThanThreeSides() {
       Triangle.withSides(1L, 3L, 3L, 4L);
    }

    /**
     * Can't create triangle using less than 3 sides.
     * */
    @Test(expected = IllegalSidesCount.class)
    public void testLessThanThreeSides() {
        Triangle.withSides(1L, 3L);
    }

    /**
     * Can't create triangle if triangle inequality violated: x > y + z
     * */
    @Test(expected = IllegalSideLength.class)
    public void testTriangleInequalityViolationX() {
        Triangle.withSides(100L, 1L, 1L);
    }

    /**
     * Can't create triangle if triangle inequality violated: y > x + z
     * */
    @Test(expected = IllegalSideLength.class)
    public void testTriangleInequalityViolationY() {
        Triangle.withSides(1L, 100L, 1L);
    }

    /**
     * Can't create triangle if triangle inequality violated: z > x + y
     * */
    @Test(expected = IllegalSideLength.class)
    public void testTriangleInequalityViolationZ() {
        Triangle.withSides(1L, 1L, 100L);
    }
}
