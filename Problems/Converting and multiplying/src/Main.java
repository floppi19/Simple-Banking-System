import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String myString = scanner.next();
            try {
                int number = Integer.parseInt(myString) * 10;
                if (number == 0) {
                    break;
                }
                System.out.println(number);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + myString);
            }

        }

    }
}