package de.uni_ulm.sp.oop.sose24.sheet11.sudoku;

public class SudokuBoard {
    private final int[][] board;

    public SudokuBoard() {
        board = new int[9][9];
    }

    public int getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, int value) {
        board[row][col] = value;
    }

    public int[][] getBoard() {
        return board;
    }
}
