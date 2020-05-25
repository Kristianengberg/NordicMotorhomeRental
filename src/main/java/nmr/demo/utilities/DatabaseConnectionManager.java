package nmr.demo.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    static String URL;
    static String USER;
    static String PASSWORD;


    public static Connection getDBConnection() {

        /*
        Connect to config.properties
         */
        Properties prop = new Properties();
        try {
            FileInputStream propertyFile = new FileInputStream("src/main/resources/application.properties");
            prop.load(propertyFile);
            USER = prop.getProperty("username");
            PASSWORD = prop.getProperty("password");
            URL = prop.getProperty("url");


        }catch (IOException e) {
            e.printStackTrace();
        }

    /*
        Connection Manager
         */

        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}

/*
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
*/
