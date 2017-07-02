package com.martianov.shapes.triangle;

import com.martianov.shapes.Shape;
import com.martianov.shapes.exceptions.IllegalSideLength;
import com.martianov.shapes.exceptions.IllegalSidesCount;

/**
 * Triangle with specified sides' lengths. Sides' length satisfy the triangle inequality.
 * Triangle inequality: the sum of the lengths of any two sides must be greater than or equal
 * to the length of the remaining side.
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class Triangle<T extends Number> extends Shape<T> {
    private Triangle(T... sides) {
        super(sides);
    }

    /**
     * Creates triangle with specified sides.
     *
     * @param sides sides' length.
     * @return triangle with specified sides.
     * @throws IllegalSidesCount count of specified sides is other than 3.
     * @throws IllegalSideLength invalid sides: side less than 0 or triangle inequality is violated.
     * */
    public static <T extends Number> Triangle<T> withSides(T... sides) throws IllegalSidesCount, IllegalSideLength {
        if (sides.length != 3) {
            throw new IllegalSidesCount("Unexpected count of sides for triangle: " + sides.length);
        }

        // Check triangle inequality
        for (int i = 0; i < 3; i++) {
            int xIdx = i % 3;
            int yIdx = (i + 1) % 3;
            int zIdx = (i + 2) % 3;

            double x = sides[xIdx].doubleValue();
            double y = sides[yIdx].doubleValue();
            double z = sides[zIdx].doubleValue();

            if (x + y < z) {
                throw new IllegalSideLength("Triangle inequality is violated: "
                            + sides[xIdx] + " + " + sides[yIdx] + " < " + sides[zIdx]);
            }
        }

        return new Triangle<T>(sides);
    }
}
