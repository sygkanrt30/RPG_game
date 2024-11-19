package ru.pracise.oop.game.start_menu;

public class CheckInputs {
    public static boolean checkChosen(String string) {
        return string.equals("Log in") || string.equals("Log up");
    }
}
