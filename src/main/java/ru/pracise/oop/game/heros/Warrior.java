package ru.pracise.oop.game.heros;

public class Warrior extends Hero{

    public Warrior(int power, int exp, int agility, int mana, int intellect, int healthy, double x, double y, int liftedPower) {
        super(power, exp, agility, mana, intellect, healthy, x, y, liftedPower);
    }

    @Override
    public boolean attack(int healthyOfEnemy) {
        String methodOfAttack;
        if (count(inventory, Items.SWORD) > 0){
            System.out.println("Choose method of attack\nHand-to-hand combat\nSword");
            methodOfAttack = scanner.nextLine();
            if (methodOfAttack.equals("Sword")){
                return true;
            } else if (methodOfAttack.equals("Hand-to-hand combat")) {
                return true;
            }else {
                System.out.println("This method is not available");
                return false;
            }
        }
        return true;
    }
}
