package fr.project.dungeoncrawler;

/**
 * Classe abstraite représentant un équipement offensif dans le jeu.
 * Cette classe peut être étendue pour créer des armes ou des sorts.
 */
public abstract class OffensiveEquipment {

    /**
     * Enumération représentant le type d'équipement offensif.
     * Peut être une arme (WEAPON) ou un sort (SPELL).
     */
    public enum EquipmentType {WEAPON, SPELL}

    private EquipmentType Type;
    private String Name;
    private int attackLevel;

    /**
     * Constructeur de l'équipement offensif.
     *
     * @param type Le type de l'équipement (arme ou sort)
     * @param name Le nom de l'équipement
     * @param attackLevel Le niveau d'attaque de l'équipement
     */
    public OffensiveEquipment(EquipmentType type, String name, int attackLevel) {
        this.Type = type;
        this.Name = name;
        this.attackLevel = attackLevel;
    }

    /**
     * Retourne le type de l'équipement.
     *
     * @return Le type (WEAPON ou SPELL)
     */
    public EquipmentType getType() {
        return Type;
    }

    /**
     * Retourne le nom de l'équipement.
     *
     * @return Le nom de l'équipement
     */
    public String getName() {
        return Name;
    }

    /**
     * Retourne la puissance d'attaque de l'équipement.
     *
     * @return Le niveau d'attaque
     */
    public int getAttackLevel() {
        return attackLevel;
    }

    /**
     * Définit le type de l'équipement.
     *
     * @param type Le type à définir
     */
    public void setType(EquipmentType type) {
        this.Type = type;
    }

    /**
     * Définit le nom de l'équipement.
     *
     * @param name Le nom à définir
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * Définit le niveau d'attaque de l'équipement.
     *
     * @param attackLevel Le niveau d'attaque à définir
     */
    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    /**
     * Retourne une représentation textuelle de l'équipement.
     *
     * @return Chaîne de caractères contenant le nom, l'attaque et le type
     */
    @Override
    public String toString() {
        return "Nom: " + getName() + ", Attaque: " + getAttackLevel() + ", Type: " + getType();
    }

    /**
     * Méthode abstraite à implémenter pour définir le comportement de l'utilisation de l'équipement.
     */
    public abstract void use();
}