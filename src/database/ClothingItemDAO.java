package database;

import com.aknur.clothingstore.ClothingItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClothingItemDAO {

    public void insertItem(ClothingItem item) {

        String sql =
                "INSERT INTO clothing_item (name, size, price, brand) VALUES (?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, item.getName());
            ps.setString(2, item.getSize());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getBrand());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error while inserting item.");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllItems() {

        String sql = "SELECT * FROM clothing_item";
        Connection connection = DatabaseConnection.getConnection();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- ITEMS FROM DATABASE ---");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("item_id") +
                                ", Name: " + rs.getString("name") +
                                ", Size: " + rs.getString("size") +
                                ", Price: " + rs.getDouble("price") +
                                ", Brand: " + rs.getString("brand")
                );
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("Error while reading items.");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public boolean updateItem(int itemId, String name, String size, double price, String brand) {

        String sql =
                "UPDATE clothing_item SET name = ?, size = ?, price = ?, brand = ? WHERE item_id = ?";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, size);
            ps.setDouble(3, price);
            ps.setString(4, brand);
            ps.setInt(5, itemId);

            int rows = ps.executeUpdate();
            ps.close();

            return rows > 0; // true if updated

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public ClothingItem getItemById(int id) {

        String sql = "SELECT * FROM clothing_item WHERE item_id = ?";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ClothingItem item = new ClothingItem(
                        rs.getInt("item_id"),
                        rs.getString("name"),
                        rs.getString("size"),
                        rs.getDouble("price"),
                        rs.getString("brand")
                ) {
                    @Override
                    public void displayInfo() {
                        System.out.println(
                                "Item: " + getName() +
                                        ", Size: " + getSize() +
                                        ", Price: " + getPrice() +
                                        ", Brand: " + getBrand()
                        );
                    }

                    @Override
                    public String getCategory() {
                        return "ClothingItem";
                    }
                };

                rs.close();
                ps.close();
                return item;
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }


    public boolean deleteItem(int itemId) {

        String sql = "DELETE FROM clothing_item WHERE item_id = ?";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, itemId);

            int rows = ps.executeUpdate();
            ps.close();

            return rows > 0; // true if deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByName(String keyword) {

        String sql =
                "SELECT * FROM clothing_item WHERE name ILIKE ?";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Search results ---");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        "ID: " + rs.getInt("item_id") +
                                ", Name: " + rs.getString("name") +
                                ", Size: " + rs.getString("size") +
                                ", Price: " + rs.getDouble("price") +
                                ", Brand: " + rs.getString("brand")
                );
            }

            if (!found) {
                System.out.println("No items found.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByPriceRange(double min, double max) {

        String sql =
                "SELECT * FROM clothing_item WHERE price BETWEEN ? AND ? ORDER BY price ASC";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Items in price range ---");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        "ID: " + rs.getInt("item_id") +
                                ", Name: " + rs.getString("name") +
                                ", Size: " + rs.getString("size") +
                                ", Price: " + rs.getDouble("price") +
                                ", Brand: " + rs.getString("brand")
                );
            }

            if (!found) {
                System.out.println("No items found in this range.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void filterByMinPrice(double minPrice){
        String sql = "SELECT * FROM clothing_item WHERE price >= ?";
        Connection connection = DatabaseConnection.getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, minPrice);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Items with price >=" + minPrice + " ---");

            while (rs.next()){
                System.out.println(
                        "ID: " + rs.getInt("item_id") +
                                ", Name: " + rs.getString("name") +
                        ", Price: " + rs.getDouble("price")
                );
            }

            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
