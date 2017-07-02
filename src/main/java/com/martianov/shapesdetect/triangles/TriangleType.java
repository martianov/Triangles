package com.martianov.shapesdetect.triangles;

/**
 * Type of triangle: scalene, isosceles or equilateral.
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public enum TriangleType implements IShapeAttribute<Triangle<?>> {
    /**
     * All sides have different length.
     * */
    SCALENE,

    /**
     * Two of three sides are equal.
     * */
    ISOSCELES,

    /**
     * All sides are equal.
     * */
    EQUILATERAL;

    /**
     * Returns if triangle type is applicable for given shape class.
     * Triangle type is applicable for com.martianov.shapesdetect.triangles.Triangle and its subtypes.
     *
     * @param clazz type of shape.
     * @return true if given class is com.martianov.shapesdetect.triangles.Triangle or its subtype.
     * */
    public static <T extends Shape<?>> boolean isApplicableFor(Class<T> clazz) {
        return Triangle.class.isAssignableFrom(clazz);
    }

    /**
     * Identify type of triangle.
     *
     * @param triangle triangle.
     * @return triangle type.
     * */
    public static <T extends Number> TriangleType typeOf(Triangle<T> triangle) {
        int equalSidesCount = 0;

        for (int i = 0; i < 3; i++) {
            if (triangle.getSide(i).equals(triangle.getSide((i + 1) % 3))) {
                equalSidesCount++;
            }
        }

        switch (equalSidesCount) {
            case 0:
                return SCALENE;
            case 1:
                return ISOSCELES;
            case 3:
                return EQUILATERAL;
            default:
                throw new AssertionError("Never happening");
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean isApplicableFor(Shape<?> shape) {
        return TriangleType.isApplicableFor(shape.getClass());
    }

    /**
     * {@inheritDoc}
     */
    public boolean check(Triangle<?> shape) {
        return this.equals(TriangleType.typeOf(shape));
    }
}
