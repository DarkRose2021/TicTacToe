package edu.neumont;

import java.util.Random;

public class AIPlayer extends Player{
    public AIPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void takeTurn(GameBoard gameBoard) {
        boolean open = false;
        while (!open){
            int column = new Random().nextInt(1, gameBoard.getColumnSize());
            int row = new Random().nextInt(1, gameBoard.getRowSize());

            if(gameBoard.getGrid(column, row) == ' '){
                open = true;
                gameBoard.setGrid(column, row, getSymbol());
            }
        }
        Console.println("AI " +getName()+ " has taken a turn. ", Console.BLUE);
    }
}
