import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DBAPI {
    private Connection connection;
    private Statement statement;
    public boolean isConnectedToDB = false;

    public DBAPI() {

    }

    public void connectToDB() {

        //OracleConnectionRequestInfo connectionRequestInfo = new OracleConnectionRequestInfo("system","s1H2a3Y4");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "s1H2a3Y4");
            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        isConnectedToDB = true;
    }


    public int dropTable(String tableName) throws SQLException {
        return statement.executeUpdate("Drop Table "+tableName);

    }

    public int createTable(String tableName, String[] columnNames) throws SQLException {

        String sqlStatement;
        sqlStatement = "CREATE TABLE " + tableName + "(" + convertStringArrayToStringWithCommas(columnNames) + ")";

        String EMPLOYEE_TABLE = "create table MyEmployees3 ( "
                + "   id INT PRIMARY KEY, firstName VARCHAR(20), lastName VARCHAR(20), "
                + "   title VARCHAR(20), salary INT " + ")";

        String test = "CREATE TABLE hello_world(" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "hello VARCHAR(50), world VARCHAR(50)   )";

        int result = statement.executeUpdate(sqlStatement);
        return result;
    }

    private String convertStringArrayToStringWithCommas(String[] columnNames) {
        String returnString = "";
        for (int i = 0; i < columnNames.length; i++) {
            if (i == columnNames.length - 1) {
                returnString += columnNames[i];
            } else
                returnString += columnNames[i] + ", ";
        }
        return returnString;
    }

    public int insertToTable(String tableName, String[] columnNames, String[] columnValues) throws SQLException {
        String sqlStatment = "";
        sqlStatment =
                "INSERT INTO " + tableName + "(" +
                        convertStringArrayToStringWithCommas(columnNames) + ") " +
                        "values(" +
                        convertStringArrayToStringWithCommas(columnValues) +
                        ");";

        String insertTableSQL = "INSERT INTO hello_world"
                + "(id, hello, world) " + "VALUES"
                + "(1,'mkyong','system');";
        return statement.executeUpdate(insertTableSQL);


    }

}
