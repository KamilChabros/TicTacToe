import java.util.Scanner;

public abstract class Player {

    Scanner sc = new Scanner(System.in);

    public abstract int move();

    private String nickName;
    private char playerSign;

    public Player(String nickName, char playerSign) {
        System.out.println("Please enter your nick: ");
        this.nickName = sc.next();
        System.out.println("Please choose your sign to play");
        this.playerSign = sc.next().charAt(0);
    }

    public String getNickName(){
        return nickName;
    }
    public char getPlayerSign(){
        return playerSign;
    }
}
