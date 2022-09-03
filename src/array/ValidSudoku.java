package array;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextLine().charAt(0);
            }
        }

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] arr) {

        for (int i = 0; i < 9; i++) {
            boolean[] r = new boolean[9];
            boolean[] c = new boolean[9];

            for (int j = 0; j < 9; j++) {
                if (arr[i][j] != '.') {
                    if (r[arr[i][j] - '0' - 1]) {
                        return false;
                    }

                    r[arr[i][j] - '0' - 1] = true;
                }

                if (arr[j][i] != '.') {
                    if (c[arr[j][i] - '0' - 1]) {
                        return false;
                    }

                    c[arr[j][i] - '0' - 1] = true;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] m = new boolean[9];

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (arr[i + k][j + l] != '.') {
                            if (m[arr[i + k][j + l] - '0' - 1]) {
                                return false;
                            }

                            m[arr[i + k][j + l] - '0' - 1] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
