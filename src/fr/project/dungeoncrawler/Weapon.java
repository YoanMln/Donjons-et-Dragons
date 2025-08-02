package  fr.project.dungeoncrawler;

public  class Weapon extends OffensiveEquipment{



    public Weapon(String name, int attackLevel) {
        super(EquipmentType.WEAPON, name, attackLevel);
    }
    @Override
    public void use() {
        System.out.println("Vous utilisez" + getName());
    }

    public static class Sword extends Weapon {
        public Sword() {
            super("Sword", 5);
        }
        @Override
        public void use() {
            System.out.println("Vous frappez avec l'épée");
        }
    }

    public static class Massue extends Weapon {
        public Massue() {
            super("Massue",3);
        }

        @Override
                public void use() {
            System.out.println("Vous frappez avec la massue");
        }
        }
    }


