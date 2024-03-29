import java.util.Scanner;

public class SafeInput {

    //Part A getNonZeroLenString
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        //declaring variables
        String retString = ""; //Set this to zero length. Loops until it isn't
        //do while loop to safely input a nonzero length string
        do
        {
            System.out.print("\n" + prompt + ": "); //show prompt add space
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }

    //Part B getInt
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an integer and not a double nor string
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        //declaring variables
        int retVal = 0;
        String trash = "";
        boolean done = false;

        //do while loop and if else structure to get a safe input of an integer and not something else
        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while(!done);

        //return the value of the input from the scanner
        return retVal;
    }

    //Part C getDouble
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        //declaring variables
        double retVal = 0;
        String trash = "";
        boolean done = false;

        // do while loop and if else structure for safe read in of a double from scanner
        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while(!done);

        //return the value of the double
        return retVal;
    }

    //Part D getRangedInt
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low sets low of the integer range
     * @param high sets high of the integer range
     * @return an integer within specified range from low and high param
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        //declaring variables
        int retVal = 0;
        String trash = "";
        boolean done = false;

        //do while loop and nested if else structure to safely read in and validate integer is in range
        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " +retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while(!done);

        //return integer within range
        return retVal;
    }

    //Part E getRangedDouble
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low sets low end of double range
     * @param high sets high end of double range
     * @return a double that is within range set by low and high param
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        //declaring variables
        double retVal = 0;
        String trash = "";
        boolean done = false;

        //do while and nested if else structure to safely read in and validate a double within set range
        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high +"]: ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: ");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while(!done);

        //return value of the double within range
        return retVal;
    }

    //Part F getYNConfirm
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a boolean value that confirms a Y answer to end loop
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        //declaring variables
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        //do while loop and if else if structure that prompts user for a Y/N answer, reads in their answer, and ends loop if Y
        //if N it lets user loop back to do process again
        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                retVal = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answer [Y/N] " + response );
            }
        } while(!gotAVal);

        //returns boolean as true to end method
        return retVal;
    }

    //Part G getRegExString
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regExPattern that allows user to set a regExPattern that must be matched in input
     * @return a String response that matches the regExPattern inputted
     */

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        //declaring variables
        String response = "";
        boolean gotAVal = false;

        //do while loop and if else structure that reads in string input and makes it match regExPattern
        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regExPattern))
            {
                gotAVal = true;
            }
            else
            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);;
                System.out.println("Try again!");
            }
        } while(!gotAVal);

        //returns the string response so long as regExPattern is matched in the above loop
        return response;
    }

    //Part H Pretty Header
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return msg a String response that will be the centered pretty header
     */

    public static String prettyHeader(Scanner pipe, String prompt){

        //declaring some variables
        String msg = "";
        int CHAR_COUNT = 60;
        int totalSpaces = 0;
        int leftSpace = 0;
        int rightSpace = 0;



        // do while loop to make message able to be scanned in from user input
        do{
            System.out.print("\n" + prompt + ": ");
            msg = pipe.nextLine();
        } while (msg.length() == totalSpaces);


        totalSpaces = CHAR_COUNT - 6 - msg.length();

        //if else structure to center header based on if it is even or odd
        if(totalSpaces % 2 == 0){
            leftSpace = rightSpace = totalSpaces / 2;
        }
        else {
            rightSpace = totalSpaces / 2;
            leftSpace = rightSpace + 1;
        }

        //this creates the display for top, center, and bottom rows
        for(int row = 1; row <= CHAR_COUNT; row ++){
            System.out.print("*");
        }
        System.out.println();
        //centered msg in middle row
        for(int row = 1; row <= 1; row ++){
            System.out.print("***");
        }
        for(int row = 1; row <= leftSpace; row ++){
            System.out.print(" ");
        }
        for(int row = 1; row <= 1; row ++){
            System.out.print(msg);
        }
        for(int row = 1; row <= rightSpace; row ++){
            System.out.print(" ");
        }
        for(int row = 1; row <= 1; row ++){
            System.out.print("***");
        }
        System.out.println();
        //bottom row
        for(int row = 1; row <= CHAR_COUNT; row ++){
            System.out.print("*");
        }

        return msg;
    }
}
