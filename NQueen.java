//import java.util.Scanner;
public class NQueen {
    // static Scanner in = new Scanner(System.in);
    // static int n = in.nextInt();
    static final int n = 4;
    static boolean board[][] = new boolean[n][n];

    static boolean canIPlaceAQueen(int row, int col) {
        //chech in above row
        for (int i = row; i >= 0; i--) {
            if (board[i][col]) {
                return false;
            }
        }
        //check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        //check right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

    static int countways(int row) {
        int count = 0;
        if (row == board.length) {
            return 1;
        }
        for (int col = 0; col < n; col++) {
            if (canIPlaceAQueen(row, col)) {
                board[row][col] = true;// queen palced
                // countways(row+1);
                count = count + countways(row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countways(0);
        System.out.println(count);
    }
}
