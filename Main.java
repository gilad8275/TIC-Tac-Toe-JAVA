public class Main
{
    public static void main(String[] args)
    {
        Board board = new Board();
        Game game = new Game();
        Player player = new Player();

        char matrix[][] = new char[board.getDEFUALT_MATRIX_SIZE()][board.getDEFUALT_MATRIX_SIZE()];
        Board.startBoard(matrix);
        Board.printBoard(matrix);
        for(int i=1; i<Math.pow(board.getDEFUALT_MATRIX_SIZE(), 2) && game.isFlagToCheckWinner() == false; i++)
        {
            game.makeTurn(matrix);
        }
    }
}