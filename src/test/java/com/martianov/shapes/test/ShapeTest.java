package com.martianov.shapes.test;

import com.martianov.shapes.IShapeAttribute;
import com.martianov.shapes.Shape;
import com.martianov.shapes.exceptions.IllegalSideLength;
import com.martianov.shapes.exceptions.IllegalSidesCount;
import com.martianov.shapes.exceptions.ShapeAttributeNotApplicable;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests on Shape class:
 * - sides validation on creation;
 * - verification of attributes' applicability;
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class ShapeTest {
    /**
     * Test on valid shape creation.
     * */
    @Test
    public void testShape() {
        Shape<Long> shape = Shape.withSides(1L, 2L, 3L);

        Assert.assertEquals(new Long(1L), shape.getSide(0));
        Assert.assertEquals(new Long(2L), shape.getSide(1));
        Assert.assertEquals(new Long(3L), shape.getSide(2));
        Assert.assertEquals(3, shape.getSidesCount());
    }

    /**
     * Can't create shape without sides.
     * */
    @Test(expected = IllegalSidesCount.class)
    public void testFailNoSides() {
        Shape<Long> shape = Shape.withSides();
    }


    /**
     * Can't create shape with negative side length.
     * */
    @Test(expected = IllegalSideLength.class)
    public void testFailNegativeSide() {
        Shape<Long> shape = Shape.withSides(1L, 2L, -3L);
    }

    /**
     * Can't test inappropriate attribute on shape.
     * */
    @Test(expected = ShapeAttributeNotApplicable.class)
    public void testApplicableAttributes() {
        Shape<Long> shape = Shape.withSides(1L, 2L, 3L);

        IShapeAttribute<Shape<Long>> good = new IShapeAttribute<Shape<Long>>() {
            @Override
            public boolean isApplicableFor(Shape<?> shape) {
                return true;
            }

            @Override
            public boolean check(Shape<Long> shape) {
                return true;
            }
        };

        IShapeAttribute<Shape<Long>> bad = new IShapeAttribute<Shape<Long>>() {
            @Override
            public boolean isApplicableFor(Shape<?> shape) {
                return false;
            }

            @Override
            public boolean check(Shape<Long> shape) {
                return false;
            }
        };

        Assert.assertTrue(shape.is(good));

        // must fail with ShapeAttributeNotApplicable exception
        Assert.assertTrue(shape.is(bad));
    }
}
