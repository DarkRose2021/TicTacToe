package edu.neumont;

public class GameBoard {
    private char[][] board;
    private int rowSize;
    private int columnSize;

    public GameBoard(int columnSize, int rowSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;

        board = new char[rowSize][columnSize];
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void reset() {
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                board[row][column] = ' ';
            }
        }
    }

    public void setGrid(int column, int row, char symbol){
        board[row -1][column -1] = symbol;
    }

    public char getGrid(int column, int row){
        return board[row -1][column -1];
    }

    public void print() {
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                System.out.print(board[row][column] + "  |");
            }
            System.out.println("\n---|---|---");
        }
        System.out.println();
    }
}
