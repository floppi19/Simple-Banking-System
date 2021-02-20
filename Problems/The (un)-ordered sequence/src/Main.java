import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            int checkNumber = scanner.nextInt();
            if (checkNumber == 0) {
                break;
            } else {
                numbers.add(checkNumber);
            }
        }
        List<Integer> checkList = new ArrayList<>(numbers);
        Collections.sort(checkList);
        List<Integer> reversedList = new ArrayList<>(checkList);
        Collections.reverse(reversedList);

        if (numbers.equals(checkList) || numbers.equals(reversedList)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}