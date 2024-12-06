package ru.practise.oop.game.heros;

import ru.practise.oop.game.evils.Evil;
import ru.practise.oop.game.check_inputs.CheckInputs;

public class Warrior extends Hero {
    public Warrior(int power, int exp, int agility, int mana, int intellect, int healthy, double x, double y, int liftedPower) {
        super(power, exp, agility, mana, intellect, healthy, x, y, liftedPower);
    }

    @Override
    protected void attack(Evil enemy) {
        String methodOfAttack;
        int damage = 0;
        int fortunaEnemy = (int) (Math.random() * 21);
        if (fortunaEnemy <= enemy.getAgility()) {
            System.out.println("Damn, the enemy dodged");
            return;
        }
        if (inventory.contains(Items.SWORD) || inventory.contains(Items.AXE)) {
            methodOfAttack = inputMethodOfAttack();
            switch (methodOfAttack) {
                case "Sword" -> damage = Items.SWORD.getDamage() * power;
                case "Hand-to-hand combat" -> damage = Items.HANDS.getDamage() * power;
                case "Axe" -> damage = Items.AXE.getDamage() * power;
            }
        } else {
            damage = Items.HANDS.getDamage() * power;
        }
        enemy.setHealthy(enemy.getHealthy() - damage);
        System.out.println("Warrior has dealt " + damage + " damage");
    }

    @Override
    protected void defence(Evil enemy) {
        int damage;
        int fortunaWarrior = (int) (Math.random() * 21);
        if (fortunaWarrior <= agility) {
            System.out.println("Wow, Warrior dodged the attack");
            return;
        }
        damage = 4 * enemy.getDamage();
        healthy -= (damage);
        System.out.println("Enemy has dealt " + damage + " damage");
    }

    @Override
    public boolean fight(Evil enemy) {
        while (true) {
            attack(enemy);
            if (checkAlive(enemy.getHealthy())) {
                System.out.println("Warrior is won");
                System.out.println("Warrior has gained enemy exp");
                exp += enemy.getExp();
                return true;
            }
            System.out.println("Enemy has " + enemy.getHealthy() + " health left\n");
            defence(enemy);
            if (checkAlive(healthy)) {
                System.out.println("Warrior is lost!");
                System.out.println("Game is over!");
                return false;
            }
            System.out.println("Warrior has " + healthy + " health left\n");
        }
    }


    @Override
    public void takeItem(Items item) {
        for (Items value : items) {
            if (item.equals(value) && canTakeInInventory(item, value.getWeight())) {
                inventory.add(item);
                System.out.println(item.getName() + " has been added to the inventory\n");
                liftedPower -= value.getWeight();
            }
        }
    }

    @Override
    protected boolean canTakeInInventory(Items item, int weight) {
        switch (item) {
            case SWORD, SHIELD, BACKPACK, AXE:
                if (inventory.contains(item)) {
                    System.out.println("There can only be one instance in the inventory");
                    return false;
                }
                break;
            case BOW, ARROW, HANDS:
                System.out.println("Warrior can not take " + item);
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
            if (answer.equals("yes")) {
                throwAwayItem(CheckInputs.chosenThrowawayItem(this));
                return canTakeInInventory(item, weight);
            }
            return false;
        }
        return true;
    }

    private String inputMethodOfAttack() {
        System.out.println("Choose method of attack:\nHand-to-hand combat");
        if (inventory.contains(Items.SWORD)) {
            System.out.println("Sword");
        } else if (inventory.contains(Items.AXE)) {
            System.out.println("Axe");
        } else {
            System.out.println("Sword\nAxe");
        }
        String methodOfAttack;
        int k = 0;
        do {
            if (k > 0) {
                System.out.println("This method is not available");
            }
            methodOfAttack = scanner.nextLine();
            k++;
        } while (CheckInputs.checkChosenMethodOfAttackWarrior(methodOfAttack));
        return methodOfAttack;
    }

    @Override
    public void toNextLevel() {
        currentLevel += 1;
        agility += 2;
        maxHealth += 25;
        if (healthy < maxHealth){
            healthy = maxHealth;
        }
        mana += 2;
        intellect += 3;
        liftedPower += 20;
        power += 3;
        System.out.println("Congratulations!!! Now your level = " + currentLevel);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Warrior:" +
                "\npower = " + power +
                "\nexp = " + exp +
                "\nagility = " + agility +
                "\nmana = " + mana +
                "\nintellect = " + intellect +
                "\nhealthy = " + healthy +
                "\nliftedPower = " + liftedPower +
                "\ninventory = " + ((!inventory.isEmpty())? inventory: "nothing yet");
    }
}
