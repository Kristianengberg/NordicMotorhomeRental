package nmr.demo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    static String username;
    static String password;
    static String url;
    static Connection conn;


    public static Connection getConnection() {
        Properties prop = new Properties();
        try {
            FileInputStream propertyFile = new FileInputStream("src/main/resources/application.properties");
            prop.load(propertyFile);
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            url = prop.getProperty("url");


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(username,password,url);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Successful connection");
        return conn;

    }

}

