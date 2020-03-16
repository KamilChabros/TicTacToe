import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe game.");
        System.out.println("To place your sign, choose appropriate number from keyboard.");
        System.out.println();
        // Welcome, printing board and choosing information

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
        // to-do Checking if first player has the same sign

        System.out.println("First Player is: " + firstPLayerNickName + " and has " + firstSign + " sign.");
        System.out.println("Second Player is: " + secondPLayerNickName + " and has " + secondSign + " sign.");
        // Choosing player, signs and entering nicknames

        System.out.println("Please enter your number from keyboard...");
        board.printBoard();

        int counter = 0;


        Set<Integer> choices = new HashSet<>();
        while (choices.size() != 9) {
            int userChoice = sc.nextInt();

            if (choices.contains(userChoice)) {
                System.out.println("To pole zostało już wybrane! Wybierz inne.");
                continue;
            } else {
                choices.add(userChoice);
            }

            if (counter % 2 == 0) {
                board.setField(userChoice, firstSign);

                if (board.board[0][0] + board.board[1][1] + board.board[2][2] == firstSign * 3 ||
                        board.board[2][0] + board.board[1][1] + board.board[0][2] == firstSign * 3 ||
                        // above is checking diagonal
                        board.board[0][0] + board.board[0][1] + board.board[0][2] == firstSign * 3 ||
                        board.board[1][0] + board.board[1][1] + board.board[1][2] == firstSign * 3 ||
                        board.board[2][0] + board.board[2][1] + board.board[2][2] == firstSign * 3 ||
                        // above is checking row
                        board.board[0][0] + board.board[1][0] + board.board[2][0] == firstSign * 3 ||
                        board.board[0][1] + board.board[1][1] + board.board[2][1] == firstSign * 3 ||
                        board.board[0][2] + board.board[1][2] + board.board[2][2] == firstSign * 3)
                // above is checking column
                {
                    System.out.println("Player " + firstPLayerNickName + " win!");
                    break;
                }
                System.out.println("Teraz gracz " + secondPLayerNickName);
            } else if (counter % 2 != 0) {
                board.setField(userChoice, secondSign);

                if (board.board[0][0] + board.board[1][1] + board.board[2][2] == secondSign * 3 ||
                        board.board[2][0] + board.board[1][1] + board.board[0][2] == secondSign * 3 ||
                        // above is checking diagonal
                        board.board[0][0] + board.board[0][1] + board.board[0][2] == secondSign * 3 ||
                        board.board[1][0] + board.board[1][1] + board.board[1][2] == secondSign * 3 ||
                        board.board[2][0] + board.board[2][1] + board.board[2][2] == secondSign * 3 ||
                        // above is checking row
                        board.board[0][0] + board.board[1][0] + board.board[2][0] == secondSign * 3 ||
                        board.board[0][1] + board.board[1][1] + board.board[2][1] == secondSign * 3 ||
                        board.board[0][2] + board.board[1][2] + board.board[2][2] == secondSign * 3)
                // above is checking column
                {
                    System.out.println("Player " + secondPLayerNickName + " win!");
                    break;
                }
                System.out.println("Teraz gracz " + firstPLayerNickName);
            }
            board.printBoard();
            counter++; // zmiana gracza

        }
    }
}