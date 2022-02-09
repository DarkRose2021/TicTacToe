package edu.neumont;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private GameBoard gameBoard;
    private int winLength;
    private ArrayList<Player> players = new ArrayList<>();
    private int turn;

    public Game(int columns, int rows, int winLength){
        gameBoard = new GameBoard(columns, rows);
        this.winLength = winLength;
    }

    public void run(){
        //add players
        players.add(new Player("Cynthia", 'X'));
        players.add(new Player("John", 'O'));

        //reset game
        turn = 0;
        gameBoard.reset();

        //start game
        boolean gameOver = false;
        while (!gameOver){
            Player player = players.get(turn);
            gameBoard.print();

            boolean open = false;
            while (!open){
                int column = Console.getInteger(player.getName() + " enter column placement: ", 1, gameBoard.getColumnSize());
                int row = Console.getInteger(player.getName() + " enter rows placement: ", 1, gameBoard.getRowSize());
                if(gameBoard.getGrid(column, row) == ' '){
                    open = true;
                    gameBoard.setGrid(column, row, player.getSymbol());
                }else{
                    Console.setColor(Console.RED_BACKGROUND);
                    Console.setColor(Console.BLACK);
                    System.out.println("Location is not open. Please enter a new location");
                    Console.setColor(Console.RESET);
                    System.out.println();
                    gameBoard.print();
                }
            }

            turn++;
            if(turn == players.size())turn = 0;

        }
    }
}
