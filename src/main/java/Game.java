import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void main(String[] args) throws IOException {

        Board board = new Board();
        Scanner sc = new Scanner(System.in);

        Player firstPlayer = null;
        Player secondPlayer = null;
        Player currentPlayer = null;
        Player randomizedPlayer = null;

        // Choosing game mode
        System.out.println("Choose mode: \n" +
                "1 is: Player VS Player \n" +
                "2 is: Player VS Cpu \n" +
                "3 is: Cpu VS Cpu");
        int modeChoose = sc.nextInt();
        if (modeChoose == 1) {
            firstPlayer = new HumanPlayer(" ", ' ');
            secondPlayer = new HumanPlayer(" ", ' ');
        } else if (modeChoose == 2) {
            firstPlayer = new HumanPlayer(" ", ' ');
            secondPlayer = new CpuPlayer(" ", ' ');
        } else if (modeChoose == 3) {
            firstPlayer = new CpuPlayer(" ", ' ');
            secondPlayer = new CpuPlayer(" ", ' ');
        }

        //Welcoming
        System.out.println("Welcome to Tic Tac Toe game. \n");
        System.out.println();

        // Section below randomizes which player start the game
        Random rnd = new Random();
        int thisOrThat = rnd.nextInt(100);
        if (thisOrThat % 2 == 0) {
            randomizedPlayer = firstPlayer;
        } else if (thisOrThat % 2 != 0) {
            randomizedPlayer = secondPlayer;
        }

        System.out.println("First player is: " + randomizedPlayer.getNickName() + " with sign: " + "'" + randomizedPlayer.getPlayerSign() + "'");

        //Prints the board of the game
        board.printBoard();
        int counter = thisOrThat;

        Set<Integer> choices = new HashSet<>();
        // Max quantity of moves
        while (choices.size() != 9) {
            // Changing player
            if (counter % 2 == 0) {
                currentPlayer = firstPlayer;
            } else if (counter % 2 != 0) {
                currentPlayer = secondPlayer;
            }
            int userChoice = currentPlayer.move();

            //Checking if field is available
            if (choices.contains(userChoice)) {
                System.out.println("This field ia unavailable, please choose another.");
                continue;
            } else {
                choices.add(userChoice);
            }
            // Sets move for firstPlayer and check winner
            if (currentPlayer == firstPlayer) {
                board.setField(userChoice, firstPlayer.getPlayerSign());
                if (board.checkIfWinner(firstPlayer.getPlayerSign(), firstPlayer.getNickName())) {
                    break;
                }
                System.out.println("Now Player: " + "'" + secondPlayer.getNickName() + "'" + " with sign " + "'" + secondPlayer.getPlayerSign() + "'");

                // Sets move for secondPlayer and check winner
            } else if (currentPlayer == secondPlayer) {
                board.setField(userChoice, secondPlayer.getPlayerSign());
                if (board.checkIfWinner(secondPlayer.getPlayerSign(), secondPlayer.getNickName())) {
                    break;
                }
                System.out.println("Now Player: " + "'" + firstPlayer.getNickName() + "'" + " with sign " + "'" + firstPlayer.getPlayerSign() + "'");
            }
            board.printBoard();
            counter++; // counter for changing player
            if (choices.size() == 9) {
                System.out.println("\n It is a draw!");
            }
        }
        // Printing draw, when are 9 moves
    }
}
