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

        Set<Integer> choises = new HashSet<>();
        for (int i = 0; i < 9; i++) {

            int userChoice = sc.nextInt();

            if (choises.contains(userChoice)) {
                System.out.println("Te pole zostało już wybrane! Wybierz inne.");
                continue;
            }else {
                choises.add(userChoice);
            }

            if (activePlayer == 'X') {
                board.setField(userChoice, 'X');
            }
            if (activePlayer == 'O') {
                board.setField(userChoice, 'O');
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
