package com.sylvanas.algorithms_exercise.array;

/**
 * Given a chess board having N×N cells,
 * you need to place N queens on the board in such a way that no queen attacks any other queen.
 *
 * Input:
 * The only line of input consists of a single integer denoting N.
 *
 * Output:
 * If it is possible to place all the N queens in such a way that no queen attacks another queen,
 * then print "YES" (without quotes) in first line, then print N lines having N integers.
 * The integer in ith line and jth column will denote the cell (i,j) of the board and should
 * be 1 if a queen is placed at (i,j) otherwise 0. If there are more than way of placing queens print any of them.
 *
 * If it is not possible to place all N queens in the desired way, then print "NO" (without quotes).
 *
 * more details: https://www.hackerearth.com/zh/practice/basic-programming/recursion/recursion-and-backtracking/tutorial/
 *
 * Example:
 * input: 4
 * ---------------------
 * output:
 * YES
 * 0 1 0 0
 * 0 0 0 1
 * 1 0 0 0
 * 0 0 1 0
 *
 * Created by SylvanasSun on 4/3/2018.
 */
public class NQueen {

    private static void printBoard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
    }


    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower diagonal on left side
        for (i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    public static boolean solution(int[][] board, int col) {
        // all queens are placed then return true
        if (col >= board.length)
            return true;

        // consider this column and try placing this queen
        // in all row one by one
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                // recur to place rest of the queens
                if (solution(board, col + 1))
                    return true;
                // if placing queen in board[i][col] doesn't
                // lead to a solution then remove queen from board[i][col]
                board[i][col] = 0; // backtrack
            }
        }

        // queen can not be place in any row in this column
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[7][7];

        if (solution(board, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        printBoard(board);
    }

}
