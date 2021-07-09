package com.mitrais.bootcamp.atm.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);
    public static String inputString(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();

        return data;
    }
}
