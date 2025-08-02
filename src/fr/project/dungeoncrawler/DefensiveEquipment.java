package fr.project.dungeoncrawler;

public abstract class DefensiveEquipment {
    public enum EquipmentType { SHIELD, POTION }

    private EquipmentType equipmentType;
    private String name;
    private int lifeLevel;

    public DefensiveEquipment(EquipmentType equipmentType, String name, int lifeLevel) {
        this.equipmentType = equipmentType;
        this.name = name;
        this.lifeLevel = lifeLevel;
    }
// getter
    public EquipmentType getType() {
        return equipmentType;
    }

    public String getName() {
        return name;
    }

    public int getLifeLevel() {
        return lifeLevel;
    }

// setter
    public void setType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }


    @Override
    public String toString() {
        return name + " (+" + lifeLevel + " HP)";
    }

   public abstract void use();
}