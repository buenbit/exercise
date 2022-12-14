package com.buenbit.exercise;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.Test;

public class IsInsideFigureExerciseTest {

  @Test
  public void isInsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(initializeExampleMatrix());

    Assert.assertTrue(isInsideFigureExercise.isInside(3, 3));
    Assert.assertTrue(isInsideFigureExercise.isInside(2, 5));;
  }

  @Test
  public void isOutsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(initializeExampleMatrix());

    Assert.assertFalse(isInsideFigureExercise.isInside(0, 0));
    Assert.assertFalse(isInsideFigureExercise.isInside(5, 7));
    Assert.assertFalse(isInsideFigureExercise.isInside(4, 5));
  }

  @Test
  public void isInvalidCoordinateTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(initializeExampleMatrix());
    Assert.assertFalse(isInsideFigureExercise.isInside(1000, 2000));
  }

  @Test
  public void shouldThrowExceptionIfMatrixDoesNotHaveAFigure() {
    short[][] matrix = initializeExampleMatrixWithoutFigure();
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrix);

    assertThrows(IllegalArgumentException.class, ()
        -> isInsideFigureExercise.isInside(5, 2)
    );
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
