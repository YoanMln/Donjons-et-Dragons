package fr.project.dungeoncrawler;

public class Character {
    private String name;
    private int life;
    private int attack;
    private String type;
    private OffensiveEquipment weapon;

    public void setName(String newName) {
        this.name = newName;

    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OffensiveEquipment getWeapon() {
        return weapon;
    }

    public void setWeapon(OffensiveEquipment weapon) {
        this.weapon = weapon;

    }

    @Override
    public String toString() {
        return " type : " + type + " Nom : " + name + " hp : " + life + " Atk : " + attack;
    }
}


