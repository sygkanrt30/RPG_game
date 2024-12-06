package ru.practise.oop.game.heros;

public enum Spells {
    FIREBALL("Fireball", 3, 7, 9, Integer.MAX_VALUE),
    THORNS("Thorns", 3, 4, 6, Integer.MAX_VALUE),
    SLOWING_DOWN("Slowing down", 3, 0, 15, 2),
    LIGHTNING("Lightning", 3, 8, 12, Integer.MAX_VALUE),
    HEAL("Heal", 3, 0, 6, 2),
    HELLFIRE("Hellfire", 4, 10, 18, 5),
    WALL_OF_WATER("Wall of water", 3, 7, 12, Integer.MAX_VALUE),
    SHIELD_OF_WATER("Shield of water", 3, 0, 6, 3)
    ;

    private final String name;
    private final int weight;
    private final int damage;
    private final int difficultyToLearn;
    private final int limiterSpells;

    Spells(String name, int weight, int damage, int difficultyToLearn, int limiterSpells) {
        this.name = name;
        this.weight = weight;
        this.damage = damage;
        this.difficultyToLearn = difficultyToLearn;
        this.limiterSpells = limiterSpells;
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

    public int getDifficultyToLearn() {
        return difficultyToLearn;
    }

    public int getLimiterSpells() {
        return limiterSpells;
    }

    public String info() {
        return name + " characteristics:" +
                "\ndamage = " + damage +
                "\ndifficultyToLearn = " + difficultyToLearn +
                "\nlimiterSpells = " + ((limiterSpells == Integer.MAX_VALUE) ? "no limits" : limiterSpells);
    }
}
