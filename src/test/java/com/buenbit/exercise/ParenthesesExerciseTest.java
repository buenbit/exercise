package com.buenbit.exercise;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesesExerciseTest {

  @Test
  public void isValidForValidString() {
    Assert.assertTrue(ParenthesesExercise.isValid("{[()]}"));
    Assert.assertTrue(ParenthesesExercise.isValid("((()))"));
  }

  @Test
  public void isNotValidForInvalidString() {
    Assert.assertFalse(ParenthesesExercise.isValid("}()"));
    Assert.assertFalse(ParenthesesExercise.isValid("{(}"));
  }

  // Add more tests if you feel like it :)
}
