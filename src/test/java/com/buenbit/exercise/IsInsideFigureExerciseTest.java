package com.buenbit.exercise;

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

}
