package ru.practise.oop.game;

import ru.practise.oop.game.evils.Evil;
import ru.practise.oop.game.check_inputs.CheckInputs;
import ru.practise.oop.game.heros.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Evil> enemies = new ArrayList<>();
        Evil.addEnemies(enemies);
        Items[] items = {
                Items.BACKPACK,
                Items.ARROW,
                Items.PILL,
                Items.SHIELD,
                Items.SWORD,
                Items.BOW,
                Items.AXE
        };
        int k = 0;
        System.out.println("*** RPG game console ***");
        System.out.println(" ****** Welcome! ******");
        System.out.println("In order to  choose a character class, copy and paste one of the options:\nWarrior\nArcher\nWizard");
        String classOfCharacter = CheckInputs.inputClassCharacter();
        if (classOfCharacter.compareToIgnoreCase("Warrior") == 0) {
            Warrior warrior = new Warrior(5, 0, 2, 2, 3, 50, 0, 0, 80);
            while (true) {
                if (warrior.haveShield() && k == 0) {
                    warrior.setHealthy(warrior.getHealthy() + 30);
                    k++;
                    System.out.println("Now the warrior’s health along with his armor = " + warrior.getHealthy());
                }
                int cef = (int) (Math.random() * 10);
                int indexItems = (int) (Math.random() * items.length);
                CheckInputs.inputCoordinate(warrior);
                if ((warrior.getX() + warrior.getY()) % cef == 0) {
                    Items item = items[indexItems];
                    System.out.println("There's a " + item.getName().toLowerCase() + " on the ground");
                    System.out.println("Shall you take it?");
                    String answer = CheckInputs.inputYesOrNot();
                    if (answer.compareToIgnoreCase("yes") == 0) {
                        warrior.takeItem(item);
                    } else {
                        System.out.println("Next time there will be something useful");
                    }
                } else {
                    Evil enemy = enemies.get(warrior.getCurrentLevel());
                    boolean isAlive = warrior.fight(enemy);
                    if (!isAlive) {
                        return;
                    }
                    System.out.println("Exp: " + warrior.getExp());
                    enemy.recreation();
                    if (warrior.getInventory().contains(Items.PILL)) {
                        System.out.println("Do you want to heal?");
                        String answer = CheckInputs.inputYesOrNot();
                        if (answer.compareToIgnoreCase("yes") == 0) {
                            warrior.heal();
                        } else {
                            System.out.println("Right! We need to save pills");
                        }
                    }
                    if (warrior.isNextLevel()) {
                        warrior.toNextLevel();
                    }
                }
            }
        } else if (classOfCharacter.compareToIgnoreCase("Archer") == 0) {
            Archer archer = new Archer(3, 0, 5, 4, 5, 35, 0, 0, 70);
            while (true) {
                if (archer.haveShield() && k == 0) {
                    archer.setHealthy(archer.getHealthy() + 30);
                    k++;
                    System.out.println("Now the archer’s health along with his armor = " + archer.getHealthy());
                }
                int cef = (int) (Math.random() * 10);
                int indexItems = (int) (Math.random() * items.length);
                CheckInputs.inputCoordinate(archer);
                if ((archer.getX() + archer.getY()) % cef == 0) {
                    Items item = items[indexItems];
                    System.out.println("There's a " + item.getName().toLowerCase() + " on the ground");
                    System.out.println("Shall you take it?");
                    String answer = CheckInputs.inputYesOrNot();
                    if (answer.compareToIgnoreCase("yes") == 0) {
                        archer.takeItem(item);
                    } else {
                        System.out.println("Next time there will be something useful");
                    }
                } else {
                    Evil enemy = enemies.get(archer.getCurrentLevel());
                    boolean isAlive = archer.fight(enemy);
                    if (!isAlive) {
                        return;
                    }
                    System.out.println("Exp: " + archer.getExp());
                    enemy.recreation();
                    if (archer.getInventory().contains(Items.PILL)) {
                        System.out.println("Do you want to heal?");
                        String answer = CheckInputs.inputYesOrNot();
                        if (answer.compareToIgnoreCase("yes") == 0) {
                            archer.heal();
                        } else {
                            System.out.println("Right! We need to save pills");
                        }
                    }
                    if (archer.isNextLevel()) {
                        archer.toNextLevel();
                    }
                }
            }
        }
        Wizard wizard = new Wizard(3, 0, 4, 6, 6, 30, 0, 0, 40);
        Spells[] scrolls = wizard.getScrolls();
        while (true) {
            int cef = (int) (Math.random() * 10);
            int indexItems = (int) (Math.random() * items.length);
            int indexScrolls = (int) (Math.random() * scrolls.length);
            CheckInputs.inputCoordinate(wizard);
            if ((wizard.getX() + wizard.getY()) % cef == 0 && (cef % 2 == 0 || cef % 3 == 0)) {
                Spells scroll = scrolls[indexScrolls];
                System.out.println("There's a " + scroll.getName().toLowerCase() + " on the ground");
                System.out.println("Shall you take it?");
                String answer = CheckInputs.inputYesOrNot();
                if (answer.compareToIgnoreCase("yes") == 0) {
                    wizard.takeScroll(scroll);
                } else {
                    System.out.println("Next time there will be something useful");
                }
            } else if ((wizard.getX() + wizard.getY()) % cef == 0) {
                Items item = items[indexItems];
                System.out.println("There's a " + item.getName().toLowerCase() + " on the ground");
                System.out.println("Shall you take it?");
                String answer = CheckInputs.inputYesOrNot();
                if (answer.compareToIgnoreCase("yes") == 0) {
                    wizard.takeItem(item);
                } else {
                    System.out.println("Next time there will be something useful");
                }
            } else {
                Evil enemy = enemies.get(wizard.getCurrentLevel());
                boolean isAlive = wizard.fight(enemy);
                if (!isAlive) {
                    return;
                }
                System.out.println("Exp: " + wizard.getExp());
                enemy.recreation();
                if (wizard.getInventory().contains(Items.PILL)) {
                    System.out.println("Do you want to heal?");
                    String answer = CheckInputs.inputYesOrNot();
                    if (answer.compareToIgnoreCase("yes") == 0) {
                        wizard.heal();
                    } else {
                        System.out.println("Right! We need to save pills");
                    }
                    if (wizard.isNextLevel()) {
                        wizard.toNextLevel();
                    }
                }
            }
        }
    }
}

