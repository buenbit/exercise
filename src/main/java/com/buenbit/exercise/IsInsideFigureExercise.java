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
   *      "0 0 0 0 0 0 0 0 0 0 0"
   *      "0 1 1 1 1 1 1 1 1 0 0"
   *      "0 1 0 0 0 X 0 0 1 0 0"
   *      "0 1 0 1 1 1 1 0 1 0 0"
   *      "0 1 0 1 0 0 1 1 1 0 0"
   *      "0 1 0 1 0 0 0 0 0 0 0"
   *      "0 1 0 1 0 0 1 1 1 0 0"
   *      "0 1 0 1 1 1 1 0 1 0 0"
   *      "0 1 0 0 0 0 0 0 1 0 0"
   *      "0 1 1 1 1 1 1 1 1 0 0"
   *      "0 0 0 0 0 0 0 0 0 0 0"
   *
   *   If the coordinate is given by the position of the X in the example (row = 2, column = 5), then the method should
   *   return "true", since the coordinate is surrounded by a closed figure made by 1s.
   *   b)
   *      "0 0 0 0 0 0 0 0 0 0 0"
   *      "0 1 1 1 1 1 1 1 1 0 0"
   *      "0 1 0 0 0 0 0 0 1 0 0"
   *      "0 1 0 1 1 1 1 0 1 0 0"
   *      "0 1 0 1 0 0 1 1 1 0 0"
   *      "0 1 0 1 0 X 0 0 0 0 0"
   *      "0 1 0 1 0 0 1 1 1 0 0"
   *      "0 1 0 1 1 1 1 0 1 0 0"
   *      "0 1 0 0 0 0 0 0 1 0 0"
   *      "0 1 1 1 1 1 1 1 1 0 0"
   *      "0 0 0 0 0 0 0 0 0 0 0"
   *
   *   In this case, X is placed in row = 5, column = 5, and it's outside the figure made by 1s, so the method should
   *   return false.
   * @param row The row coordinate in the binary matrix
   * @param column The column coordinate in the binary matrix
   * @return a boolean value indicating if the coordinate is surrounded by the figure made of 1s
   */
  public boolean isInside(int row, int column) {
    if (!isInsideTheMatrix(row, column)) {
      return false;
    }
    FigureBoundaries boundaries = calculateAndGetFigureBoundaries();

    /*
    IMPORTANT: This boundaries are always taken as a square figure. As the figure can be any figure,
    we have to check if the given coordinate is surrounded by ones too.
     */
    return isInsideFigureBoundaries(row, column, boundaries) && isSurroundedByOnes(row, column);
  }

  private boolean isInsideTheMatrix(int row, int column) {
    return column >= 0 && column < matrix.length && row >= 0 && row < matrix[0].length;
  }

  /** This method calculates the figure boundaries by searching the 1's position in matrix.
   *
   * @return a FigureBoundaries object with the boundaries information
   */
  private FigureBoundaries calculateAndGetFigureBoundaries() {
    FigureBoundaries boundaries = new FigureBoundaries();

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[0].length; column++) {
        if (matrix[row][column] == 1) {
          if (boundaries.getTop() == 0) {
            boundaries.setTop(row);
            boundaries.setLeft(column);
          }
          if (boundaries.getTop() != row) {
            boundaries.setBottom(row);
          }
          boundaries.setRight(column);
        }
      }
    }
    return boundaries;
  }

  /** This method returns true if the given coordinate is inside the figure boundaries.
   *
   * @return a boolean value indicating if the coordinate is inside figure boundaries
   */
  private boolean isInsideFigureBoundaries(int row, int column, FigureBoundaries boundaries) {
    return row > boundaries.getTop() && row < boundaries.getBottom()
        && column > boundaries.getLeft() && column < boundaries.getRight();
  }

  /** This method returns true if the given coordinate is surrounded by 1's in every direction.
   * It use a recursive logic to check if this is true.
   * @return a boolean value indicating if the coordinate is surrounded by 1's
   */
  private boolean isSurroundedByOnes(int row, int column) {
    return hasAOneAtTop(row, column) && hasAOneAtBottom(row, column) &&
        hasAOneAtRight(row, column) && hasAOneAtLeft(row, column);
  }

  boolean hasAOneAtLeft(int row, int column) {
    if (!isInsideTheMatrix(row, column)) {
      return false;
    }
    if (matrix[row][column] == 1) {
      return true;
    }
    return hasAOneAtLeft(row -1, column);
  }

  boolean hasAOneAtRight(int row, int column) {
    if (!isInsideTheMatrix(row, column)) {
      return false;
    }
    if (matrix[row][column] == 1) {
      return true;
    }
    return hasAOneAtRight(row + 1, column);
  }

  boolean hasAOneAtBottom(int row, int column) {
    if (!isInsideTheMatrix(row, column)) {
      return false;
    }
    if (matrix[row][column] == 1) {
      return true;
    }
    return hasAOneAtBottom(row, column -1);
  }

  boolean hasAOneAtTop(int row, int column) {
    if (!isInsideTheMatrix(row, column)) {
      return false;
    }
    if (matrix[row][column] == 1) {
      return true;
    }
    return hasAOneAtTop(row, column + 1);
  }

}

