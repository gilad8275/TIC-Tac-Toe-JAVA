public class Player
{
    private char player1 = 'X';
    private char player2 = 'O';

    public char currentPlayer(int i)
    {
        Board board = new Board();
        Game game = new Game();
        char currentPlayer = 0;
        i = game.getCounter();

        if(i % 2 == 1)
            currentPlayer = player1;
        else if(i % 2 == 0)
            currentPlayer = player2;

        return currentPlayer;
    }
}