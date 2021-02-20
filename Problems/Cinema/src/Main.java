import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int rows = scanner.nextInt();
        int column = scanner.nextInt();
        int freeSeats = 0;
        int[][] seats = new int[rows][column];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }
        int emptySeats = scanner.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (seats[i][j] == 0) {
                    count++;
                    if (count == emptySeats) {
                        freeSeats = i + 1;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
            if (freeSeats > 0) {
                break;
            }
        }
        System.out.println(freeSeats);

    }
}