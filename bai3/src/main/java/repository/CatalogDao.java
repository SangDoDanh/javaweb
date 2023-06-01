package repository;

import coreservlets.CatalogItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogDao {
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

    public static List<CatalogItem> getAllCatalog() throws SQLException{
        List<CatalogItem> catalogItems = new ArrayList<>();

        Connection con = getConnectionMysql();
        PreparedStatement pre = con.prepareStatement("SELECT * FROM bookdemo.catalog_items;");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            CatalogItem catalogItem = new CatalogItem();
            catalogItem.setItemID(rs.getString("itemID"));
            catalogItem.setLongDescription(rs.getString("longDescription"));
            catalogItem.setShortDescription(rs.getString("shortDescription"));
            catalogItem.setCost(rs.getDouble("cost"));
            catalogItem.setType(rs.getString("type"));
            catalogItems.add(catalogItem);
        }
        return catalogItems;
    }

    public static List<CatalogItem> getCatelogItemsByType(String type) throws SQLException{
        List<CatalogItem> catalogItems = new ArrayList<>();

        Connection con = getConnectionMysql();
        PreparedStatement pre = con.prepareStatement("SELECT * FROM catalog_items WHERE type = ? ;");
        pre.setString(1, type);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            CatalogItem catalogItem = new CatalogItem();
            catalogItem.setItemID(rs.getString("itemID"));
            catalogItem.setLongDescription(rs.getString("longDescription"));
            catalogItem.setShortDescription(rs.getString("shortDescription"));
            catalogItem.setCost(rs.getDouble("cost"));
            catalogItem.setType(rs.getString("type"));
            catalogItems.add(catalogItem);
        }
        return catalogItems;
    }

    public static CatalogItem getCataItemById(String idCatalogItem) throws SQLException{
        CatalogItem catalogItem = new CatalogItem();
        Connection con = getConnectionMysql();
        PreparedStatement pre = con.prepareStatement("SELECT * from catalog_items where itemID=?");
        pre.setString(1, idCatalogItem);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            catalogItem.setItemID(rs.getString("itemID"));
            catalogItem.setLongDescription(rs.getString("longDescription"));
            catalogItem.setShortDescription(rs.getString("shortDescription"));
            catalogItem.setCost(rs.getDouble("cost"));
            catalogItem.setType(rs.getString("type"));
        }
        return catalogItem;
    }
}
