import java.sql.SQLException;

public class Main {

    public static void main(String... args){
        DBAPI dbapi = new DBAPI();
        dbapi.connectToDB();
        try {

            String tableName = "hello_world";
            dbapi.dropTable(tableName);
            dbapi.createTable(tableName,new String[]{"id INT PRIMARY KEY","hello VARCHAR(50 CHAR)","world VARCHAR(50 CHAR)"});
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] columns ={"id","hello","world"};
        String[] valuesToInsert ={"1,'helloValue'","'worldValue'"};
        try {
            dbapi.insertToTable("hello_world",columns,valuesToInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
