package com.buenbit.exercise;

import org.junit.Assert;
import org.junit.Test;

public class IsInsideFigureExerciseTest {

  @Test
  public void isInsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(initializeExampleMatrix());

    Assert.assertTrue(isInsideFigureExercise.isInside(3, 3));
  }

  @Test
  public void isOutsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(initializeExampleMatrix());

    Assert.assertFalse(isInsideFigureExercise.isInside(0, 0));
  }

  @Test
  public void isInvalidCoordinateTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(initializeExampleMatrix());
    Assert.assertFalse(isInsideFigureExercise.isInside(1000, 2000));
  }

  @Test
  public void shouldBeOutsideAlwaysIfMatrixDoesNotHaveAFigure() {
    short[][] matrix = initializeExampleMatrixWithoutFigure();
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrix);

    Assert.assertFalse(isInsideFigureExercise.isInside(5, 2));

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[0].length; column++) {
        Assert.assertFalse(isInsideFigureExercise.isInside(row, column));
      }
    }
  }

  // Add more tests if you feel like it :)

  private short[][] initializeExampleMatrix() {
    return new short[][] {
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
        { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
        { 0, 1, 0, 1, 1, 1, 1, 0, 1, 0 },
        { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
        { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 1, 1, 1, 0, 1, 0 },
        { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
        { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };
  }

  private short[][] initializeExampleMatrixWithoutFigure() {
    return new short[][] {
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };
  }
}
