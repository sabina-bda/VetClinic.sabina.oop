package database;

import model.Cat;
import model.Dog;
import java.sql.*;

public class VetClinicDAO {

    public void addDog(Dog dog) {
        String sql = "INSERT INTO public.pets (id, name, age, type, breed) VALUES (?, ?, ?, 'Dog', ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dog.getId());
            stmt.setString(2, dog.getName());
            stmt.setInt(3, dog.getAge());
            stmt.setString(4, dog.getBreed());
            stmt.executeUpdate();
            System.out.println("✅ Dog added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addCat(Cat cat) {
        String sql = "INSERT INTO public.pets (id, name, age, type, breed) VALUES (?, ?, ?, 'Cat', NULL)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cat.getId());
            stmt.setString(2, cat.getName());
            stmt.setInt(3, cat.getAge());
            stmt.executeUpdate();
            System.out.println("✅ Cat added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAllPets() {
        String sql = "SELECT * FROM public.pets ORDER BY id ASC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n----------------- CLINIC REGISTRY -----------------");
            System.out.printf("%-5s | %-12s | %-5s | %-10s | %-15s%n", "ID", "NAME", "AGE", "TYPE", "BREED");
            System.out.println("---------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d | %-12s | %-5d | %-10s | %-15s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("type"), rs.getString("breed"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updatePet(int id, String newName, int newAge) {
        String sql = "UPDATE public.pets SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, newAge);
            stmt.setInt(3, id);
            int updated = stmt.executeUpdate();
            if (updated > 0) System.out.println("✅ Pet updated!");
            else System.out.println("❌ Pet not found.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deletePet(int id) {
        String sql = "DELETE FROM public.pets WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();
            if (deleted > 0) System.out.println("✅ Pet deleted!");
            else System.out.println("❌ Pet not found.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}