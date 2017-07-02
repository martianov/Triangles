package com.martianov.shapesdetect.triangles;

/**
 * Attribute of shapes.
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public interface IShapeAttribute<T extends Shape<?>> {
    /**
     * Checks if attribute is applicable for given shape.
     *
     * @return true if attribute is applicable for given shape; false - otherwise.
     * */
    boolean isApplicableFor(Shape<?> shape);


    /**
     * Checks if given shape has attribute.
     *
     * @return true if given shape has attribute; false - otherwise.
     * */
    boolean check(T shape);
}
