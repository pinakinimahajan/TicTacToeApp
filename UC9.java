import java.util.Scanner;

public class UC9 {
    static char playerSymbol;
    static char computerSymbol;
    static boolean isPlayerTurn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        toss();
        displayBoard(board);
        
        boolean gameRunning = true;
        while (gameRunning) {
            char currentSymbol = isPlayerTurn ? playerSymbol : computerSymbol;
            
            if (isPlayerTurn) {
                int slot = getUserInput();
                int[] indices = convertToIndices(slot);
                if (isValidMove(board, indices[0], indices[1])) {
                    makeMove(board, indices[0], indices[1], playerSymbol);
                } else {
                    System.out.println("Invalid move, try again.");
                    continue;
                }
            } else {
                makeComputerMove(board);
            }

            displayBoard(board);

            if (checkWin(board, currentSymbol)) {
                System.out.println((isPlayerTurn ? "Player" : "Computer") + " wins!");
                gameRunning = false;
            } else if (isBoardFull(board)) {
                System.out.println("It's a draw!");
                gameRunning = false;
            } else {
                isPlayerTurn = !isPlayerTurn;
            }
        }
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void toss() {
        int result = (int) (Math.random() * 2);
        playerSymbol = (result == 0) ? 'X' : 'O';
        computerSymbol = (playerSymbol == 'X') ? 'O' : 'X';
        isPlayerTurn = (result == 0);
        System.out.println((isPlayerTurn ? "Player" : "Computer") + " starts first.");
    }

    public static int getUserInput() {
        System.out.print("Enter a slot (1-9): ");
        return scanner.nextInt();
    }

    public static int[] convertToIndices(int slot) {
        return new int[]{(slot - 1) / 3, (slot - 1) % 3};
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    public static void makeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public static void makeComputerMove(char[][] board) {
        boolean moved = false;
        while (!moved) {
            int slot = (int) (Math.random() * 9) + 1;
            int[] indices = convertToIndices(slot);
            if (isValidMove(board, indices[0], indices[1])) {
                makeMove(board, indices[0], indices[1], computerSymbol);
                System.out.println("Computer placed " + computerSymbol + " in slot " + slot);
                moved = true;
            }
        }
    }

    public static boolean checkWin(char[][] board, char s) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == s && board[i][1] == s && board[i][2] == s) return true;
            if (board[0][i] == s && board[1][i] == s && board[2][i] == s) return true;
        }
        if (board[0][0] == s && board[1][1] == s && board[2][2] == s) return true;
        if (board[0][2] == s && board[1][1] == s && board[2][0] == s) return true;
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    public static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}