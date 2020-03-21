import java.util.Random;

public class CpuPlayer extends Player {
    Random rnd = new Random();

    public CpuPlayer(String nickName, char playerSign) {
        super(nickName, playerSign);
    }
    @Override
    public int move(){
        System.out.println("Please enter appropriate number from keyboard...");
        int move = rnd.nextInt(9);
        return move;
    }
}
