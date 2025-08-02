package fr.project.dungeoncrawler;

public abstract class Character {
    protected String name;
    protected int life;
    protected int attack;
    protected String type;
    protected OffensiveEquipment weapon;

    public abstract void initializeStats();

    public void setName(String newName) {
        this.name = newName;
    }

    public int getLife() { return life; }
    public void setLife(int life) { this.life = life; }

    public String getName() { return name; }

    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }

    public String getType() { return type; }

    public OffensiveEquipment getWeapon() { return weapon; }
    public void setWeapon(OffensiveEquipment weapon) { this.weapon = weapon; }

    @Override
    public String toString() {
        return "Type : " + type + " | Nom : " + name + " | HP : " + life + " | ATK : " + attack;
    }
}