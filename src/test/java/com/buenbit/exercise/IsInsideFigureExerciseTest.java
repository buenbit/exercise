package com.buenbit.exercise;

import org.junit.Assert;
import org.junit.Test;

public class IsInsideFigureExerciseTest {

  @Test
  public void isInsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrix9x10());
    Assert.assertTrue(isInsideFigureExercise.isInside(2, 3));
    isInsideFigureExercise = new IsInsideFigureExercise(matrix5x5());
    Assert.assertTrue(isInsideFigureExercise.isInside(1, 2));
  }

  //@Test
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
  private short[][] matrix9x10() {
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
  private short[][] matrix5x5() {
    return new short[][] {
            { 0, 0, 0, 0, 0, 0},
            { 0, 1, 1, 1, 0, 0},
            { 0, 1, 0, 1, 0, 0},
            { 0, 1, 0, 1, 0, 0},
            { 0, 1, 1, 1, 0, 0},
            { 0, 0, 0, 0, 0, 0},

    };
  }
}
