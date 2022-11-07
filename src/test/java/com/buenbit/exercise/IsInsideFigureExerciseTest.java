package com.buenbit.exercise;

import org.junit.Assert;
import org.junit.Test;

public class IsInsideFigureExerciseTest {

    @Test
    public void isInsideFigureTest() {
        IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(initializeExampleMatrix());

        // Coordinate [3,3] is on the limit of the figure
        Assert.assertTrue(isInsideFigureExercise.isInside(3, 3));
        // Coordinate [2,5] is inside the figure
        Assert.assertTrue(isInsideFigureExercise.isInside(2, 5));
    }

    @Test
    public void isOutsideFigureTest() {
        IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(initializeExampleMatrix());

        Assert.assertFalse(isInsideFigureExercise.isInside(0, 0));
    }

    // Add more tests if you feel like it :)

    private short[][] initializeExampleMatrix() {
        return new short[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }
}
