import java.util.Arrays;

public class Board {
    public static void main(String[] args) {

        int boardDimension = 3;
        char board[][] = new char[boardDimension][boardDimension];

        board[0][0] = '1';
        board[0][1] = '2';
        board[0][2] = '3';
        board[1][0] = '4';
        board[1][1] = '5';
        board[1][2] = '6';
        board[2][0] = '7';
        board[2][1] = '8';
        board[2][2] = '9';

        for (int i = 0; i < board.length; i++) {
            System.out.println("=======");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
