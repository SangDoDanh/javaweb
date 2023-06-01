package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContextMysql {
    public Connection getConnect() {
        String urlMySQL = "jdbc:mysql://localhost/mvcdemo";//port=3306
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// nap driver
        }
        catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
        }
        try {
            con = DriverManager.getConnection(urlMySQL,"root","root");//ket noi
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return con;
    }
}
