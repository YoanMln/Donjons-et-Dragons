package fr.project.dungeoncrawler;

public class Potion extends DefensiveEquipment{

    public Potion(String name, int lifeLevel) {
        super(EquipmentType.POTION, name, lifeLevel);
    }
    @Override
    public void use() {
        System.out.println("Vous utilisez " + getName());
    }

    public static class StandardPotion extends Potion {
        public StandardPotion(){
            super("Potion Standard", 2);
        }
        @Override
        public void use() {
            System.out.println("Vous utilisez la Potion Standard");
        }
    }

    public static class BigPotion extends Potion {
        public BigPotion(){
            super("Potion Big", 5);
        }
        @Override
        public void use() {
            System.out.println("Vous utilisez la Grande Potion");
        }
    }
}
