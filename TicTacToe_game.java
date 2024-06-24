import java.util.*;
public class TicTacToe_game {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col]=' ';
            }
        }
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" enter: ");
            int row = sc.nextInt();
            int col  = sc.nextInt();
            System.out.println();
            if(board[row][col]==' '){
                board[row][col] = player;  //place the element
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println("Player "+player+" has won");
                }
                else{
                    if(player=='X'){
                        player ='O';
                    }
                    else{
                        player = 'X';
                    }
                }
            }
            else{
                System.out.println("Invalid move..Try again");
            }
        }
        printBoard(board);
    }
    public static boolean haveWon(char[][] board,char player){
        //check rows
        for(int row=0;row<board.length;row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player ){
                return true;
            }
        }
        //check for column
        for(int col=0;col<board.length;col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player ){
                return true;
            }
        }
        //check for diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player ){
            return true;
        }
        if(board[2][0] == player && board[1][1] == player && board[0][2] == player ){
            return true;
        }
        return false;
    }
    public static void printBoard(char[][] board){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
