import java.util.Arrays;

public class Board {

   void setField(int userChoice, char[][]board, char value){
        if(userChoice == 1){
            board[0][0] = value;
        }
       if(userChoice == 2){
           board[0][1] = value;
       }
       if(userChoice == 3){
           board[0][2] = value;
       }
       if(userChoice == 4){
           board[1][0] = value;
       }
       if(userChoice == 5){
           board[1][1] = value;
       }
       if(userChoice == 6){
           board[1][2] = value;
       }
       if(userChoice == 7){
           board[2][0] = value;
       }
       if(userChoice == 8){
           board[2][1] = value;
       }
       if(userChoice == 9){
           board[2][2] = value;
       }
    }

    public static void main(String[] args) {

       Board bd = new Board();
        int boardDimension = 3;
        char [][] board = new char[boardDimension][boardDimension];

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
        System.out.println(bd.setField(5, board, 'o'));
    }
}
