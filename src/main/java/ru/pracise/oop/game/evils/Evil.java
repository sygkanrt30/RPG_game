package ru.pracise.oop.game.evils;

public class Evil {
    protected int healthy;
    protected int agility;
    protected int damage;

    public Evil(int healthy, int agility, int damage) {
        this.healthy = healthy;
        this.agility = agility;
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean checkAlive(int healthy) {
        return healthy > 0;
    }
}
