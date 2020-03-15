import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        Scanner sc = new Scanner(System.in);

        System.out.println("Witam w grze w kółko i krzyżyk.");
        System.out.println("Wybierz numer odpowiadający polu, które chcesz wybrać.");
        board.printBoard();
        System.out.println();
        System.out.println("Pierwszy gracz to X");

        char activePlayer = 'X';
        int counter = 1;

        System.out.println("Podaj proszę numer pola...");

        Set<Integer> choices = new HashSet<>();
        while (choices.size() != 9) {
            int userChoice = sc.nextInt();

            if (choices.contains(userChoice)) {
                System.out.println("To pole zostało już wybrane! Wybierz inne.");
                continue;
            } else {
                choices.add(userChoice);
            }

            if (activePlayer == 'X') {
                board.setField(userChoice, 'X');
                if (board.board[0][0] + board.board[1][1] + board.board[2][2] == activePlayer * 3 ||
                        board.board[2][0] + board.board[1][1] + board.board[0][2] == activePlayer * 3 ||
                        // above is diagonal
                        board.board[0][0] + board.board[0][1] + board.board[0][2] == activePlayer * 3 ||
                        board.board[1][0] + board.board[1][1] + board.board[1][2] == activePlayer * 3 ||
                        board.board[2][0] + board.board[2][1] + board.board[2][2] == activePlayer * 3 ||
                        // above is row
                        board.board[0][0] + board.board[1][0] + board.board[2][0] == activePlayer * 3 ||
                        board.board[0][1] + board.board[1][1] + board.board[2][1] == activePlayer * 3 ||
                        board.board[0][2] + board.board[1][2] + board.board[2][2] == activePlayer * 3)
                // above is column
                {
                    System.out.println("You win!");
                    System.out.println("Player 'X' win!");
                    break;
                }
            }
            if (activePlayer == 'O') {
                board.setField(userChoice, 'O');
                if (board.board[0][0] + board.board[1][1] + board.board[2][2] == activePlayer * 3) {
                    System.out.println("You win!");
                    System.out.println("Player 'O' win!");
                    break;
                }
            }

            board.printBoard();
            counter++; // zmiana gracza

            if (counter % 2 == 0) {
                activePlayer = 'O';
                System.out.println("Teraz gracz O");
            } else {
                activePlayer = 'X';
                System.out.println("Teraz gracz X");
            }
        }
    }
}