package com.mitrais.bootcamp.atm.util;

public class ValidationUtil {
    public static boolean checkAccount(String account, String pin) {
        if (account.length() != 6) {
            System.out.println("Account Number should have 6 digits length");
            return false;
        }

        if (!account.matches("[0-9]+")) {
            System.out.println("Account Number should only contains numbers");
            return false;
        }

        if (pin.length() != 6) {
            System.out.println("PIN should have 6 digits length");
            return false;
        }

        if (!pin.matches("[0-9]+")) {
            System.out.println("PIN should only contains numbers ");
            return false;
        }
        return true;
    }

    public static boolean checkInput(String input) {
        if (!input.matches("[0-9]+")) {
            System.out.println("Invalid ammount");
            return false;
        }

        if (Long.parseLong(input) > 1000) {
            System.out.println("Maximum amount to withdraw is $1000");
            return false;
        }

        if (Long.parseLong(input) % 10 != 0) {
            System.out.println("Invalid ammount");
            return false;
        }

        return true;
    }

    public static boolean isAmountCorrect(String input) {
        if (!input.matches("[0-9]+")) {
            System.out.println("Invalid Amount");
            return false;
        }

        if (Long.parseLong(input) > 1000) {
            System.out.println("Maximum amount to withdraw is $1000");
            return false;
        }

        if (Long.parseLong(input) < 1) {
            System.out.println("Minimum amount to withdraw is $1");
            return false;
        }

        return true;
    }

    public static boolean isAccountCorrect(String input) {
        if (!input.matches("[0-9]+")) {
            System.out.println("Invalid Account");
            return false;
        }

        return true;
    }
}
