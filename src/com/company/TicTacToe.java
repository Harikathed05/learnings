package com.company;

/**
 * Assume the following rules are for the tic-tac-toe game on an n x n board between two players:
 *
 *     A move is guaranteed to be valid and is placed on an empty block.
 *     Once a winning condition is reached, no more moves are allowed.
 *     A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 * Implement the TicTacToe class:
 *
 *     TicTacToe(int n) Initializes the object the size of the board n.
 *     int move(int row, int col, int player) Indicates that the player with id player plays at the cell (row, col) of
 *     the board. The move is guaranteed to be a valid move, and the two players alternate in making moves. Return
 *         0 if there is no winner after the move,
 *         1 if player 1 is the winner after the move, or
 *         2 if player 2 is the winner after the move.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
 * [[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
 * Output
 * [null, 0, 0, 0, 0, 0, 0, 1]
 */
public class TicTacToe {
    int [][] matrix;
    int [] rowsSum;
    int [] sumColum;
    public TicTacToe(int n) {
        this.matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = 100;
            }
        }
        this.sumColum =  new int[n];
        this.rowsSum =  new int[n];
        for (int i = 0; i < n; i++) {
            int tempRowSum = 0;
            for (int j = 0; j < n; j++) {
                tempRowSum += matrix[i][j];
            }
           rowsSum[i] = tempRowSum;
        }
        for (int j = 0; j < n; j++) {
            int tempColumnSum = 0;
            for (int i = 0; i < n; i++) {
                tempColumnSum += matrix[i][j];
            }
            sumColum[j] = tempColumnSum;
        }
    }
    public boolean checkStatus(int sum, int n) {
        if ((sum == n) || (sum == 2*n)) {
            return true;
        }
        return false;
    }
    public boolean checkTicTacToeStatus(int x, int y, int player) {
        int rows = matrix.length;
        int coloums = matrix[0].length;
        int sumDiagonally = 0;
        for (int i = 0; i < rows; i++) {
            sumDiagonally += matrix[i][i];
        }
        if (checkStatus(sumDiagonally, rows)) {
            return true;
        } else {
            sumDiagonally = 0;
        }
        int tempColoums = coloums;
        for (int j = 0; j < coloums; j++) {
            sumDiagonally += matrix[j][--tempColoums];
        }
        if (checkStatus(sumDiagonally, rows)) {
            return true;
        } else {
            sumDiagonally = 0;
        }
        rowsSum[x] = this.rowsSum[x] + player - 100;
        for (int i = 0; i < rows; i++) {
            if (checkStatus(rowsSum[i], rows)) {
                return true;
            }
        }
        sumColum[y] = sumColum[y] + player - 100;
        for (int i = 0; i < rows; i++) {
            if (checkStatus(sumColum[i], rows)) {
                return true;
            }
        }
        return sumDiagonally == 0 ? false : true;
    }
    public boolean insertTicTacToe(int x, int y, int player) {
        this.matrix[x][y] = player;
        return checkTicTacToeStatus(x, y, player);
    }
    public static void main(String [] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println("stage 0, 0, 1 "+ ticTacToe.insertTicTacToe(0, 0, 1));
        System.out.println("stage 0, 2, 0 " + ticTacToe.insertTicTacToe(0, 2, 2));
        System.out.println("stage 2, 2, 1 " + ticTacToe.insertTicTacToe(2, 2, 1));
        System.out.println("stage 1, 1, 0 " + ticTacToe.insertTicTacToe(1, 1, 2));
        System.out.println("stage 2, 0, 1 " + ticTacToe.insertTicTacToe(2, 0, 1));
        System.out.println("stage 1, 0, 2 " + ticTacToe.insertTicTacToe(1, 0, 2));
        System.out.println("stage 2, 1, 1 " + ticTacToe.insertTicTacToe(2, 1, 1));
    }
}
