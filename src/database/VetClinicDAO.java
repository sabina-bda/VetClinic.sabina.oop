package database;

import model.Cat;
import model.Dog;
import model.Owner;
import model.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VetClinicDAO {

    public boolean addOwner(Owner owner) {
        String sql = "INSERT INTO owners (full_name, phone, address, email) " +
                "VALUES (?, ?, ?, ?) RETURNING owner_id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, owner.getFullName());
            ps.setString(2, owner.getPhone());
            ps.setString(3, owner.getAddress());
            ps.setString(4, owner.getEmail());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    owner.setOwnerId(rs.getInt("owner_id"));
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Add owner failed: " + e.getMessage());
        }
        return false;
    }

    public boolean addPet(Pet pet) {
        String sql = "INSERT INTO pets (name, type, breed, age, gender, color, is_vaccinated, owner_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pet.getName());
            ps.setString(2, pet instanceof Cat ? "CAT" : "DOG");
            ps.setString(3, pet.getBreed());
            ps.setInt(4, pet.getAge());
            ps.setString(5, pet.getGender());
            ps.setString(6, pet.getColor());
            ps.setBoolean(7, pet.isVaccinated());
            ps.setInt(8, pet.getOwnerId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pet.setPetId(rs.getInt("pet_id"));
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Add pet failed: " + e.getMessage());
        }
        return false;
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets ORDER BY name";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                pets.add(mapPet(rs));
            }
        } catch (SQLException e) {
            System.err.println("getAllPets failed: " + e.getMessage());
        }
        return pets;
    }

    public List<Owner> getAllOwners() {
        List<Owner> owners = new ArrayList<>();
        String sql = "SELECT * FROM owners ORDER BY full_name";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Owner o = new Owner();
                o.setOwnerId(rs.getInt("owner_id"));
                o.setFullName(rs.getString("full_name"));
                o.setPhone(rs.getString("phone"));
                o.setAddress(rs.getString("address"));
                o.setEmail(rs.getString("email"));
                owners.add(o);
            }
        } catch (SQLException e) {
            System.err.println("getAllOwners failed");
        }
        return owners;
    }

    public Pet getPetById(int id) {
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapPet(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("getPetById failed");
        }
        return null;
    }

    private Pet mapPet(ResultSet rs) throws SQLException {
        String type = rs.getString("type");
        Pet pet;

        if ("CAT".equalsIgnoreCase(type)) {
            pet = new Cat();
        } else {
            pet = new Dog();
        }

        pet.setPetId(rs.getInt("pet_id"));
        pet.setName(rs.getString("name"));
        pet.setBreed(rs.getString("breed"));
        pet.setAge(rs.getInt("age"));
        pet.setGender(rs.getString("gender"));
        pet.setColor(rs.getString("color"));
        pet.setVaccinated(rs.getBoolean("is_vaccinated"));
        pet.setOwnerId(rs.getInt("owner_id"));

        return pet;
    }


    public boolean updatePet(Pet pet) {
        String sql = "UPDATE pets SET name = ?, breed = ?, age = ?, gender = ?, " +
                "color = ?, is_vaccinated = ?, owner_id = ? " +
                "WHERE pet_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pet.getName());
            ps.setString(2, pet.getBreed());
            ps.setInt(3, pet.getAge());
            ps.setString(4, pet.getGender());
            ps.setString(5, pet.getColor());
            ps.setBoolean(6, pet.isVaccinated());
            ps.setInt(7, pet.getOwnerId());
            ps.setInt(8, pet.getPetId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("updatePet failed: " + e.getMessage());
            return false;
        }
    }

    public boolean deletePet(int petId) {
        String sql = "DELETE FROM pets WHERE pet_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, petId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("deletePet failed");
            return false;
        }
    }

    public List<Pet> searchPetsByName(String fragment) {
        List<Pet> result = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE name ILIKE ? ORDER BY name";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + fragment + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(mapPet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("searchPetsByName failed");
        }
        return result;
    }

    public List<Pet> searchPetsByAge(int minAge, int maxAge) {
        List<Pet> result = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE age BETWEEN ? AND ? ORDER BY age DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, minAge);
            ps.setInt(2, maxAge);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(mapPet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("searchPetsByAge failed");
        }
        return result;
    }
}