package com.buenbit.exercise;

public class IsInsideFigureExercise {

  private short[][] matrix;

  public IsInsideFigureExercise(short[][] matrix) {
    this.matrix = matrix;
  }

  /**
   * Given a binary matrix (A matrix full of 0s and 1s) of NxM, write a method isInside that receives a coordinate row,
   * column, and determines if such point is inside a figure drawn with 1s, and filled with 0s.
   * <p>
   * Examples:
   * a)
   * "0 0 0 0 0 0 0 0 0 0 0"
   * "0 1 1 1 1 1 1 1 1 0 0"
   * "0 1 0 0 0 X 0 0 1 0 0"
   * "0 1 0 1 1 1 1 0 1 0 0"
   * "0 1 0 1 0 0 1 1 1 0 0"
   * "0 1 0 1 0 0 0 0 0 0 0"
   * "0 1 0 1 0 0 1 1 1 0 0"
   * "0 1 0 1 1 1 1 0 1 0 0"
   * "0 1 0 0 0 0 0 0 1 0 0"
   * "0 1 1 1 1 1 1 1 1 0 0"
   * "0 0 0 0 0 0 0 0 0 0 0"
   * <p>
   * If the coordinate is given by the position of the X in the example (row = 2, column = 5), then the method should
   * return "true", since the coordinate is surrounded by a closed figure made by 1s.
   * b)
   * "0 0 0 0 0 0 0 0 0 0 0"
   * "0 1 1 1 1 1 1 1 1 0 0"
   * "0 1 0 0 0 0 0 0 1 0 0"
   * "0 1 0 1 1 1 1 0 1 0 0"
   * "0 1 0 1 0 0 1 1 1 0 0"
   * "0 1 0 1 0 X 0 0 0 0 0"
   * "0 1 0 1 0 0 1 1 1 0 0"
   * "0 1 0 1 1 1 1 0 1 0 0"
   * "0 1 0 0 0 0 0 0 1 0 0"
   * "0 1 1 1 1 1 1 1 1 0 0"
   * "0 0 0 0 0 0 0 0 0 0 0"
   * <p>
   * In this case, X is placed in row = 5, column = 5, and it's outside the figure made by 1s, so the method should
   * return false.
   *
   * @param row    The row coordinate in the binary matrix
   * @param column The column coordinate in the binary matrix
   * @return a boolean value indicating if the coordinate is surrounded by the figure made of 1s
   */
  public boolean isInside(int row, int column) {

    /*  Solution logic, I want to know how many ones there is in each direction
     *   because if there number is odd is mean that it is inside a figure, since the lines of the figure
     *   are always going to be orthogonal
     */
    //counting left
    int leftAmountOfOnes = iterateMatrixHorizontally(row, column, true);

    //counting right
    int rightAmountOfOnes = iterateMatrixHorizontally(row, column, false);

    //counting top
    int topAmountOfOnes = iterateMatrixVertically(row, column, false);

    //counting bottom
    int bottomAmountOfOnes = iterateMatrixVertically(row, column, true);

    return verifyLimit(leftAmountOfOnes) && verifyLimit(topAmountOfOnes) && verifyLimit(bottomAmountOfOnes) && verifyLimit(rightAmountOfOnes);
  }

  /**
   * Check if the amount of ones is even or odd
   *
   * @param amountOfOnesForDirection
   * @return
   */
  private boolean verifyLimit(int amountOfOnesForDirection) {
    return amountOfOnesForDirection % 2 != 0;
  }

  /**
   * Method in charge of iterating vertically, on row to row basis.
   *
   * @param currentRow
   * @param currentColumn
   * @param increment
   * @return Amount of ones found
   */
  private int iterateMatrixVertically(int currentRow, int currentColumn, boolean increment) {
    int amountOfOnes = 0;
    currentRow = increment ? currentRow + 1 : currentRow - 1;
    boolean reachedALimit = currentRow == this.matrix.length || currentRow < 0;
    if (!reachedALimit) {
      //need to do this checks to avoid index out of bounds errors
      if (matrix[currentRow][currentColumn] == 1 &&
              ((matrix.length > currentRow + 1 && matrix[currentRow + 1][currentColumn] == 0)
                      || (0 < currentRow - 1 && matrix[currentRow - 1][currentColumn] == 0))) {
        amountOfOnes += 1;
      }
      return amountOfOnes + iterateMatrixVertically(currentRow, currentColumn, increment);
    } else {
      return amountOfOnes;
    }
  }

  /**
   * Method in charge of iterating horizontally, on column to column basis.
   *
   * @param currentRow
   * @param currentColumn
   * @param increment
   * @return Amount of ones found
   */
  private int iterateMatrixHorizontally(int currentRow, int currentColumn, boolean increment) {
    int amountOfOnes = 0;
    currentColumn = increment ? currentColumn + 1 : currentColumn - 1;
    boolean reachedALimit = currentColumn == this.matrix[0].length || currentColumn < 0;
    if (!reachedALimit) {
      //need to do this checks to avoid index out of bounds errors
      if (matrix[currentRow][currentColumn] == 1 &&
              ((matrix[currentRow].length > currentColumn + 1 && matrix[currentRow][currentColumn + 1] == 0)
                      || (0 < currentColumn - 1 && matrix[currentRow][currentColumn - 1] == 0))) {
        amountOfOnes += 1;
      }
      return amountOfOnes + iterateMatrixHorizontally(currentRow, currentColumn, increment);
    } else {
      return amountOfOnes;
    }
  }

}
