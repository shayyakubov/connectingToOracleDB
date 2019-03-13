package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
    public int createTable(String tableName, String[] columnNames , Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
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


    public int dropTable(String tableName, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate("Drop Table "+tableName);

    }
}
