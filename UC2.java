import java.util.Scanner;

public class UC2 {
    static char playerSymbol;
    static char computerSymbol;
    static boolean isPlayerTurn;

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        toss();
        displayBoard(board);
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
        if (result == 0) {
            System.out.println("Toss won by: Player");
            playerSymbol = 'X';
            computerSymbol = 'O';
            isPlayerTurn = true;
        } else {
            System.out.println("Toss won by: Computer");
            playerSymbol = 'O';
            computerSymbol = 'X';
            isPlayerTurn = false;
        }
        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
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