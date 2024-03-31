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

        //declaring variables
        Scanner in = new Scanner(System.in);
        //Need to figure out how to get appropriate symbols to display***
        String player = "";
        String playerX = "X";
        String playerO = "O";
        int row = 0;
        int col = 0;
        int moveCnt = 0;
        boolean done = false;
        boolean continueYN;
        String trash = "";

        //do while loop for the whole game
        do
        {
            clearBoard();
            moveCnt = 0;
            player = playerX;

            //do while loop to start game
            do
            {
                //do while loop for valid move
                do
                {
                    System.out.println("Player " + player + "'s turn!");
                    display(); // displaying board

                    row = SafeInput.getRangedInt(in, "Pick a row", 1, 3);
                    row = row - 1;
                    col = SafeInput.getRangedInt(in, "Pick a column", 1, 3);
                    col = col - 1;

                    if (isValidMove(row, col))
                    {
                        done = true;
                    }
                    else
                    {
                        System.out.println("Please enter a valid move!");
                    }

                    //NEED TO GET APPROPRIATE SYMBOLS TO DISPLAY
                    if (player == playerX)
                    {
                        player = playerO;
                    } else if (player == playerO) {
                        player = playerX;
                    }

                } while (!done);

                done = false;

                System.out.println();
                System.out.println("Current Board");
                board[row][col] = player;
                display();
                System.out.println();

                moveCnt = moveCnt + 1;

                if(moveCnt >= 5){
                    isWin(player);
                    if(isWin(player)){
                        System.out.println("Player " + player + " wins!");
                        done = true;
                    } //WHAT TO PUT HERE?
                }


            } while (!done);

            continueYN = SafeInput.getYNConfirm(in, "Do you want to play again?");
        } while(continueYN);
    }

    //Helper methods for the TicTacToe game

    //setting all board elements to a space
    private static void clearBoard()
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
                System.out.print(board[row][col] + " | ");
            }
            System.out.println(" ");
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
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }

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
    private static boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
        {
            return true;
        }
        else
            return false; // no diagonal win
    }


    private static boolean isTie(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {

            }
        }
        return false; //no tie yet
    }




}