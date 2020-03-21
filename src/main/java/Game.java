import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        Scanner sc = new Scanner(System.in);

        Player firstPlayer = null;
        Player secondPlayer = null;
        Player currentPlayer = null;

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

        System.out.println("Welcome to Tic Tac Toe game.");
        System.out.println();
        // Welcome

        board.printBoard();
        int counter = 0;

        Set<Integer> choices = new HashSet<>();
        while (choices.size() != 9) {

            if (counter % 2 == 0) {
                currentPlayer = firstPlayer;
            } else if (counter % 2 != 0) {
                currentPlayer = secondPlayer;
            }
            int userChoice = currentPlayer.move();


            if (choices.contains(userChoice)) {
                System.out.println("This field ia unavailable, please choose another.");
                continue;
            } else {
                choices.add(userChoice);
            }

            if (currentPlayer == firstPlayer) {
                board.setField(userChoice, firstPlayer.getPlayerSign());
                if (board.checkIfWinner(firstPlayer.getPlayerSign(), firstPlayer.getNickName())) {
                    break;
                }
                System.out.println("Now Player: " + "'" + secondPlayer.getNickName() + "'");

            } else if (currentPlayer == secondPlayer) {
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
