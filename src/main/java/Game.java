import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        Player secondPlayer = new HumanPlayer(" ", ' ') {
            @Override
            public int move() {
                return 0;
            }
        };

        Player firstPlayer = new HumanPlayer(" ", ' ') {
            @Override
            public int move() {
                return 0;
            }
        };
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
                board.setField(userChoice, firstPlayer.getPlayerSign());
                if (board.checkIfWinner(firstPlayer.getPlayerSign(), firstPlayer.getNickName())) {
                    break;
                }
                System.out.println("Now Player: " + "'" + secondPlayer.getNickName() + "'");

            } else if (counter % 2 != 0) {
                board.setField(userChoice, secondPlayer.getPlayerSign());
                if (board.checkIfWinner(secondPlayer.getPlayerSign(), secondPlayer.getNickName())) {
                    break;
                }
                System.out.println("Now Player: " + "'" + firstPlayer.getNickName() + "'");
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