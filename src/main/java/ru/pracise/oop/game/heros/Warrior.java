package ru.pracise.oop.game.heros;

import ru.pracise.oop.game.evils.Evil;

public class Warrior extends Hero {
    public Warrior(int power, int exp, int agility, int mana, int intellect, int healthy, double x, double y, int liftedPower) {
        super(power, exp, agility, mana, intellect, healthy, x, y, liftedPower);
    }

    @Override
    protected void attack(Evil enemy) {
        String methodOfAttack;
        int fortunaEnemy = (int) (Math.random() * 21);
        System.out.println(fortunaEnemy);
        if (fortunaEnemy <= enemy.getAgility()) {
            System.out.println("Damn, the enemy dodged\n");
        } else if (count(inventory, Items.SWORD) > 0 || count(inventory, Items.AXE) > 0) {
            if (count(inventory, Items.SWORD) > 0) {
                System.out.println("Choose method of attack\nHand-to-hand combat\nSword");
            } else if (count(inventory, Items.AXE) > 0) {
                System.out.println("Choose method of attack\nHand-to-hand combat\nAxe");
            } else {
                System.out.println("Choose method of attack\nHand-to-hand combat\nSword\nAxe");
            }
            int k = 0;
            do {
                if (k > 0) {
                    System.out.println("This method is not available");
                }
                methodOfAttack = scanner.nextLine();
                k++;
            } while (!(methodOfAttack.equals("Sword") || methodOfAttack.equals("Hand-to-hand combat") || methodOfAttack.equals("Axe")));
            switch (methodOfAttack) {
                case "Sword" -> {
                    enemy.setHealthy(enemy.getHealthy() - Items.SWORD.getDamage() * power);
                    System.out.println("You have dealt " + (Items.SWORD.getDamage() * power) + " damage\n");
                }
                case "Hand-to-hand combat" -> {
                    enemy.setHealthy(enemy.getHealthy() - Items.HANDS.getDamage() * power);
                    System.out.println("You have dealt " + (Items.HANDS.getDamage() * power) + " damage\n");
                }
                case "Axe" -> {
                    enemy.setHealthy(enemy.getHealthy() - Items.AXE.getDamage() * power);
                    System.out.println("You have dealt " + (Items.AXE.getDamage() * power) + " damage\n");
                }
            }
        } else {
            enemy.setHealthy(enemy.getHealthy() - 3 * power);
            System.out.println("You have dealt " + (3 * power) + " damage\n");
        }
    }

    @Override
    protected void defence(Evil enemy) {
        int fortunaWarrior = (int) (Math.random() * 21);
        System.out.println(fortunaWarrior);
        if (fortunaWarrior <= agility) {
            System.out.println("Wow, you dodged the attack\n");
        } else {
            healthy -= (4 * enemy.getDamage());
            System.out.println("Enemy has dealt " + (4 * enemy.getDamage()) + " damage\n");
        }
    }

    @Override
    public boolean fight(Evil enemy) {
        while (true) {
            attack(enemy);
            if (!checkAlive(enemy.getHealthy())) {
                System.out.println("You've won");
                System.out.println("You have gained enemy exp");
                return true;
            }
            defence(enemy);
            if (!checkAlive(healthy)) {
                System.out.println("You've lost!");
                System.out.println("Game is over!");
                return false;
            }
        }
    }
}
