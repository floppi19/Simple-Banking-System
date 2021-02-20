import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String myString = scanner.nextLine();
        if (myString.length() < 4) {
            System.out.println("false");
        } else {
            if (myString.substring(myString.length() - 4).equals("burg")) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}