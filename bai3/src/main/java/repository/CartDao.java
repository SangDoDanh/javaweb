package repository;

import coreservlets.CatalogItem;
import coreservlets.ItemOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    public static Connection getConnectionMysql() {
        String urlMySQL = "jdbc:mysql://localhost:3306/bookdemo";//port=3306
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// nap driver
        }
        catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
        }
        try {
            con = DriverManager.getConnection(urlMySQL,"root","12345678");//ket noi
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return con;
    }



    public static List<ItemOrder> getAll() {
        List<ItemOrder> itemOrders = new ArrayList<>();
        Connection con = getConnectionMysql();

        try {
            PreparedStatement pre = con.prepareStatement("SELECT * FROM cart ;");

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ItemOrder order = new ItemOrder();
                order.setNumItems(rs.getInt("quantity"));
                String idCatalogItem = rs.getString("catalog_item");
                CatalogItem catalogItem = CatalogDao.getCataItemById(idCatalogItem);
                order.setItem(catalogItem);
                itemOrders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemOrders;

    }
    public static void updateNumItem(ItemOrder order){
        Connection connection = getConnectionMysql();
        try {
            String sql = "UPDATE cart SET quantity = ? WHERE catalog_item =?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, order.getNumItems());
            pre.setString(2, order.getItemID());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addItem(ItemOrder newOrder) {
        Connection connection = getConnectionMysql();
        try {
            String sql = "INSERT INTO cart (catalog_item, quantity) VALUES \n" +
                    "(?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, newOrder.getItemID());
            pre.setInt(2, newOrder.getNumItems());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCatalogItem(ItemOrder order) {
        Connection connection = getConnectionMysql();
        try {
            String sql = "DELETE FROM cart WHERE catalog_item = ?;";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, order.getItemID());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
