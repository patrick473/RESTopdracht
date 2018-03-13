package Persistency;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class BaseDAO {


    public static Connection getlocalConnection(){
        final String url = "jdbc:postgresql://ec2-54-75-239-237.eu-west-1.compute.amazonaws.com:5432/d7f3dtr1ksd6dk?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
        final String user = "bycsaipnwfmqet";
        final String password = "5827f7d2d8601296d09dbbe98f951a49d99685e68fb95853be735ee857125714";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}



