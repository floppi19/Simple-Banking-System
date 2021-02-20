import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int boy1 = scanner.nextInt();
        int boy2 = scanner.nextInt();
        int boy3 = scanner.nextInt();

        if (boy1 >= boy2 && boy2 >= boy3) {
            System.out.println("true");
        } else if (boy1 <= boy2 && boy2 <= boy3) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}