import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnector {
  
  /**
   * @author samuel
   * @throws SQLException
   * This is the main function that will test the projectDatabase.
   */
  public static void main(String[] args) throws SQLException {

    String user = "zbva321";
    String port = "27007";
    String host = "localhost";
    String database = "teamproject";

    ProjectDatabase db = new ProjectDatabase(user, port, host, database);
    
    if(!db.tableExists("names")) {
      
      db.execute("CREATE TABLE names(username varchar(20) primary key);");
      
    }
    
    Map<String, String> values = new HashMap<String, String>(); 
    values.put("username", user); 
    db.insertInto("names", values);
    
    for(ArrayList<Object> row : db.query("SELECT username FROM names")) {
      
      System.out.println("Username :" + (row.get(0)));
      
    }
    
   }
 }
