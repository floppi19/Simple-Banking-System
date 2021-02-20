import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arrayOfMax = new int[b - a + 1];
        int[] arrayOfSequence = new int[b - a + 1];

        int index = 0;
        for (int i = a; i <= b; i++) {
            arrayOfSequence[index] = i;
            Random random = new Random(i);
            int j = 0;
            int max = 0;
            while (j < n) {
                int randomnumber = random.nextInt(k);
                if (max < randomnumber) {
                    max = randomnumber;
                }
                j++;
            }
            arrayOfMax[index] = max;
            index++;
        }

        int min = arrayOfMax[0];
        int minIndex = 0;
        for (int i = 0; i < arrayOfMax.length; i++) {
            if (min > arrayOfMax[i]) {
                min = arrayOfMax[i];
                minIndex = i;
            }
        }

        System.out.println(arrayOfSequence[minIndex]);
        System.out.print(min);

    }
}