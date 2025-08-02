package fr.project.dungeoncrawler;

public class Spell extends OffensiveEquipment {

   public Spell(String name, int attackLevel) {
       super(EquipmentType.SPELL,name,attackLevel);
   }
   @Override
    public void use(){
       System.out.println("Vous utilisez" + getName());
   }

   public static class FireBall  extends Spell {
       public FireBall(){
           super("Fireball", 4);
       }
       @Override
       public void use(){
           System.out.println("Vous utilisez le sort boule de feu");
       }
   }

   public static class Spark extends Spell {
       public Spark(){
           super("Spark", 2);
       }
       @Override
       public void use(){
           System.out.println("Vous utilisez le sort éclaire");
       }
   }
}

