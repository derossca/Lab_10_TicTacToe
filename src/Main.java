//importing scanner
import java.util.Scanner;

public class Main {
    //declaring board array and the constants that define it
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];
    public static void main(String[] args)
    {
        //pseudo code


    }

    //Helper methods for the TicTacToe game
    private static void clearBoard() //setting all board elements to a space
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " "; //makes this cell a space
            }
        }
    }

    //shows the Tic Tac Toe game used as part of the prompt for the users move choice
    private static void display()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " _|_ ";
                System.out.print(board);
            }
            System.out.println();
        }
    }

    //returns true if there is a space at the given proposed move coordinates which means it is a legal move
    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" "); //only returns true if the cell is a space
    }

    //checking to see if there is a win state for the specified player (X or O)
    private static boolean isWin(String player)
    {
        //checking for a col win
        private static boolean isColWin(String player)
        {
            for(int col = 0; col < COL; col++)
            {
                if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
                {
                    return true;
                }
            }
            return false; // no col win
        }

        //checking for a row win
        private static boolean isRowWin(String player)
        {
            for(int row = 0; row < ROW; row++)
            {
                if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
                {
                    return true;
                }
            }
            return false; // no row win
        }

        //checks for a diagonal win
        private static boolean isDiagonalWin(String player)
        {
            if((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)))
            {
                return true;
            }
            return false; // no diagonal win
        }

        /*checks for a tie
        private static boolean isTie()
        {

        }

         */

        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
}