import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number = scanner.nextInt();
        String myString = "";
        if (number % 10 == 0) {
            number /= 10;
        }
        while (number != 0) {
            myString += number % 10;
            number /= 10;
        }
        System.out.println(myString);
    }
}