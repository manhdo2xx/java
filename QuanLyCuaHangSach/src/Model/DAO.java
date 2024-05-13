package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    private static String db_url = "jdbc:mysql://localhost:3306/quanlycuahangsach";
    private static String user = "root";
    private static String pass = "123456";
    private static String className = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(db_url,user,pass);
            return connection;
        } catch (Exception e){
            System.out.println("Thất bại!!!");
            e.printStackTrace();
        }
        return null;
    }
    public static void close(){
        try {
            connection.close();
        } catch (Exception e){
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
