package edu.neumont;

public class GameBoard {
    private char[][] board;
    private int rowSize;
    private int columnSize;

    public GameBoard(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;

        board = new char[rowSize][columnSize];
    }
}
