public class CpuPlayer extends Player {
    public CpuPlayer(String nickName, char playerSign) {
        super(nickName, playerSign);
    }

    @Override
    public int move() {
        return 0;
    }
}
