package DataBase;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DBConnector {
    private Connection connection;
    private Statement statement;
    private boolean isConnectedToDB = false;

    public DBConnector() {

    }

    public void connectToDB() {

        //OracleConnectionRequestInfo connectionRequestInfo = new OracleConnectionRequestInfo("system","s1H2a3Y4");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "s1H2a3Y4");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        return connection;
    }
}
