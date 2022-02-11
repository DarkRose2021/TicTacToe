package edu.neumont;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void takeTurn(GameBoard gameBoard) {
        boolean open = false;
        while (!open){
            int column = Console.getInteger(getName() + " enter column placement: ", 1, gameBoard.getColumnSize());
            int row = Console.getInteger(getName() + " enter rows placement: ", 1, gameBoard.getRowSize());
            if(gameBoard.getGrid(column, row) == ' '){
                open = true;
                gameBoard.setGrid(column, row, getSymbol());
            }else{
                Console.setColor(Console.RED_BACKGROUND);
                Console.print("Location not open", Console.BLACK);
                System.out.println();
                gameBoard.print();
            }
        }
    }

}
