package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbContext {
    // mysql
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
}
