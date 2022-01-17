package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static String Username = "root";
    private static String Password = "19nastena79";
    private static String URL = "jdbc:mysql://localhost:3306/vadim";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, Username, Password);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  connection;
    }
}
