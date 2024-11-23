package ru.pracise.oop.game.heros;

public enum Items {
    BACKPACK("backpack", 0, 0),
    SWORD("sword", 27, 7),
    BOW("bow", 22, 10),
    SHIELD("shield", 31, 0),
    FOOD("food", 4, 0),
    ARROW("arrow", 12, 0),
    AXE("axe", 35, 12),
    HANDS("hands", 0, 3)
    ;

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
