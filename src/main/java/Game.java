import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        Scanner sc = new Scanner(System.in);

        board.printBoard();
        System.out.println();
        System.out.println("Pierwszy gracz to X");

        char activePlayer = 'X';
        int counter = 1;

        System.out.println("Podaj proszę numer pola...");

        for (int i = 0; i <9; i++){
            int userChoice = sc.nextInt();
            if (activePlayer == 'X'){
                board.setField(userChoice, 'X');
            }
            if (activePlayer == 'O'){
                board.setField(userChoice, 'O');
            }
            board.printBoard();
            counter++;
            if (counter % 2 == 0) {
                activePlayer = 'O';
                System.out.println("Teraz gracz O");
            }else {
                activePlayer = 'X';
                System.out.println("Teraz gracz X");
            }
        }
    }
}
