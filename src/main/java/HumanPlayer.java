public class HumanPlayer extends Player {
    public HumanPlayer(String nickName, char playerSign) {
        super(nickName, playerSign);
    }
@Override
    public int move(){
        System.out.println("Please enter appropriate number from keyboard...");
        int move = sc.nextInt();
        return move;
    }
}
