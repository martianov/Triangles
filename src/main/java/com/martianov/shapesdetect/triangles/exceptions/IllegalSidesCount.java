package com.martianov.shapesdetect.triangles.exceptions;

/**
 * Thrown if try to create shape with invalid count of sides.
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class IllegalSidesCount extends IllegalArgumentException {
    public IllegalSidesCount() {
        super();
    }

    public IllegalSidesCount(String s) {
        super(s);
    }

    public IllegalSidesCount(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalSidesCount(Throwable cause) {
        super(cause);
    }
}
