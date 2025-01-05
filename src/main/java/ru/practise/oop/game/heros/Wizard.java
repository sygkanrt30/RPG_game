package ru.practise.oop.game.heros;

import ru.practise.oop.game.evils.Evil;
import ru.practise.oop.game.check_inputs.CheckInputs;

import java.util.ArrayList;
import java.util.HashSet;


public class Wizard extends Hero {
    private boolean skippingMove;
    private int limitSlowingDown = Spells.SLOWING_DOWN.getLimiterSpells();
    private int limitHeal = Spells.HEAL.getLimiterSpells();
    private int limitHellfire = Spells.HELLFIRE.getLimiterSpells();
    private int limitShieldOfWater = Spells.SHIELD_OF_WATER.getLimiterSpells();
    private final HashSet<Spells> knownSpells = new HashSet<>();
    private final ArrayList<Spells> inventoryScrolls = new ArrayList<>();
    private final Spells[] scrolls = {
            Spells.FIREBALL,
            Spells.HEAL,
            Spells.HELLFIRE,
            Spells.LIGHTNING,
            Spells.THORNS,
            Spells.WALL_OF_WATER,
            Spells.SLOWING_DOWN,
            Spells.SHIELD_OF_WATER
    };

    public Wizard(int power, int exp, int agility, int mana, int intellect, int healthy, double x, double y, int liftedPower) {
        super(power, exp, agility, mana, intellect, healthy, x, y, liftedPower);
    }

    @Override
    protected void attack(Evil enemy) {
        String chosenSpell;
        int damage;
        int fortunaEnemy = (int) (Math.random() * 21);
        if (fortunaEnemy <= enemy.getAgility()) {
            System.out.println("Damn, the enemy dodged");
            return;
        }
        if (!knownSpells.isEmpty()) {
            chosenSpell = inputChosenSpell();
            switch (chosenSpell) {
                case "fireball" -> {
                    damage = Spells.FIREBALL.getDamage() * power;
                    enemy.setHealthy(enemy.getHealthy() - damage);
                    System.out.println("Wizard has dealt " + damage + " damage");
                }
                case "thorns" -> {
                    damage = Spells.THORNS.getDamage() * power;
                    enemy.setHealthy(enemy.getHealthy() - damage);
                    System.out.println("Wizard has dealt " + damage + " damage");
                }
                case "slowing down" -> {
                    limitSlowingDown--;
                    if (limitSlowingDown < 1) {
                        System.out.println("Limit of slowing down has been spent");
                    }
                    System.out.println("Slowing Down can be used " + limitSlowingDown + " more times");
                    skippingMove = true;
                    System.out.println("Wizard slowed down the enemy so much that he was unable to attack");
                    damage = Items.HANDS.getDamage() * power;
                    enemy.setHealthy(enemy.getHealthy() - damage);
                    System.out.println("Wizard has dealt " + damage + " damage");

                }
                case "lightning" -> {
                    damage = Spells.LIGHTNING.getDamage() * power;
                    enemy.setHealthy(enemy.getHealthy() - damage);
                    System.out.println("Wizard has dealt " + damage + " damage");
                }
                case "heal" -> {
                    limitHeal--;
                    if (limitHeal < 1) {
                        System.out.println("Limit of heal has been spent");
                    }
                    System.out.println("Heal can be used " + limitHeal + " more times");
                    healthy = maxHealth;
                    System.out.println("Wizard increased your health to the max");

                }
                case "hellfire" -> {
                    limitHellfire--;
                    if (limitHellfire < 1) {
                        System.out.println("Limit of hellfire has been spent");
                    }
                    System.out.println("Hellfire can be used " + limitHellfire + " more times");
                    damage = Spells.HELLFIRE.getDamage() * power;
                    enemy.setHealthy(enemy.getHealthy() - damage);
                    System.out.println("Wizard has dealt " + damage + " damage");

                }
                case "wall of water" -> {
                    damage = Spells.WALL_OF_WATER.getDamage() * power;
                    enemy.setHealthy(enemy.getHealthy() - damage);
                    System.out.println("Wizard has dealt " + damage + " damage");
                }
                case "shield of water" -> {
                    limitShieldOfWater--;
                    if (limitShieldOfWater < 1) {
                        System.out.println("Limit of shield of water has been spent");
                    }
                    System.out.println("Shield of water can be used " + limitShieldOfWater + " more times");
                    healthy += 40;
                    System.out.println("Shield increased wizard's health by 40");

                }
            }
            return;
        }
        if (inventory.contains(Items.SWORD)) {
            damage = Items.SWORD.getDamage() * power;
        } else {
            damage = Items.HANDS.getDamage() * power;
        }
        enemy.setHealthy(enemy.getHealthy() - damage);
        System.out.println("Wizard has dealt " + damage + " damage");
    }

    @Override
    protected void defence(Evil enemy) {
        int fortunaWizard = (int) (Math.random() * 21);
        if (skippingMove) {
            skippingMove = false;
            return;
        }
        if (fortunaWizard <= agility) {
            System.out.println("Wow, Wizard dodged the attack");
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
                System.out.println("Wizard is won");
                System.out.println("Wizard has gained enemy exp");
                exp += enemy.getExp();
                return true;
            }
            System.out.println("Enemy has " + enemy.getHealthy() + " health left\n");
            defence(enemy);
            if (checkAlive(healthy)) {
                System.out.println("Wizard is lost!");
                System.out.println("Game is over!");
                return false;
            }
            System.out.println("Wizard has " + healthy + " health left\n");
        }
    }

    public void takeScroll(Spells spell) {
        for (Spells value : scrolls) {
            if (spell.equals(value) && canTakeScroll(spell, spell.getWeight())) {
                inventoryScrolls.add(spell);
                System.out.println("Scroll of " + spell.getName() + " has been added to the inventory");
                studyingScrolls(spell);
                System.out.println();
                liftedPower -= value.getWeight();
            }
        }
    }

    protected boolean canTakeScroll(Spells spell, int weight) {
        if (inventoryScrolls.contains(spell)) {
            System.out.println("Wizard can't take more than one and it's useless");
            return false;
        }
        return liftedPower - weight >= 0;
    }

    public void studyingScrolls(Spells spell) {
        if (canStudyingScrolls(spell)) {
            knownSpells.add(spell);
            inventoryScrolls.remove(spell);
            System.out.println(spell.getName() + " studied\n");
            System.out.println(spell.info());

        } else {
            System.out.println("Wizard doesn't have the intellect to learn this spell");
        }
    }

    public boolean canStudyingScrolls(Spells spell) {
        return spell.getDifficultyToLearn() <= intellect;
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
            case BOW, SHIELD, ARROW, AXE, HANDS:
                System.out.println("Wizard can not take " + item);
                return false;
            case BACKPACK, SWORD:
                if (inventory.contains(item)) {
                    System.out.println("There can only be one instance in the inventory");
                    return false;
                }
                break;
            case PILL:
                if (count(inventory, item) > 1) {
                    System.out.println("There can only be two instance in the inventory");
                    return false;
                }
        }
        return liftedPower - weight >= 0;
    }

    private String inputChosenSpell() {
        System.out.println("Choose spell:");
        for (Spells spell : knownSpells) {
            System.out.println(spell.getName());
        }
        int k = 0;
        String chosenSpell = null;
        do {
            if (k > 0 && !chosenSpell.isEmpty()) {
                System.out.println("Wizard doesn't know this spell");
            }
            chosenSpell = scanner.nextLine();
            k++;
        } while (!(CheckInputs.checkChosenSpellWizard(chosenSpell, knownSpells)));
        if (chosenSpell.compareToIgnoreCase("Hellfire") == 0 && limitHellfire < 1 || chosenSpell.compareToIgnoreCase("Slowing down") == 0 && limitSlowingDown < 1
                || chosenSpell.compareToIgnoreCase("Heal") == 0 && limitHeal < 1 || chosenSpell.compareToIgnoreCase("Shield of water") == 0 && limitShieldOfWater < 1) {
            System.out.println("Limit of " + chosenSpell.toLowerCase() + " has been spent\n");
            return inputChosenSpell();
        }
        return chosenSpell.toLowerCase();
    }

    @Override
    public void toNextLevel() {
        currentLevel += 1;
        agility += 2;
        maxHealth += 25;
        if (healthy < maxHealth){
            healthy = maxHealth;
        }
        mana += 3;
        intellect += 3;
        liftedPower += 20;
        power += 2;
        if (!inventoryScrolls.isEmpty()) {
            for (Spells inventoryScroll : inventoryScrolls) {
                studyingScrolls(inventoryScroll);
            }
        }
        System.out.println("Congratulations!!! Now your level = " + currentLevel);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Wizard:" +
                "\npower = " + power +
                "\nexp = " + exp +
                "\nagility = " + agility +
                "\nmana = " + mana +
                "\nintellect = " + intellect +
                "\nhealthy = " + healthy +
                "\nliftedPower = " + liftedPower +
                "\ninventory = " + ((!inventory.isEmpty())? inventory: "nothing yet") +
                "\ninventoryScrolls = " + ((!inventoryScrolls.isEmpty())? inventoryScrolls: "nothing yet") +
                "\nknownSpells = " + ((!knownSpells.isEmpty())? knownSpells: "nothing yet");
    }

}