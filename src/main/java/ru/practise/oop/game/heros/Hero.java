package ru.practise.oop.game.heros;


import ru.practise.oop.game.evils.Evil;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero {
    protected final Scanner scanner = new Scanner(System.in);
    protected int power;
    protected int exp;
    protected int agility;
    protected int mana;
    protected int intellect;
    protected int maxHealth;
    protected int healthy;
    protected double x, y;
    protected int currentLevel;
    protected ArrayList<Items> inventory = new ArrayList<>();
    protected int liftedPower;
    protected final Items[] items = {
            Items.BACKPACK,
            Items.ARROW,
            Items.PILL,
            Items.SHIELD,
            Items.SWORD,
            Items.BOW,
            Items.AXE
    };


    public Hero(int power, int exp, int agility, int mana, int intellect, int healthy, double x, double y, int liftedPower) {
        this.power = power;
        this.exp = exp;
        this.agility = agility;
        this.mana = mana;
        this.intellect = intellect;
        this.healthy = healthy;
        maxHealth = healthy;
        this.x = x;
        this.y = y;
        this.liftedPower = liftedPower;
        currentLevel = 0;

    }

    public ArrayList<Items> getInventory() {
        return inventory;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getExp() {
        return exp;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract void takeItem(Items item);

    protected abstract boolean canTakeInInventory(Items item, int weight);

    protected abstract void attack(Evil enemy);

    protected abstract void defence(Evil enemy);

    public abstract boolean fight(Evil enemy);

    public abstract void toNextLevel();

    public void move(int i, int j) {
        x += i;
        y += j;
        System.out.println("Warrior location x = " + x + " y = " + y);
    }

    public boolean checkAlive(int healthy) {
        return healthy <= 0;
    }

    public boolean isNextLevel() {
        return exp >= 100 * (currentLevel + 1);
    }

    public void heal() {
        if (inventory.contains(Items.PILL)) {
            healthy = maxHealth;
            boolean isRemove = inventory.remove(Items.PILL);
            System.out.println("The warrior is healthy and full of strength");
        } else {
            System.out.println("You don't have any pills");
        }
    }

    public void throwAwayItem(Items item) {
        if (inventory.contains(item)) {
            boolean isRemove = inventory.remove(item);
            liftedPower += item.getWeight();
            System.out.println(item + " is throw away");
        }
    }

    protected int count(ArrayList<Items> inventory, Items items) {
        int k = 0;
        for (Items value : inventory) {
            if (value.equals(items)) {
                k++;
            }
        }
        return k;
    }

    public boolean haveShield() {
        return inventory.contains(Items.SHIELD);
    }
}
