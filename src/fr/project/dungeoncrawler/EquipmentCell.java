package fr.project.dungeoncrawler;

import java.util.Random;

public class EquipmentCell extends  Cell {
    private String equipmentType;
    private Random random = new Random();

    public EquipmentCell(int position, String equipmentType) {
        super(position);
        this.equipmentType = equipmentType;
    }

    @Override
    public void interact(Character player) {
        switch (equipmentType) {
            case "weapon":

                break;

            case "potion":
                System.out.println("Vous avez trouvez une potion");
                break;

            default: System.out.println("Vous avez trouvez une arme");
        }
    }

    private void giveRandomEquipment(Character player) {
        OffensiveEquipment newWeapon;
        int randomChoice = random.nextInt(4);
        switch (randomChoice) {
            case 0:
                newWeapon = new Weapon.Sword();
                break;
                case 1:
                    newWeapon = new Weapon.Massue();
                    break;
                    case 2:
                        newWeapon = new Spell.FireBall();
                        break;
                        case 3:
                            newWeapon = new Spell.Spark();
            default:
                newWeapon = new Weapon.Sword();
        }
        System.out.println("Vous trouvez : " + newWeapon.getName() + " (+" + newWeapon.getAttackLevel() + " atk)");


        if (player.getWeapon() != null) {
            System.out.println("Remplacer votre " + player.getWeapon().getName() + " par " + newWeapon.getName() + " ? (Equipement automatique pour l'instant)");
        }

        player.setWeapon(newWeapon);
        System.out.println("Équipé : " + newWeapon.getName());
    }

    private void giveRandomPotion(Character player) {
        DefensiveEquipment newPotion;
        int randomChoice = random.nextInt(2); // 0 ou 1

        switch (randomChoice) {
            case 0:
                newPotion = new Potion.StandardPotion();
                break;
            case 1:
                newPotion = new Potion.BigPotion();
                break;
            default:
                newPotion = new Potion.StandardPotion();
        }
        System.out.println("Vous trouvez : " + newPotion.getName() + " (+" + newPotion.getLifeLevel() + " HP)");


        usePotion(player, newPotion);
    }
    private void giveRandomShield(Character player) {
        DefensiveEquipment newShield;
        int randomChoice = random.nextInt(2);

        switch (randomChoice) {
            case 0:
                newShield = new Shield.BasicShield();
                break;

            default:
                newShield = new Shield.BasicShield();
        }

        System.out.println("Vous trouvez : " + newShield.getName() + " (+" + newShield.getLifeLevel() + " HP)");

    }

    private void usePotion(Character player, DefensiveEquipment potion) {
        int currentLife = player.getLife();
        int newLife = currentLife + potion.getLifeLevel();



        player.setLife(newLife);
        System.out.println("Vous utilisez " + potion.getName() + " et récupérez " + potion.getLifeLevel() + " HP !");
        System.out.println("Vie actuelle : " + player.getLife() + " HP");
    }

    @Override
    public String toString() {
        return "case avec" + equipmentType;
    }
}
