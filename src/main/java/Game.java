import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        Player firstPlayer = new Player();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe game.");
        System.out.println();
        // Welcome


        System.out.println("To place your sign, choose appropriate number from keyboard.");

        // Choosing player, signs and entering nicknames, how to play

//        System.out.println(firstPLayerNickName + " please enter your number from keyboard...");
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
                board.setField(userChoice, firstPlayer.firstSign);
                if (board.checkIfWinner(firstPlayer.firstSign, firstPlayer.firstPLayerNickName)) {
                    break;
                }
                System.out.println("Now Player: " + "'" + secondPLayerNickName + "'");

            } else if (counter % 2 != 0) {
                board.setField(userChoice, secondSign);
                if (board.checkIfWinner(secondSign, secondPLayerNickName)) {
                    break;
                }
                System.out.println("Now Player: " + "'" + firstPLayerNickName + "'");
            }
            board.printBoard();
            counter++; // changing player

            System.out.println();
            if (choices.size() == 9) {
                System.out.println("It is a draw!");
            }
            // Printing draw, when are 9 moves
        }
    }
}