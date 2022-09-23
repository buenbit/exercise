package com.buenbit.exercise;

public class IsInsideFigureExercise {

  private short[][] matrix;

  public IsInsideFigureExercise(short[][] matrix) {
    this.matrix = matrix;
  }

  /**
   * Given a binary matrix (A matrix full of 0s and 1s) of NxM, write a method isInside that receives a coordinate row,
   * column, and determines if such point is inside a figure drawn with 1s, and filled with 0s.
   *
   * Examples:
   *   a)
   *      "00000000000000000000"
   *      "01111111111111111110"
   *      "01000000000000000010"
   *      "0100000000X000000010"
   *      "01000000000000000010"
   *      "01111111111111111110"
   *      "00000000000000000000"
   *
   *   If the coordinate is given by the position of the X in the example (row = 3, column = 10), then the method should
   *   return "true", since the coordinate is surrounded by a closed figure made by 1s.
   *   b)
   *      "00000000000000000000"
   *      "01111111111111111110"
   *      "01000000000000000010"
   *      "01000000000000000010"
   *      "01000000000000000010"
   *      "01111111111111111110"
   *      "0000000000X000000000"
   *
   *   In this case, X is placed in row = 6, column = 10, and it's outside the figure made by 1s, so the method should
   *   return false.
   * @param row The row coordinate in the binary matrix
   * @param column The column coordinate in the binary matrix
   * @return a boolean value indicating if the coordinate is surrounded by the figure made of 1s
   */
  public boolean isInside(int row, int column) {
    // Implement functionality here
    return true;
  }
}