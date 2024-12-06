package ru.practise.oop.game.heros;

public enum Items {
    BACKPACK("Backpack", 0, 0),
    SWORD("Sword", 27, 7),
    BOW("Bow", 22, 10),
    SHIELD("Shield", 31, 0),
    PILL("Pill", 2, 0),
    ARROW("Arrow", 5, 0),
    AXE("Axe", 34, 12),
    HANDS("Hands", 0, 3);

    private final String name;
    private final int weight;
    private final int damage;

    Items(String name, int weight, int damage) {
        this.name = name;
        this.weight = weight;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getDamage() {
        return damage;
    }
}
