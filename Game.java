import java.util.Scanner;

public class Game
{
    public static final String TEXT_RESET = "\u001B[0m"; // DEFAULT COLOR

    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED


    private boolean flagToCheckWinner;
    private static int counter = 0;

    public void makeTurn(char[][] matrix)
    {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player player = new Player();


        for(int i=1; i<=(int) Math.pow(board.getDEFUALT_MATRIX_SIZE(), 2) && flagToCheckWinner == false; i++)
        {
            this.counter++;
            char flagToPlayer = player.currentPlayer(this.counter);
            if(flagToPlayer == 'X')
                System.out.println("The turn of " + RED_BOLD_BRIGHT + player.currentPlayer(this.counter) + TEXT_RESET);
            else if(flagToPlayer == 'O')
                System.out.println("The turn of " + BLUE_BOLD_BRIGHT + player.currentPlayer(this.counter) + TEXT_RESET);

            System.out.println("Enter coordinates you want like this: row,column: ");

            String coordinates;
            coordinates = scanner.nextLine();

            String[] coordinatesVector; //string array for split function
            coordinatesVector = coordinates.split(",");

            if(coordinatesVector.length == 2 &&
                    Character.isDigit(coordinatesVector[0].charAt(0)) && Character.isDigit(coordinatesVector[1].charAt(0))) //check input is only 2 characters(and digits)
            {
                int coordinatesRows = Integer.parseInt(coordinatesVector[0]);
                int coordinatesColumns = Integer.parseInt(coordinatesVector[1]);

                if((coordinatesRows <= 3 && coordinatesRows >= 1) && (coordinatesColumns <= 3 && coordinatesColumns >= 1)
                        && (matrix[coordinatesRows - 1][coordinatesColumns - 1] == '*'))
                {
                    matrix[coordinatesRows - 1][coordinatesColumns - 1] = player.currentPlayer(this.counter);
                    Board.printBoard(matrix);

                    checkRowForWinner(matrix);
                    checkColumnsForWinner(matrix);
                    checkDiagonalWinner(matrix);
                    checkDraw(matrix);

                    if (flagToCheckWinner == true)
                    {
                        System.out.println("The game is finish");
                        break;
                    }
                }
                else
                {
                    System.out.println("ERROR!!! Coordinate fail... Try again...\n");
                    this.counter--;
                }
            }

            else
            {
                System.out.println("ERROR!!! Coordinate fail... Try again...\n");
                this.counter--;
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////

    private boolean checkRowCol(char c1, char c2, char c3)
    {
        return ((c1 != '*') && (c1 == c2) && (c2 == c3));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean checkColumnsForWinner(char[][] matrix)
    {
        Board board = new Board();
        Player player = new Player();

        for (int i = 0; i < board.getDEFUALT_MATRIX_SIZE(); i++)
        {
            if (checkRowCol(matrix[0][i], matrix[1][i], matrix[2][i]) == true)
            {
                flagToCheckWinner = true;
                char winnerPlayer = player.currentPlayer(this.counter);

                if(winnerPlayer == 'X')
                    System.out.println("The winner is........ " + RED_BOLD_BRIGHT +winnerPlayer + TEXT_RESET);
                else if(winnerPlayer == 'O')
                    System.out.println("The winner is........ " + BLUE_BOLD_BRIGHT +winnerPlayer + TEXT_RESET);

                System.out.println("The game is over. Thanks for playing");
                break;
            }
        }
        return flagToCheckWinner;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    public boolean checkRowForWinner(char[][] matrix)
    {
        Board board = new Board();
        Player player = new Player();

        for (int i = 0; i < board.getDEFUALT_MATRIX_SIZE(); i++)
        {
            if (checkRowCol(matrix[i][0], matrix[i][1], matrix[i][2]) == true)
            {
                flagToCheckWinner = true;
                char winnerPlayer = player.currentPlayer(this.counter);

                if(winnerPlayer == 'X')
                    System.out.println("The winner is........ " + RED_BOLD_BRIGHT +winnerPlayer + TEXT_RESET);
                else if(winnerPlayer == 'O')
                    System.out.println("The winner is........ " + BLUE_BOLD_BRIGHT +winnerPlayer + TEXT_RESET);

                System.out.println("The game is over. Thanks for playing");
                break;
            }
        }
        return flagToCheckWinner;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean checkDiagonalWinner(char[][] matrix)
    {
        Board board = new Board();
        Player player = new Player();

        for (int i = 0; i < board.getDEFUALT_MATRIX_SIZE(); i++) {
            if (checkRowCol(matrix[0][0], matrix[1][1], matrix[2][2]) == true ||
                    checkRowCol(matrix[0][2], matrix[1][1], matrix[2][0]) == true)
            {
                flagToCheckWinner = true;
                char winnerPlayer = player.currentPlayer(this.counter);

                if(winnerPlayer == 'X')
                    System.out.println("The winner is........ " + RED_BOLD_BRIGHT +winnerPlayer + TEXT_RESET);
                else if(winnerPlayer == 'O')
                    System.out.println("The winner is........ " + BLUE_BOLD_BRIGHT +winnerPlayer + TEXT_RESET);

                System.out.println("The game is over. Thanks for playing");
                break;
            }
        }
        return flagToCheckWinner;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean checkDraw(char[][] matrix)
    {
        if(counter == 9 && checkRowForWinner(matrix) == false && checkColumnsForWinner(matrix) == false)
        {
            System.out.println("Its a DRAW!!!");
            System.out.println("The game is over. Thanks for playing");
            flagToCheckWinner = true;
        }
        return flagToCheckWinner;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean isFlagToCheckWinner()
    {
        return flagToCheckWinner;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getCounter()
    {
        return counter;
    }
}