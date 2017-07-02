package com.martianov.shapes.triangle;

import com.martianov.shapes.exceptions.IllegalSideLength;
import com.martianov.shapes.exceptions.IllegalSidesCount;

import java.util.Arrays;

/**
 * Triangles application main class.
 *
 * @author Andrey Martyanov <martianovas@gmail.com>
 */
public class Main {
    private static final String HELP = "Usage: side1 side2 side3\n" +
            "where side1, side2, side3 - length of triangle's sides (decimal numbers).\n" +
            "Example: 0.5 0.4 0.5";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(HELP);
            return;
        }

        try {

            Double[] sides = Arrays.stream(args).map(Double::parseDouble).toArray(Double[]::new);
            Triangle<Double> triangle = Triangle.withSides(sides);
            System.out.println("Triangle is " + TriangleType.typeOf(triangle));

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input: " +  nfe.getMessage());
            System.out.println("\n" + HELP);

            System.exit(1);
        } catch (IllegalSidesCount isce) {
            System.out.println("Invalid number of arguments.");
            System.out.println("\n" + HELP);

            System.exit(1);
        } catch (IllegalSideLength isle) {
            System.out.println("Invalid side length: " + isle.getMessage());

            System.exit(1);
        }
    }
}
