import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe game.");
        System.out.println();
        // Welcome

        System.out.println("Choose sign for First Player...(X, O, etc.)");
        char firstSign = sc.next().charAt(0);
        System.out.println("Provide nick for First Player: ");
        String firstPLayerNickName = sc.next();
        // First Player

        System.out.println("Choose sign for Second Player...(X, O, etc.)");
        char secondSign = sc.next().charAt(0);
        System.out.println("Provide nick for Second Player: ");
        String secondPLayerNickName = sc.next();
        // Second Player
        // to-do Checking if first player has the same sign as second player

        System.out.println("First Player is: " + firstPLayerNickName + " and has " + firstSign + " sign.");
        System.out.println("Second Player is: " + secondPLayerNickName + " and has " + secondSign + " sign.");
        System.out.println("To place your sign, choose appropriate number from keyboard.");

        // Choosing player, signs and entering nicknames, how to play

        System.out.println(firstPLayerNickName + " please enter your number from keyboard...");
        board.printBoard();

        int counter = 0;


        Set<Integer> choices = new HashSet<>();
        while (choices.size() != 9) {
            int userChoice = sc.nextInt();

            if (choices.contains(userChoice)) {
                System.out.println("This field ia unavailable, please choose another.");
                continue;
            } else {
                choices.add(userChoice);
            }

            if (counter % 2 == 0) {
                board.setField(userChoice, firstSign);
                if (Board.checkIfWinner(board.board, firstSign, firstPLayerNickName)) {
                    break;
                }
                System.out.println("Now Player: " + "'" + secondPLayerNickName + "'");

            } else if (counter % 2 != 0) {
                board.setField(userChoice, secondSign);

                if (Board.checkIfWinner(board.board, secondSign, secondPLayerNickName))
                System.out.println("Now Player: " + "'" + firstPLayerNickName + "'");
            }
            board.printBoard();
            counter++; // changing player

            System.out.println();
            if (choices.size() == 9){
                System.out.println("It is a draw!");
            }
            // Printing draw, when are 9 moves
        }
    }
}