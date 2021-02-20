package banking;

import java.util.Scanner;

public class AccountController {
    private static boolean isLogged = false;
    private static Account currentUser = null;
    private AccountRepository accountRepository = new AccountRepository();
    private AccountService accountService = new AccountService();

    public void start() {
        while (true) {
            showMenu();
            callMethods(readOption());
        }
    }

    private void showMenu() {

        if (currentUser == null) {
            System.out.println("1. Create an account\n" +
                    "2. Log into account\n" +
                    "0. Exit");
        } else {
            System.out.println();
            System.out.println("1. Balance\n" +
                    "2. Add income\n" +
                    "3. Do transfer\n" +
                    "4. Close account\n" +
                    "5. Log out\n" +
                    "0. Exit");
        }
    }

    private int readOption() {
        System.out.print("> ");
        int opt = 0;
        try {
            opt = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Invalid option. ");
        }
        return opt;
    }

    private void callMethods(int opt) {
        if (currentUser == null) {
            switch (opt) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    logIn();
                    break;
                case 0:
                    exitApplication();
                default:
                    System.out.println("Invalid option");
            }
        } else {
            switch (opt) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    addBalance();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    logOut();
                    break;
                case 0:
                    exitApplication();
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void createAccount() {
        new AccountService().generateAccount();
    }

    private void logIn() {

        System.out.print("Enter your card number:\n> ");
        String cardNumber = new Scanner(System.in).next();
        System.out.print("Enter your PIN:\n> ");
        String PIN = new Scanner(System.in).next();
        Account user = new Account(cardNumber, PIN);
        if (accountRepository.getAllCustomer().contains(user)) {
            currentUser = accountRepository.getAllCustomer().get(accountRepository.getAllCustomer().indexOf(user));
            System.out.println("You have successfully logged in!");
        } else {
            currentUser = null;
            System.out.println("Wrong card number or PIN!");
        }

    }

    private void exitApplication() {
        System.out.println("\nBye!\n");
        System.exit(0);
    }

    private void showBalance() {
        System.out.println("Balance: " + currentUser.getBalance());
    }

    private void addBalance() {
        System.out.print("Enter income:\n> ");
        int balanceToAdd = new Scanner(System.in).nextInt();
        accountRepository.addBalance(currentUser.getNumber(), balanceToAdd);
        Account user = new Account(currentUser.getNumber(), currentUser.getPin());
        if (accountRepository.getAllCustomer().contains(user)) {
            currentUser = accountRepository.getAllCustomer().get(accountRepository.getAllCustomer().indexOf(user));
            System.out.println("Income was added!!");
        }
    }

    private void transfer() {
        System.out.println("Transfer");
        System.out.print("Enter card number:\n> ");
        String friendCard = new Scanner(System.in).next();
        char lastChar = friendCard.charAt(friendCard.length() - 1);
        String checkCard = friendCard.substring(0, friendCard.length() - 1);
        int lastDigit = Integer.parseInt(String.valueOf(lastChar));
        Account friendUser = new Account(friendCard);

        try {
            if (lastDigit != accountService.luhnChecksum(checkCard)) {
                System.out.println("Probably you made a mistake in the card number. Please try again!");
            } else if (friendUser.getNumber().equals(currentUser.getNumber())) {
                System.out.println("You can't transfer money to the same account!");
            } else if (accountRepository.getAllCustNumbers().contains(friendUser)) {
                System.out.print("Enter how much money you want to transfer:\n> ");

                int balanceChange = new Scanner(System.in).nextInt();
                if (currentUser.getBalance() < balanceChange) {
                    System.out.println("Not enough money!");
                } else {
                    accountRepository.substractBalance(currentUser.getNumber(), balanceChange);
                    accountRepository.addBalance(friendUser.getNumber(), balanceChange);
                    Account user = new Account(currentUser.getNumber(), currentUser.getPin());
                    if (accountRepository.getAllCustomer().contains(user)) {
                        currentUser = accountRepository.getAllCustomer().get(accountRepository.getAllCustomer().indexOf(user));
                        System.out.println("Success!");
                    }

                }
            } else {
                System.out.println("Such a card does not exist.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void deleteAccount() {
        accountRepository.deleteAccount(currentUser.getNumber());
        currentUser = null;
        System.out.println("The account has been closed!");
    }

    private void logOut() {
        currentUser = null;
    }

}
