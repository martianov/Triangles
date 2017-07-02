package com.martianov.shapesdetect.triangles.exceptions;

/**
 * Thrown if try to apply attribute to inappropriate shape type.
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class ShapeAttributeNotApplicable extends IllegalArgumentException {
    public ShapeAttributeNotApplicable() {
        super();
    }

    public ShapeAttributeNotApplicable(String s) {
        super(s);
    }

    public ShapeAttributeNotApplicable(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeAttributeNotApplicable(Throwable cause) {
        super(cause);
    }
}
