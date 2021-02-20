package banking;

import java.util.Objects;

public class Account {
    private String number;
    private String pin;
    private int balance;

    public Account(String number, String pin) {
        this.number = number;
        this.pin = pin;
    }

    public Account(String number, String pin, int balance) {
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }

    public Account(String number) {
        this.number = number;
    }

    public Account() {
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", pin='" + pin + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(number, account.number) &&
                Objects.equals(pin, account.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, pin);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
