public class Board
{
    public static final String TEXT_RESET = "\u001B[0m";

    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED


    private final static int DEFUALT_MATRIX_SIZE = 3;
    private int counter = 0;


    public static void startBoard(char[][] board)
    {
        for (int i = 0; i < DEFUALT_MATRIX_SIZE; i++)
        {
            for (int j = 0; j < DEFUALT_MATRIX_SIZE; j++)
            {
                board[i][j] = '*';
            }
        }
    }

    public static void printBoard(char[][] board)
    {
        for (int i = 0; i < DEFUALT_MATRIX_SIZE; i++)
        {
            for (int j = 0; j < DEFUALT_MATRIX_SIZE; j++)
            {
                if(board[i][j] == 'X')
                    System.out.print(RED_BOLD_BRIGHT + board[i][j] + TEXT_RESET);
                else if(board[i][j] == 'O')
                    System.out.print(BLUE_BOLD_BRIGHT + board[i][j] + TEXT_RESET);
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public int getDEFUALT_MATRIX_SIZE()
    {
        return DEFUALT_MATRIX_SIZE;
    }
}