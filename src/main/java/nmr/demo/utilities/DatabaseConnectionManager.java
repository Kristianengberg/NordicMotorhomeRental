package nmr.demo.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    private final String URL;
    private final String USER;
    private final String PASSWORD;


    public DatabaseConnectionManager() {

        /*
        Connect to config.properties
         */
        Properties prop = null;
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.URL = prop.getProperty("URL");
        this.USER = prop.getProperty("USER");
        this.PASSWORD = prop.getProperty("PASSWORD");

    }

    /*
        Connection Manager
         */

    public static Connection getDBConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "12345678");
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
