package banking;

import java.util.Random;

public class AccountService {
    AccountRepository accountRepository = new AccountRepository();


    public void generateAccount() {
        String cardNumber = "400000";
        cardNumber += getUniqueAccountIdentifier();
        String pin = generatePIN();
        try {
            cardNumber += luhnChecksum(cardNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        accountRepository.insert(cardNumber, pin);
        System.out.println("Your card has been created\n" +
                "Your card number:\n" +
                cardNumber +
                "\nYour card PIN:\n" +
                pin);
    }



    private String getUniqueAccountIdentifier() {
        Random random = new Random();
        String accountIdentifier = "";

        do {
            accountIdentifier += random.nextInt(999 - 101) + 100;
            accountIdentifier += random.nextInt(999 - 101) + 100;
            accountIdentifier += random.nextInt(999 - 101) + 100;
        } while (accountIdentifier.length() != 9);
        return accountIdentifier;
    }

    private String generatePIN() {
        return "" + (new Random().nextInt(9999 - 1001) + 1000);
    }

    public int luhnChecksum(String incompleteCardNumber) throws Exception {
        int[] digits = new int[15];
        int sum = 0;
        int checkSum = 0;

        if (incompleteCardNumber.length() != 15) {
            throw new Exception("Incompatible cardNumber length. Length should be 15. Your length: " + incompleteCardNumber.length());
        }

        //0. Get digits from incompleteCardNumber
        for (int i = 0; i < incompleteCardNumber.length(); i++) {
            digits[i] = Integer.parseInt(String.valueOf(incompleteCardNumber.charAt(i)));
        }

        //2. Multiply Odd digits by 2
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                digits[i] = digits[i] * 2;
            }
        }

        //3. Substract 9 to numbers over 9
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 9) {
                digits[i] = digits[i] - 9;
            }
        }

        //4. Add all numbers
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }

        //5. Divide by 10
        if (sum % 10 == 0) {
            checkSum = 0;
        } else {
            checkSum = 10 - (sum % 10);
        }

        return checkSum;
    }
}
