package com.buenbit.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class IsInsideFigureExercise {

    private short[][] matrix;

    private boolean[][] insideMatrix;

    public IsInsideFigureExercise(short[][] matrix) {
        this.matrix = matrix;
        this.insideMatrix = processMatrix(this.matrix);
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
        return this.insideMatrix[row][column];
    }

    /**
     * processMatrix process the given matrix and build a new NxM boolean matrix
     *
     * @param matrix the NxM matrix
     * @return a boolean NxM matrix that represents with `true` the positions within the given matrix,
     * including the boundaries of the figure formed by 1s.
     * I considered the coordinates of the figure's boundaries as inside it, otherwise isInsideFigureTest test would fail
     */
    private boolean[][] processMatrix(short[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] insideMatrix = new boolean[n][m];

        for (boolean[] i : insideMatrix) {
            Arrays.fill(i, true);
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, 0)); // starts evaluating from [0;0]

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            int posX = current.x;
            int posY = current.y;

            // check if adjacent positions are 0 in the given matrix, if so, I set insideMatrix in false for these positions
            // and enqueue them to evaluate it neighbours
            if (isZero(matrix, insideMatrix, posY, posX + 1)) {
                insideMatrix[posY][posX + 1] = false;
                queue.add(new Pair(posX + 1, posY));
            }

            if (isZero(matrix, insideMatrix, posY, posX - 1)) {
                insideMatrix[posY][posX - 1] = false;
                queue.add(new Pair(posX - 1, posY));
            }

            if (isZero(matrix, insideMatrix, posY + 1, posX)) {
                insideMatrix[posY + 1][posX] = false;
                queue.add(new Pair(posX, posY + 1));
            }

            if (isZero(matrix, insideMatrix, posY - 1, posX)) {
                insideMatrix[posY - 1][posX] = false;
                queue.add(new Pair(posX, posY - 1));
            }
        }

        return insideMatrix;
    }

    private boolean isValid(short[][] matrix, int y, int x) {
        return y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length;
    }

    private boolean isZero(short[][] matrix, boolean[][] insideMatrix, int y, int x) {
        return isValid(matrix, y, x)
                && matrix[y][x] == 0
                && insideMatrix[y][x] // insideMatrix[y][x] in true represents that it has not been evaluated yet because insideMatrix is filled with true
                ;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
