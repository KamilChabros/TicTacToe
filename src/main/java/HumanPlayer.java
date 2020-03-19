import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner sc = new Scanner(System.in);

            System.out.println("Choose sign for First Player...(X, O, etc.)");

        System.out.println("Provide nick for First Player: ");

    // First Player

        System.out.println("Choose sign for Second Player...(X, O, etc.)");
    char secondSign = sc.next().charAt(0);
        System.out.println("Provide nick for Second Player: ");
    String secondPLayerNickName = sc.next();
    // Second Player
    // to-do Checking if first player has the same sign as second player

        System.out.println("First Player is: " + firstPLayerNickName + " and has " + firstSign + " sign.");
        System.out.println("Second Player is: " + secondPLayerNickName + " and has " + secondSign + " sign.");
}
