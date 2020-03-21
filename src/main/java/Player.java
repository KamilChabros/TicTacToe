import java.util.Scanner;

public class Player {

    Scanner sc = new Scanner(System.in);

   int move(){
       return 0;
   }

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
