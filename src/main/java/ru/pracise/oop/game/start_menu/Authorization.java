package ru.pracise.oop.game.start_menu;

import java.util.Scanner;

public class Authorization {
    private static final Scanner SKAN = new Scanner(System.in);
    private static int k;
    private static String login;
    private static String password;
    private static String username;
    //В дальнейшем должен проверять данные из БД игры
    public static boolean logIn(String login, String password) {
        return false;
    }

    //В дальнейшем должен заносить данные в БД игры
    public static boolean logUp(String login, String password, String username) {
        return false;
    }
    public static void chosenLogIn(){
        do {
            k++;
            if (k > 1) {
                System.out.println("Incorrect login or password");
            }
            System.out.println("Enter your login");
            login = SKAN.nextLine();
            System.out.println("Enter your password");
            password = SKAN.nextLine();
        } while (Authorization.logIn(login, password));
        // В будущем + name из БД
        System.out.println("Have a good battle");
    }
    public static void chosenLogUp(){
        do {
            k++;
            if (k > 1) {
                System.out.println("This login or username already taken!\n");
            }
            System.out.println("Enter your username");
            username = SKAN.nextLine();
            System.out.println("Enter your login");
            login = SKAN.nextLine();
            System.out.println("Enter your password");
            password = SKAN.nextLine();
        } while (Authorization.logUp(username, login, password));
        // В будущем + name из БД
        System.out.println("Have a good battle");
    }
}
