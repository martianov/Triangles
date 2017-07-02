package com.martianov.shapes;

import com.martianov.shapes.exceptions.IllegalSideLength;
import com.martianov.shapes.exceptions.IllegalSidesCount;
import com.martianov.shapes.exceptions.ShapeAttributeNotApplicable;

/**
 * Shape with specified side lengths.
 *
 * @param <T> type of side length. Must extend java.lang.Number.
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class Shape<T extends Number> {
    private final Object[] sides;

    /**
     * Creates shape with specified sides' lengths.
     *
     * @param sides side lengths
     *
     * @throws IllegalSidesCount no sides specified.
     * @throws IllegalSideLength side less than 0.
     */
    protected Shape(T... sides) {
        if (sides.length == 0) {
            throw new IllegalSidesCount("At least one side length expected.");
        }

        this.sides = new Object[sides.length];

        for (int i = 0; i < sides.length; i++) {
            if (sides[i].doubleValue() < 0.0) {
                throw new IllegalSideLength("Side less than 0 (" + i + "-th): " + sides[i]);
            }
            this.sides[i] = sides[i];
        }
    }

    /**
     * Creates shape with specified sides' lengths.
     *
     * @param sides side lengths
     * @return Shape.
     * @throws IllegalSidesCount no sides specified.
     * @throws IllegalSideLength side less than 0.
     */
    public static <T extends Number> Shape<T> withSides(T... sides) throws IllegalSidesCount, IllegalSideLength {
        return new Shape<T>(sides);
    }

    /**
     * Returns count of shape's sides.
     *
     * @return count of shape's sides.
     * */
    public int getSidesCount() {
        return sides.length;
    }

    /**
     * Return length of i-th side.
     *
     * @param i side's index.
     * @return length of i-th side.
     * @throws IndexOutOfBoundsException invalid index.
     */
    @SuppressWarnings("unchecked")
    public T getSide(int i) {
        return (T) sides[i];
    }

    /**
     * Check if shape has specified attribute.
     *
     * @return true if shape has specified attribute; false - otherwise.
     * @throws ShapeAttributeNotApplicable specified attribute isn't applicable for shape.
     * */
    public boolean is(IShapeAttribute attribute) {
        if (!attribute.isApplicableFor(this)) {
            throw new ShapeAttributeNotApplicable("Attribute " + attribute.getClass().getSimpleName()
                    + " isn't applicable for " + this.getClass());
        }
        return attribute.check(this);
    }
}
