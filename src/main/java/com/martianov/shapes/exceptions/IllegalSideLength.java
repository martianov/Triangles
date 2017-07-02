package com.martianov.shapes.exceptions;

/**
 * Thrown if try to create shape with invalid side length.
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class IllegalSideLength extends IllegalArgumentException {
    public IllegalSideLength() {
        super();
    }

    public IllegalSideLength(String s) {
        super(s);
    }

    public IllegalSideLength(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalSideLength(Throwable cause) {
        super(cause);
    }
}
