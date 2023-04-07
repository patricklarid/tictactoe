import java.util.Scanner;

public class TicTacToe 
{
    // 2D array to represent the Tic Tac Toe board
    private char[][] board = new char[3][3];
    private char currentPlayer;
    
    // Initialize the board and start the game
    public void startGame()
        {
            // Fill the board with empty spaces
            for (int i = 0; i < 3; i++) 
                {
                    for (int j = 0; j < 3; j++) 
                        {
                            board[i][j] = ' ';
                        }
                }
            currentPlayer = 'X';
            playGame();
        }
    
    // Play the Tic Tac Toe game
    private void playGame() 
    {
        boolean gameEnded = false;
        printBoard();
        while (!gameEnded) 
        {
            System.out.println("It's " + currentPlayer + "'s turn. Enter row (1-3) and column (1-3):");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            if (row < 0 || col < 0 || row > 2 || col > 2){
            System.out.println("Invalid input, try again.");
            } else if (board[row][col] != ' ') {
            System.out.println("That spot is already taken, try again.");
            } else {
                    board[row][col] = currentPlayer;
                    printBoard();
                    if (checkWin()) 
                        {
                        System.out.println(currentPlayer + " wins!");
                        gameEnded = true;
                        } else if (checkDraw()) 
                                {
                                System.out.println("It's a draw!");
                                gameEnded = true;
                                } else  {
                                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                                        }
                    }
        }
    }
    
    // Print the Tic Tac Toe board
    private void printBoard() 
        {
            System.out.println("  1 2 3");
            for (int i = 0; i < 3; i++) 
                {
                    System.out.print((i + 1) + " ");
                    for (int j = 0; j < 3; j++) 
                        {
                            System.out.print(board[i][j] + " ");
                        }
                    System.out.println();
                }
        }
    
    // Check if the game has been won
    private boolean checkWin() 
    {
        // Check rows
        for (int i = 0; i < 3; i++) 
            {
                if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) 
                    {
                        return true;
                    }
            }
        // Check columns
        for (int i = 0; i < 3; i++) 
            {
                if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) 
                {
                    return true;
                }
            }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) 
            {
                return true;
            }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) 
            {
                return true;
            }
        return false;
    }
    
    // Check if the game is a draw
    private boolean checkDraw() 
        {
            for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++) 
                        {
                            if (board[i][j] == ' ') 
                                {
                                    return false;
                                }
                        }
                }
            return true;
        }
    
    // Main method to start the game
    public static void main(String[] args) 
    {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }
}