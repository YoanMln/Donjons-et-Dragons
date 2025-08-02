package fr.project.dungeoncrawler;

public abstract class OffensiveEquipment {
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

    public void setType(EquipmentType type) {
        this.Type = type;
    }

    public void setName(String name) {
        this.Name = name;
    }

   public void setAttackLevel(int attackLevel){
    this.attackLevel=attackLevel;
   }



   @Override
    public String toString() {
        return "Nom: " + getName() + ", Attaque: " + getAttackLevel() + ", Type: " + getType();
   }

   public abstract void use();

}
