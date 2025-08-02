package fr.project.dungeoncrawler;

public class Shield extends DefensiveEquipment {
    public Shield(String name, int lifeLevel) {
        super(EquipmentType.SHIELD, name, lifeLevel);
    }
    @Override
    public void use() {
        System.out.println("Vous utilisez" + getName());
    }

    public static class BasicShield extends Shield {
        public BasicShield() {
            super("Bouclier", 10);
        }
        @Override
        public void use() {
            System.out.println("vous utilisez le bouclier");
        }
    }
}
