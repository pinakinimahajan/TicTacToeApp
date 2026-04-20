import java.util.Scanner;

public class UC4 {
    static char playerSymbol;
    static char computerSymbol;
    static boolean isPlayerTurn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        toss();
        displayBoard(board);
        
        if (isPlayerTurn) {
            int slot = getUserInput();
            int[] indices = convertToIndices(slot);
            System.out.println("Row: " + indices[0] + ", Column: " + indices[1]);
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
    }

    public static int getUserInput() {
        System.out.print("Enter a slot (1-9): ");
        return scanner.nextInt();
    }

    public static int[] convertToIndices(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
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