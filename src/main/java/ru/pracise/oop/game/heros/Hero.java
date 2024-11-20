package ru.pracise.oop.game.heros;


import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero {
    protected final Scanner scanner = new Scanner(System.in);
    protected int power;
    protected int exp;
    protected int agility;
    protected int mana;
    protected int intellect;
    protected int healthy;
    protected double x, y;
    protected ArrayList<Items> inventory = new ArrayList<>();
    protected int liftedPower;
    protected final Items[] items = {
            Items.BACKPACK,
            Items.ARROW,
            Items.FOOD,
            Items.KEY,
            Items.POTION,
            Items.SHIELD,
            Items.SWORD,
            Items.BOW
    };

    public Hero(int power, int exp, int agility, int mana, int intellect, int healthy, double x, double y, int liftedPower) {
        this.power = power;
        this.exp = exp;
        this.agility = agility;
        this.mana = mana;
        this.intellect = intellect;
        this.healthy = healthy;
        this.x = x;
        this.y = y;
        this.liftedPower = liftedPower;

    }

    public int getLiftedPower() {
        return liftedPower;
    }

    public void setLiftedPower(int liftedPower) {
        this.liftedPower = liftedPower;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
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

    //Карта бесконечная
    public void move(double i, double j) {
        x += i;
        y += j;
    }

    public void takeItem(Items item) {
        for (Items value : items) {
            if (item.equals(value) && canTakeInInventory(item, value.getWeight())) {
                inventory.add(item);
                liftedPower -= value.getWeight();
            }
        }
    }

    protected boolean canTakeInInventory(Items item, int weight) {
        switch (item) {
            case BOW, SWORD, SHIELD, BACKPACK, KEY:
                if (count(inventory, item) > 1) {
                    return false;
                }
                break;
        }
        return liftedPower - weight >= 0;
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

    public abstract boolean attack(int healthyOfEnemy);

    public boolean checkAlive(int healthy){
        return healthy > 0;
    }



}
