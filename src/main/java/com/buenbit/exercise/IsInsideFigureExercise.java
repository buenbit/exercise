package com.buenbit.exercise;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsInsideFigureExercise {

  private short[][] matrix;

  private boolean[][] booleanMatrix;

  public IsInsideFigureExercise(short[][] matrix) {
    this.matrix = matrix;
  }

  /**
   * Given a binary matrix (A matrix full of 0s and 1s) of NxM, write a method isInside that
   * receives a coordinate row, column, and determines if such point is inside a figure drawn with
   * 1s, and filled with 0s.
   * <p>
   * Examples: a) "0 0 0 0 0 0 0 0 0 0 0" "0 1 1 1 1 1 1 1 1 0 0" "0 1 0 0 0 X 0 0 1 0 0" "0 1 0 1 1
   * 1 1 0 1 0 0" "0 1 0 1 0 0 1 1 1 0 0" "0 1 0 1 0 0 0 0 0 0 0" "0 1 0 1 0 0 1 1 1 0 0" "0 1 0 1 1
   * 1 1 0 1 0 0" "0 1 0 0 0 0 0 0 1 0 0" "0 1 1 1 1 1 1 1 1 0 0" "0 0 0 0 0 0 0 0 0 0 0"
   * <p>
   * If the coordinate is given by the position of the X in the example (row = 2, column = 5), then
   * the method should return "true", since the coordinate is surrounded by a closed figure made by
   * 1s. b) "0 0 0 0 0 0 0 0 0 0 0" "0 1 1 1 1 1 1 1 1 0 0" "0 1 0 0 0 0 0 0 1 0 0" "0 1 0 1 1 1 1 0
   * 1 0 0" "0 1 0 1 0 0 1 1 1 0 0" "0 1 0 1 0 X 0 0 0 0 0" "0 1 0 1 0 0 1 1 1 0 0" "0 1 0 1 1 1 1 0
   * 1 0 0" "0 1 0 0 0 0 0 0 1 0 0" "0 1 1 1 1 1 1 1 1 0 0" "0 0 0 0 0 0 0 0 0 0 0"
   * <p>
   * In this case, X is placed in row = 5, column = 5, and it's outside the figure made by 1s, so
   * the method should return false.
   *
   * @param row    The row coordinate in the binary matrix
   * @param column The column coordinate in the binary matrix
   * @return a boolean value indicating if the coordinate is surrounded by the figure made of 1s
   */
  public boolean isInside(int row, int column) {
    if (!isInsideMatrix(row, column)) {
      return false;
    }
    calculateBooleanMatrix();
    return this.booleanMatrix[row][column];
  }

  /**
   * @return a boolean matrix with values inside the figure as true
   */
  private void calculateBooleanMatrix() {
    this.booleanMatrix = new boolean[matrix.length][matrix[0].length];

    //First, we find a one inside matrix and we use recursion to follow the ones path and set
    // all them as true in the new boolean matrix.
    Coordinate firstOneCoordinate = getFirstOneInsideMatrix();
    markOnesInsideFigureAsTrue(firstOneCoordinate.x, firstOneCoordinate.y);

    //Then, we find a zero inside the one's figure and we use recursion to follow the zero path and set
    // all them as true in the new boolean matrix.
    Coordinate firstZeroCoordinate = getFirstZeroInsideFigure();
    markZerosInsideFigureAsTrue(firstZeroCoordinate);

    System.out.println("Received integer matrix casted as boolean matrix as: ");
    printBooleanMatrix();
  }

  private boolean isInsideMatrix(int row, int column) {
    return column >= 0 && column <= matrix.length && row >= 0 && row <= matrix[0].length;
  }

  /**
   * This method loops through the matrix until it finds a one.
   * @return a Coordinate object with the coordinates of the found one inside the matrix
   */
  private Coordinate getFirstOneInsideMatrix() {
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[0].length; column++) {
        if (matrix[row][column] == 1) {
          return new Coordinate(row, column);
        }
      }
    }
    //todo: This case should throw an exception if the matrix does not have a figure
    return new Coordinate(0, 0);
  }

  /**
   * This method loops through the matrix until it finds a one. When it finds a one,
   * checks if there is a zero in the adjacents of that one. If it finds a zero,
   * will return the zero coordinates inside the matrix (because this is a zero inside the ones figure).
   * @return a Coordinate object with the coordinates of the found zero inside the figure.
   */
  private Coordinate getFirstZeroInsideFigure() {
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[0].length; column++) {
        if (matrix[row][column] == 1) {
          this.booleanMatrix[row][column] = true;
          //Checks if there's a zero on the bottom
          if (matrix[row + 1][column] == 0) {
            return new Coordinate(row + 1, column);
          }
          //Checks if there's a zero on the right
          if (matrix[row][column + 1] == 0) {
            return new Coordinate(row, column + 1);
          }
          // Checks if there's a zero diagonally
          if (matrix[row + 1][column + 1] == 0) {
            return new Coordinate(row + 1, column + 1);
          }
        }
      }
    }
    //todo: This case should throw an exception if the matrix does not have a figure
    return new Coordinate(0, 0);
  }

  /**
   * This method start to loop the matrix from a zero coordinate inside the figure of one's and start
   * following the path of zeros and marking them as true in the new boolean matrix
   */
  private void markZerosInsideFigureAsTrue(Coordinate firstZeroCoordinate) {
    Queue<Coordinate> zerosToApplyQueue = new ArrayDeque<>();
    zerosToApplyQueue.add(firstZeroCoordinate);

    while (!zerosToApplyQueue.isEmpty()) {
      Coordinate CurrentCoordinate = zerosToApplyQueue.poll();
      int row = CurrentCoordinate.x;
      int column = CurrentCoordinate.y;

      //Checks if there is a zero above, if there is it set it to true in the new boolean matrix.
      enqueueAndMarkZeroAsTrue(row, column - 1, zerosToApplyQueue);
      //Checks if there is a zero on the bottom, if there is it set it to true in the new boolean matrix.
      enqueueAndMarkZeroAsTrue(row, column + 1, zerosToApplyQueue);
      //Checks if there is a zero on the left, if there is it set it to true in the new boolean matrix.
      enqueueAndMarkZeroAsTrue(row - 1, column, zerosToApplyQueue);
      //Checks if there is a zero on the right, if there is it set it to true in the new boolean matrix.
      enqueueAndMarkZeroAsTrue(row + 1, column, zerosToApplyQueue);
    }
  }

  private void enqueueAndMarkZeroAsTrue(int row, int column, Queue queue) {
    if (!isInsideMatrix(row, column)) {
      return;
    }
    if (this.booleanMatrix[row][column]) {
      return;
    }
    if (matrix[row][column] == 0) {
      queue.add(new Coordinate(row, column));
      this.booleanMatrix[row][column] = true;
    }
  }

  /**
   * This method start to loop the matrix from a one coordinate inside the figure and start
   * following the path of zeros and marking them as true in the new boolean matrix
   */
  private void markOnesInsideFigureAsTrue(int row, int column) {
    //Checks if there is a one on the left, if there is it set it to true in the new boolean matrix.
    if (isAPendingOneToProcess(row , column - 1)) {
      this.booleanMatrix[row][column] = true;
      markOnesInsideFigureAsTrue(row,  column - 1);
    }
    //Checks if there is a one on the right, if there is it set it to true in the new boolean matrix.
    if (isAPendingOneToProcess(row, column + 1)) {
      this.booleanMatrix[row][column] = true;
      markOnesInsideFigureAsTrue(row,  column + 1);
    }
    //Checks if there is a one above, if there is it set it to true in the new boolean matrix.
    if (isAPendingOneToProcess(row - 1, column)) {
      this.booleanMatrix[row][column] = true;
      markOnesInsideFigureAsTrue(row - 1,  column);
    }
    //Checks if there is a one on the bottom, if there is it set it to true in the new boolean matrix.
    if (isAPendingOneToProcess(row, column)) {
      this.booleanMatrix[row][column] = true;
      markOnesInsideFigureAsTrue(row + 1,  column);
    }
    return;
  }

  private boolean isAPendingOneToProcess(int row, int column) {
    return isInsideMatrix(row, column) && matrix[row][column] == 1
        && !this.booleanMatrix[row][column];
  }

  private void printBooleanMatrix() {
    for (int i = 0; i < this.booleanMatrix.length; i++) {
      for (int j = 0; j < this.booleanMatrix[i].length; j++) {
        if (this.booleanMatrix[i][j]) {
          System.out.print("T" + " ");
        } else {
          System.out.print("F" + " ");
        }
      }
      System.out.println();
    }
  }

}

class Coordinate {

  int x, y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

