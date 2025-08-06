package fr.project.dungeoncrawler.db;
import fr.project.dungeoncrawler.Character;
import java.sql.*;

public class DataBase {

    private static final String BDD = "dungeon_crawler";
    private static final String url = "jdbc:mysql://localhost:8889/" + BDD;
    private static final String user = "root";
    private static final String passwd = "root";

    private Connection conn;

    public DataBase() {
        try {
            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println(" Connecté à la BDD !");
        } catch (Exception e) {
            System.out.println(" Erreur de connexion à la BDD :");
            e.printStackTrace();
            System.exit(0);
        }
    }


    public void getHeroes() {
        try {
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM `hero_character` ");

            while (rs.next()) {
                        System.out.println("Nom:" + rs.getString("name") +
                                ", Type : " + rs.getString("type") +
                                ", LifePoints : " + rs.getInt("LifePoints") +
                                ", Strength : " + rs.getInt("Strength") +
                                ", offensiveEquipment : " + rs.getString("offensiveEquipment") +
                                ", defensiveEquipment : " + rs.getString("defensiveEquipment"));


            }
            rs.close();
            smt.close();
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des personnages");
            e.printStackTrace();
        }
    }

    public void createHero(fr.project.dungeoncrawler.Character hero) {
        String sql = "INSERT INTO hero_character (name, type, LifePoints, Strength, offensiveEquipment, defensiveEquipment) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement stmt=conn.prepareStatement(sql)) {
            stmt.setString(1, hero.getName());
            stmt.setString(2, hero.getType());
            stmt.setInt(3, hero.getLife());
            stmt.setInt(4, hero.getAttack());
            String weaponName = (hero.getWeapon() != null) ? hero.getWeapon().getName() : "aucune";
            stmt.setString(5, weaponName);
            stmt.setString(6, "null");

            stmt.executeUpdate();
            System.out.println("personnage créé !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création du personnage");
            e.printStackTrace();
        }
    }

    public void editHeroById(int id, String name, String type, int lifePoints, int strength, String offensiveEquipment) {
        String sql = "UPDATE hero_character SET name = ?, type = ?, lifePoints = ?, strength = ?, offensiveEquipment = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setInt(3, lifePoints);
            stmt.setInt(4, strength);
            stmt.setString(5, offensiveEquipment);
            stmt.setInt(6, id);

            int updated = stmt.executeUpdate();
            if (updated > 0) {
                System.out.println("Personnage modifié avec succès !");
            } else {
                System.out.println("Aucun personnage trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du personnage.");
            e.printStackTrace();
        }
    }

}



