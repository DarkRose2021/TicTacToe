package edu.neumont;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private GameBoard gameBoard;
    private int winLength;
    private ArrayList<Player> players = new ArrayList<>();
    private int turn;

    public Game(int columns, int rows, int winLength) {
        gameBoard = new GameBoard(columns, rows);
        this.winLength = winLength;
    }

    public void run() {
        //show player
        //show menu selection
        //switch on selection
        //add players
        players.add(new HumanPlayer("Cynthia", 'X'));
        players.add(new HumanPlayer("John", 'O'));

        //app loop
        //game loop
        boolean quit = false;
        while (!quit) {

            //reset game
            turn = 0;
            gameBoard.reset();

            //start game
            Player winner = null;
            boolean gameOver = false;
            while (!gameOver) {
                Player player = players.get(turn);
                gameBoard.print();
                player.takeTurn(gameBoard);
                if (gameBoard.checkWin(player.getSymbol(), winLength)) {
                    gameOver = true;
                    winner = player;
                }
                if (++turn == players.size()) turn = 0;

            }
            //display winner or CAT game
            gameBoard.print();
            if (winner != null) {
                Console.println(winner.getName() + " is the winner!", Console.CYAN);
            }else {
                Console.println("CATS's game!", Console.RED);
            }

           String playAgain = Console.getString("Play again? [y/n]: ");
            if(playAgain.equalsIgnoreCase("n"))quit = true;
        }
    }
}
