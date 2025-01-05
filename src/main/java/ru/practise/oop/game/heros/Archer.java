package ru.practise.oop.game.heros;

import ru.practise.oop.game.check_inputs.CheckInputs;
import ru.practise.oop.game.evils.Evil;


public class Archer extends Hero {
    public Archer(int power, int exp, int agility, int mana, int intellect, int healthy, double x, double y, int liftedPower) {
        super(power, exp, agility, mana, intellect, healthy, x, y, liftedPower);
        inventory.add(Items.BOW);
        for (int i = 0; i < 6; i++) {
            inventory.add(Items.ARROW);
        }
    }

    @Override
    protected void attack(Evil enemy) {
        int damage = 0;
        Items methodOfAttack;
        int fortunaEnemy = (int) (Math.random() * 21);
        if (fortunaEnemy <= enemy.getAgility()) {
            System.out.println("Damn, the enemy dodged");
            boolean _ = inventory.remove(Items.ARROW);
            return;
        } else if (inventory.contains(Items.BOW) && inventory.contains(Items.ARROW)) {
            methodOfAttack = Items.BOW;
        } else {
            methodOfAttack = Items.HANDS;
            if (!inventory.contains(Items.BOW)) {
                System.out.println("Archer doesn't have a bow, he deals damage with his hands");
            } else if (!inventory.contains(Items.ARROW)) {
                System.out.println("Archer doesn't have a arrows, he deals damage with his hands");
            }
        }
        switch (methodOfAttack) {
            case BOW -> {
                damage = Items.BOW.getDamage() * power;
                boolean _ = inventory.remove(Items.ARROW);
            }
            case HANDS -> damage = Items.HANDS.getDamage() * power;
        }
        enemy.setHealthy(enemy.getHealthy() - damage);
        System.out.println("Archer has dealt " + damage + " damage");
    }

    @Override
    protected void defence(Evil enemy) {
        int fortunaArcher = (int) (Math.random() * 21);
        if (fortunaArcher <= agility) {
            System.out.println("Wow, Archer dodged the attack");
            return;
        }
        healthy -= (4 * enemy.getDamage());
        System.out.println("Enemy has dealt " + (4 * enemy.getDamage()) + " damage");
    }

    @Override
    public boolean fight(Evil enemy) {
        while (true) {
            attack(enemy);
            if (checkAlive(enemy.getHealthy())) {
                System.out.println("Archer is won");
                System.out.println("Archer has gained enemy exp");
                exp += enemy.getExp();
                return true;
            }
            System.out.println("Enemy has " + enemy.getHealthy() + " health left\n");
            defence(enemy);
            if (checkAlive(healthy)) {
                System.out.println("Archer is lost!");
                System.out.println("Game is over!");
                return false;
            }
            System.out.println("Archer has " + healthy + " health left\n");
        }
    }

    @Override
    public void takeItem(Items item) {
        for (Items value : items) {
            if (item.equals(value) && canTakeInInventory(item, value.getWeight())) {
                inventory.add(item);
                System.out.println(item + " has been added to the inventory");
                liftedPower -= value.getWeight();
            }
        }
    }

    @Override
    protected boolean canTakeInInventory(Items item, int weight) {
        switch (item) {
            case BOW, SHIELD, BACKPACK:
                if (inventory.contains(item)) {
                    System.out.println("There can only be one instance in the inventory");
                    return false;
                }
                break;
            case SWORD, HANDS, AXE:
                System.out.println("Archer can not take " + item);
                return false;
            case PILL:
                if (count(inventory, item) > 1) {
                    System.out.println("There can only be two instance in the inventory");
                    return false;
                }
        }
        if (!(liftedPower - weight >= 0)) {
            System.out.println(inventory);
            String answer = CheckInputs.inputYesOrNot();
            if (answer.compareToIgnoreCase("yes") == 0) {
                throwAwayItem(CheckInputs.chosenThrowawayItem(this));
                return canTakeInInventory(item, weight);
            }
            return false;
        }
        return true;
    }

    @Override
    public void toNextLevel() {
        currentLevel += 1;
        agility += 2;
        maxHealth += 20;
        if (healthy < maxHealth) {
            healthy = maxHealth;
        }
        mana += 2;
        intellect += 2;
        liftedPower += 20;
        power += 3;
        System.out.println("Congratulations!!! Now your level = " + currentLevel);
        System.out.println(this);
    }

    @Override
    public void heal() {
        if (inventory.contains(Items.PILL)) {
            healthy = maxHealth;
            boolean _ = inventory.remove(Items.PILL);
            System.out.println("The archer is healthy and full of strength");
        } else {
            System.out.println("Archer doesn't have any pills");
        }
    }

    @Override
    public String toString() {
        return "Archer:" +
                "\npower = " + power +
                "\nexp = " + exp +
                "\nagility = " + agility +
                "\nmana = " + mana +
                "\nintellect = " + intellect +
                "\nhealthy = " + healthy +
                "\nliftedPower = " + liftedPower +
                "\ninventory = " + ((!inventory.isEmpty()) ? inventory : "nothing yet");
    }
}
