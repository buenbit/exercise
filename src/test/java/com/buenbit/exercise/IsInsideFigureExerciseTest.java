package com.buenbit.exercise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

  // Add more tests if you feel like it :)

  @ParameterizedTest
  @MethodSource("rowAndColumnInsideMatrixWithMultipleCanvases")
  public void itShouldBeInsideOneFigure(int row, int column) {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrixWithMultipleCanvases());

    Assert.assertTrue(isInsideFigureExercise.isInside(row, column));
  }

  @ParameterizedTest
  @MethodSource("rowAndColumnOutsideMatrixWithMultipleCanvases")
  public void itShouldBeOutsideOneFigure(int row, int column) {
    IsInsideFigureExercise isInsideFigureExercise = new IsInsideFigureExercise(matrixWithMultipleCanvases());

    Assert.assertFalse(isInsideFigureExercise.isInside(row, column));
  }

  public static Stream<Arguments> rowAndColumnInsideMatrixWithMultipleCanvases() {
    return Stream.of(
            Arguments.of(2, 2),
            Arguments.of(2, 6),
            Arguments.of(5, 1)
    );
  }

  public static Stream<Arguments> rowAndColumnOutsideMatrixWithMultipleCanvases() {
    return Stream.of(
            Arguments.of(6, 8)
    );
  }

  private short[][] initializeExampleMatrix() {
    return new short[][]{
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };
  }

  private static short[][] matrixWithMultipleCanvases() {
    return new short[][]{
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 1, 1, 1, 1, 1, 1, 0, 0 }
    };
  }

}
