package ru.practise.oop.game.check_inputs;

import ru.practise.oop.game.heros.*;

import java.util.HashSet;
import java.util.Scanner;

public class CheckInputs {
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean checkChosenOfCharacter(String s) {
        return !s.equals("Warrior") && !s.equals("Archer") && !s.equals("Wizard");
    }

    public static boolean checkChosenMethodOfAttackWarrior(String s) {
        return !(s.equals("Sword") || s.equals("Hand-to-hand combat") || s.equals("Axe"));
    }

    public static boolean checkChosenSpellWizard(String chosenSpell, HashSet<Spells> knownSpells) {
        for (Spells spell : knownSpells) {
            if (spell.getName().equals(chosenSpell)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInputCoordinate(String i, String j) {
        int x, y;
        try {
            x = Integer.parseInt(i);
            y = Integer.parseInt(j);
        } catch (NumberFormatException e) {
            return true;
        }
        return (x == 0 && y == 0) || (x > 100 || y > 100);
    }

    public static String inputYesOrNot() {
        int k = 0;
        String answer;
        do {
            if (k > 0) {
                System.out.println("You write: yes or no");
            }
            answer = scanner.nextLine();
            k++;
        } while (!(answer.equals("yes") || answer.equals("no")));
        return answer;
    }

    public static void inputCoordinate(Warrior warrior) {
        int k = 0;
        int x, y;
        String i, j;
        System.out.println("Choose in which direction to move, to do this, enter how much to increase the coordinates," +
                "you can not move more than 100 meters in any direction: ");
        do {
            if (k > 0) {
                System.out.println("Please right correct direction");
            }
            i = scanner.nextLine();
            j = scanner.nextLine();
            k++;
        } while (CheckInputs.checkInputCoordinate(i, j));
        x = Integer.parseInt(i);
        y = Integer.parseInt(j);
        warrior.move(x, y);
    }

    public static void inputCoordinate(Archer archer) {
        int k = 0;
        int x, y;
        String i, j;
        System.out.println("Choose in which direction to move, to do this, enter how much to increase the coordinates," +
                "you can not move more than 100 meters in any direction: ");
        do {
            if (k > 0) {
                System.out.println("Please right correct direction");
            }
            i = scanner.nextLine();
            j = scanner.nextLine();
            k++;
        } while (CheckInputs.checkInputCoordinate(i, j));
        x = Integer.parseInt(i);
        y = Integer.parseInt(j);
        archer.move(x, y);
    }

    public static void inputCoordinate(Wizard wizard) {
        int k = 0;
        int x, y;
        String i, j;
        System.out.println("Choose in which direction to move, to do this, enter how much to increase the coordinates," +
                "you can not move more than 100 meters in any direction: ");
        do {
            if (k > 0) {
                System.out.println("Please right correct direction");
            }
            i = scanner.nextLine();
            j = scanner.nextLine();
            k++;
        } while (CheckInputs.checkInputCoordinate(i, j));
        x = Integer.parseInt(i);
        y = Integer.parseInt(j);
        wizard.move(x, y);
    }

    public static String inputClassCharacter() {
        String classOfCharacter;
        int k = 0;
        do {
            if (k > 0) {
                System.out.println("You need to enter Warrior, Archer, Wizard!!!");
            }
            classOfCharacter = scanner.nextLine();
            k++;
        } while (CheckInputs.checkChosenOfCharacter(classOfCharacter));
        return classOfCharacter;
    }

    public static Items chosenThrowawayItem(Warrior warrior) {
        String item;
        int k = 0;
        do {
            if (k > 0) {
                System.out.println("You need to write an item that is in the inventory");
            }
            item = scanner.nextLine();
            k++;
        } while (CheckInputs.checkChosenOfCharacter(item));
        Items item1 = null;
        for (int i = 0; i < warrior.getInventory().size(); i++) {
            if (item.equals(warrior.getInventory().get(i).getName().toLowerCase())) {
                item1 = warrior.getInventory().get(i);
                break;
            }
        }
        return item1;
    }

    public static Items chosenThrowawayItem(Archer archer) {
        String item;
        int k = 0;
        do {
            if (k > 0) {
                System.out.println("You need to write an item that is in the inventory");
            }
            item = scanner.nextLine();
            k++;
        } while (CheckInputs.checkChosenOfCharacter(item));
        Items item1 = null;
        for (int i = 0; i < archer.getInventory().size(); i++) {
            if (item.equals(archer.getInventory().get(i).getName().toLowerCase())) {
                item1 = archer.getInventory().get(i);
                break;
            }
        }
        return item1;
    }
}

