import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[][] myArray = new int[number][number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                myArray[i][j] = Math.abs(i - j);
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }


    }
}