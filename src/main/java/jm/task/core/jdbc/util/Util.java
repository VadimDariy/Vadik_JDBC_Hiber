package jm.task.core.jdbc.util;

import com.mysql.cj.protocol.x.ConfinedInputStream;
import org.hibernate.SessionFactory;
import jm.task.core.jdbc.model.User;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String Username = "root";
    private static final String Password = "19nastena79";
    private static final String URL = "jdbc:mysql://localhost:3306/vadim";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();

                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/vadim");
                properties.put(Environment.USER,  "root");
                properties.put(Environment.PASS,  "19nastena79");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO,"create-drop");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory =  configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Connection");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, Username, Password);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return  connection;
    }
}


