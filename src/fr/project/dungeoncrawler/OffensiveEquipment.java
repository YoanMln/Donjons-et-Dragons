package fr.project.dungeoncrawler;

public class OffensiveEquipment {
    public enum EquipmentType {WEAPON, SPELL}

    private EquipmentType Type;
    private String Name;
    private int attackLevel;


    public OffensiveEquipment(EquipmentType type, String name,int attackLevel) {
        this.Type = type;
        this.Name = name;
        this.attackLevel = attackLevel;
    }
    public EquipmentType getType() {
        return Type;
    }
    public String getName() {
        return Name;
    }
    public int getAttackLevel(){
        return attackLevel;
    }

}
