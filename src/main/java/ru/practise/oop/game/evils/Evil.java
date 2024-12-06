package ru.practise.oop.game.evils;

import java.util.ArrayList;

public class Evil {
    private int healthy;
    private final int agility;
    private final int damage;
    private final int exp;
    private final int maxHealthy;

    public Evil(int healthy, int agility, int damage, int exp) {
        this.healthy = healthy;
        this.agility = agility;
        this.damage = damage;
        this.exp = exp;
        maxHealthy = healthy;
    }

    public int getHealthy() {
        return healthy;
    }

    public int getExp() {
        return exp;
    }

    public int getAgility() {
        return agility;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public static void addEnemies(ArrayList<Evil> enemies) {
        enemies.add(new Evil(40, 3, 3, 10));
        enemies.add(new Evil(80, 4, 6, 20));
        enemies.add(new Evil(100, 7, 10, 50));
        enemies.add(new Evil(130, 7, 13, 70));
        enemies.add(new Evil(160, 9, 18, 90));
    }

    public void recreation() {
        healthy = maxHealthy;

    }
}
