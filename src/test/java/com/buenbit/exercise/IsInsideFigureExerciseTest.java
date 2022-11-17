package com.buenbit.exercise;

import org.junit.Assert;
import org.junit.Test;

import static com.buenbit.exercise.SampleMatrix.*;

public class IsInsideFigureExerciseTest {

  @Test
  public void isInsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrix9x10());
    Assert.assertTrue(isInsideFigureExercise.isInside(2, 3));
    Assert.assertTrue(isInsideFigureExercise.isInside(2, 7));
    isInsideFigureExercise = new IsInsideFigureExercise(matrix5x5());
    Assert.assertTrue(isInsideFigureExercise.isInside(1, 1));
    Assert.assertTrue(isInsideFigureExercise.isInside(2, 1));

    isInsideFigureExercise = new IsInsideFigureExercise(matrix9x10Cross());
    Assert.assertTrue(isInsideFigureExercise.isInside(5, 4));

  }

  @Test
  public void isOutsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrix9x10());

    Assert.assertFalse(isInsideFigureExercise.isInside(0, 0));
    Assert.assertFalse(isInsideFigureExercise.isInside(4, 4));
  }

  // Add more tests if you feel like it :)

  /**
   * rules for testing
   * - orthogonal lines, they form 90 deg angles
   * - all the figures are closed
   * - only one figure max inside the matrix
   * @return
   */

}
