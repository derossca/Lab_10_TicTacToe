//importing scanner
import java.util.Scanner;

public class Main {
    //declaring board array and the constants that define it to make it a 3x3 2-D board
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];
    public static void main(String[] args)
    {
        //pseudo code

        //declaring variables
        Scanner in = new Scanner(System.in);
        //made string player, playerX, and playerO to be able to set the player to X at beginning of game and toggle at end of each move
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
            //here use a method to clear the board, then set move count to 0 and set the player to X at beginning of each game
            clearBoard();
            moveCnt = 0;
            player = playerX;

            //do while loop to play game
            do
            {
                //do while loop for valid move
                do
                {
                    //tells which player's turn it is at beginning of each move and displays the board
                    System.out.println("Player " + player + "'s turn!");
                    display(); // displaying board

                    //getting coordinates input from the current player
                    row = SafeInput.getRangedInt(in, "Pick a row", 1, 3);
                    row = row - 1;
                    col = SafeInput.getRangedInt(in, "Pick a column", 1, 3);
                    col = col - 1;

                    //check for a valid move to bulletproof program, if the move is invalid it tells player that
                    if (isValidMove(row, col))
                    {
                        done = true; //if move is valid, done with a method, then game will do the following code below
                    }
                    else
                    {
                        System.out.println("Please enter a valid move!");
                    }

                } while (!done);

                //resetting boolean sentinel
                done = false;

                System.out.println(); //creating space with a blank line
                System.out.println("Current Board"); //output telling player what follows is a display of the current board and all the moves
                board[row][col] = player; //this stores the player's move

                display(); //displays the current board and all it's moves
                System.out.println(); //creating space with blank line

                moveCnt = moveCnt + 1; //counts and increments the moves of the game

                //here if the move count is greater than 5, then we use an if, else if condition to test if the player won, and display if true, and same for a tie
                if(moveCnt >= 5){
                    isWin(player);
                    if(isWin(player)){
                        System.out.println("Player " + player + " wins!");
                        done = true; // game continues until there is a winner
                    } else if (isTie()) {
                        System.out.println("It's a tie!");
                        done = true; //game continues unless there is a tie
                    }

                }
                //this is to toggle between playerX and playerO for their respective moves in the game
                if (player == playerX)
                {
                    player = playerO;
                } else if (player == playerO) {
                    player = playerX;
                }

            } while (!done);

            //once the round is done, this prompts the player to play again, if Y then game starts over, if not it ends the program
            continueYN = SafeInput.getYNConfirm(in, "Do you want to play again?");
        } while(continueYN);
    }

    //Helper methods for the TicTacToe game

    //setting all board elements to a space so the game starts with a cleared board
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
                System.out.print(board[row][col] + " | "); //prints out a | to try to make the board a little more visual
            }
            System.out.println(" "); //keeps the rows as a space, and makes sure the 3x3 display functions properly
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
            return true; //if any of the conditions met above then appropriate player wins and ends game
        }
        return false; //if no winner game continues as return is false
    }

    //checking for a col win
    private static boolean isColWin(String player)
    {
        //this iterates through the columns to check for a player with 3 in a row to determine winner, returns true and
        // ends game if a player wins, continues game if not
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
        //iterates through rows to check for a player with 3 in a row for a win condition
        //returns true and ends game if there is a winner, returns false if no winner and game continues
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
        //Using if, else if, else structure to check through every scenario to see if a player can win diagonally
        //returns true and ends game if player gets 3 diagonally, continues game if not
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

    //checks for a tie condition
    private static boolean isTie()
    {
        //variable used to check for a tie
        int tieCnt = 0;

        //iterates through the rows and uses a nested if structure to check if there is a mix of X's and O's, which
        //would result in incrementing the tieCnt
        for (int row = 0; row < ROW; row ++)
        {
            if (board[row][0].equals("X") || board[row][1].equals("X") || board[row][2].equals("X"))
            {
                if (board[row][0].equals("O") || board[row][1].equals("O") || board[row][2].equals("O"))
                {
                    tieCnt++;
                }
            }
        }

        //iterates through the columns checking for a mix of X's and O's and eliminating column vectors as possible wins
        //increments tieCnt for every vector eliminated
        for (int col = 0; col < COL; col ++)
        {
            if (board[0][col].equals("X") || board[1][col].equals("X") || board[2][col].equals("X"))
            {
                if (board[0][col].equals("O") || board[1][col].equals("O") || board[2][col].equals("O"))
                {
                    tieCnt++;
                }
            }
        }

        //this checks for a diagonal tie, eliminates vector and increments tieCnt if there is a mix of X's and O's
        if (board[0][0].equals("X") || board[1][1].equals("X") || board [2][2].equals("X"))
        {
            if (board[0][0].equals("O") || board[1][1].equals("O") || board [2][2].equals("O")){
                tieCnt++;
            }
        }

        //this is the other diagonal tie condition that eliminates a vector with mixed symobls and increments tieCnt
        if (board[2][0].equals("X") || board[1][1].equals("X") || board [0][2].equals("X"))
        {
            if (board[2][0].equals("O") || board[1][1].equals("O") || board [0][2].equals("O")){
                tieCnt++;
            }
        }

        //if the tieCnt from all the eliminated vectors above equals 8, and thus 9 as a byproduct, then there is a
        //tie, if not, boolean returns false and game continues
        if (tieCnt == 8){
            return true;
        } else {
            return false;
        }
    }




}