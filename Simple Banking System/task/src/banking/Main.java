package banking;

public class Main {
    private static String savedArgs;

    public static String getSavedArgs() {
        return savedArgs;
    }

    public static void main(String[] args) {
        savedArgs = args[1];
        new AccountRepository().connect();
        new AccountController().start();
    }
}