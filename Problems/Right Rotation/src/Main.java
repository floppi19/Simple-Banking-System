import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int number = scanner.nextInt();
        List<String> stringList = new ArrayList<>(Arrays.asList(array));
        Collections.rotate(stringList, number);
        for (String numbers : stringList) {
            System.out.print(numbers + " ");
        }
    }
}