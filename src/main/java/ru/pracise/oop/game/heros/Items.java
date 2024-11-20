package ru.pracise.oop.game.heros;

public enum Items {
    BACKPACK("backpack", 0, 0),
    SWORD("sword", 30, 19),
    KEY("key", 5, 0),
    BOW("bow", 22, 15),
    SHIELD("shield", 31, 0),
    FOOD("food", 4, 0),
    POTION("potion", 6, 9),
    ARROW("arrow", 12, 0),
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
