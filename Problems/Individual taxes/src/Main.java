import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int companyNumbers = scanner.nextInt();
        double[] incomes = new double[companyNumbers];
        double[] taxes = new double[companyNumbers];
        double paidTaxes = Integer.MIN_VALUE;
        double percent = 0;
        int count = 0;

        for (int i = 0; i < companyNumbers; i++) {
            incomes[i] = scanner.nextInt();
        }
        for (int j = 0; j < companyNumbers; j++) {
            taxes[j] = scanner.nextInt();
        }
        for (int k = 0; k < companyNumbers; k++) {
            percent = incomes[k] * taxes[k] / 100;

            if (percent > paidTaxes) {
                paidTaxes = percent;
                count = k + 1;
            }
        }
        System.out.println(count);
    }
}