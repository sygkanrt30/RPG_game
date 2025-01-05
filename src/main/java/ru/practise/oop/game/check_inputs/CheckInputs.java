package ru.practise.oop.game.check_inputs;

import ru.practise.oop.game.heros.*;

import java.util.HashSet;
import java.util.Scanner;

public class CheckInputs {
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean checkChosenOfCharacter(String s) {
        return !(s.compareToIgnoreCase("Warrior") == 0) &&
                !(s.compareToIgnoreCase("Archer") == 0) &&
                !(s.compareToIgnoreCase("Wizard") == 0);
    }

    public static boolean checkChosenMethodOfAttackWarrior(String s) {
        return !((s.compareToIgnoreCase("Sword") == 0) ||
                (s.compareToIgnoreCase("Hand-to-hand combat") == 0) ||
                (s.compareToIgnoreCase("Axe") == 0));
    }

    public static boolean checkChosenSpellWizard(String chosenSpell, HashSet<Spells> knownSpells) {
        for (Spells spell : knownSpells) {
            if (spell.getName().compareToIgnoreCase(chosenSpell) == 0) {
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
        } while (!(answer.compareToIgnoreCase("yes") == 0 || answer.compareToIgnoreCase("no") == 0));
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
            if (item.compareToIgnoreCase(warrior.getInventory().get(i).getName()) == 0) {
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
            if (item.compareToIgnoreCase(archer.getInventory().get(i).getName()) == 0) {
                item1 = archer.getInventory().get(i);
                break;
            }
        }
        return item1;
    }
}

