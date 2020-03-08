import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        Scanner sc = new Scanner(System.in);
        char current = 'X';
        char current2 = 'O';

        System.out.println("Podaj proszę numer pola...");
        for (int i = 0; i <9; i++){
            int userChoice = sc.nextInt();
            if (current == 'X'){
                board.setField(userChoice, 'X');
            } else if (current2 == 'O'){
                board.setField(userChoice, 'O');
            }
            board.printBoard();
        }
    }
}
