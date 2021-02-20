import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            } else if (number % 2 != 0) {
                System.out.println("odd");
            } else {
                System.out.println("even");
            }
        }

    }
}