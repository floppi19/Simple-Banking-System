import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int arraySize = size * size;
        int[][] sudoku = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; ++i) {
            for (int j = 0; j < arraySize; ++j) {
                sudoku[i][j] = scan.nextInt();
            }
        }

        String valid = verifySudoku(sudoku, size);
        System.out.println(valid);

    }

    static String verifySudoku(int[][] sudoku, int size) {

        for (int number = 1; number <= sudoku.length; ++number) {
            if ("NO".equals(checkRowsAndColumns(sudoku, number))) {
                return "NO";
            }
            if ("NO".equals(checkSmallerSquares(sudoku, number, size))) {
                return "NO";
            }
        }
        return "YES";
    }

    static String checkRowsAndColumns(int[][] sudoku, int number) {

        int i = 0;
        while (i < sudoku.length) {
            int rowCounter = 0;
            int columnCounter = 0;
            int j = 0;
            while (j < sudoku.length) {

                if (number == sudoku[i][j]) {
                    ++rowCounter;

                }

                if (number == sudoku[j][i]) {
                    ++columnCounter;

                }
                ++j;
            }


            if (rowCounter != 1 || columnCounter != 1) {
                return "NO";
            }

            ++i;
        }
        return "YES";
    }

    static String checkSmallerSquares(int[][] sudoku, int number, int size) {

        for (int i = 0; i < sudoku.length; i += size) {

            for (int j = 0; j < sudoku.length; j += size) {
                int counter = 0;

                for (int m = j; m < j + size; ++m) {
                    for (int n = i; n < i + size; ++n) {

                        if (number == sudoku[n][m]) {
                            ++counter;
                        }

                        if (counter > 1) {
                            return "NO";
                        }
                    }
                }
                if (counter != 1) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}