package com.buenbit.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.buenbit.exercise.SampleMatrix.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class IsInsideFigureExerciseTest {

  /**
   * rules for testing
   * - orthogonal lines, they form 90 deg angles
   * - all the figures are closed
   * - only one figure max inside the matrix
   * Assumption
   *  - if the point is on a line, I consider it outside of the figure
   * @return
   */

  @Test
  public void isInsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrix9x10());
    assertTrue(isInsideFigureExercise.isInside(2, 3));
    assertTrue(isInsideFigureExercise.isInside(2, 7));

    isInsideFigureExercise = new IsInsideFigureExercise(matrix5x5());
    assertTrue(isInsideFigureExercise.isInside(1, 1));
    assertTrue(isInsideFigureExercise.isInside(2, 1));

    isInsideFigureExercise = new IsInsideFigureExercise(matrix9x10Cross());
    assertTrue(isInsideFigureExercise.isInside(5, 4));

  }

  @Test
  public void isOutsideFigureTest() {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrix9x10());

    assertFalse(isInsideFigureExercise.isInside(0, 0));
    assertFalse(isInsideFigureExercise.isInside(4, 4));

    isInsideFigureExercise = new IsInsideFigureExercise(matrix5x5());

    assertFalse(isInsideFigureExercise.isInside(3, 3));
    assertFalse(isInsideFigureExercise.isInside(5, 4));

    isInsideFigureExercise = new IsInsideFigureExercise(matrix9x10Cross());

    assertFalse(isInsideFigureExercise.isInside(0, 7));
    assertFalse(isInsideFigureExercise.isInside(9, 9));
  }

  // Add more tests if you feel like it :)


}
