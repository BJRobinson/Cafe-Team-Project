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
    
    static ProjectDatabase db = null;
    
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

      db = new ProjectDatabase(user, port, host, database);
      setUp();
      
      Map<String, String> values = new HashMap<String, String>(); 
      values.put("username", user); 
      db.insertInto("names", values);
      
      for(ArrayList<Object> row : db.query("SELECT username FROM names")) {
        
        System.out.println("Username :" + (row.get(0)));
        
      }
      
      for(ArrayList<Object> row2 : db.query("SELECT * FROM Orders")) {
        
        System.out.println(row2);
        
      }
    }
    
    /**
     * Creating tables in database.
     */
    public static void setUp() {
      
      db.execute("CREATE TABLE IF NOT EXISTS names(username varchar(20) primary key);");
      db.execute("CREATE TABLE IF NOT EXISTS Orders(OrderNumber int, TimeOrder time, dishes varchar(50), drinks varchar(20), tableNumber int, state int);");
      db.execute("CREATE TABLE IF NOT EXISTS IngStock(name varchar(20), amount int, type varchar(20), price float, isVegan boolean);");
      db.execute("CREATE TABLE IF NOT EXISTS DrinkStock(name varchar(20), amount int, type varchar(20), size varchar(10), price float, calories int, isAlcoholic boolean);");
      db.execute("CREATE TABLE IF NOT EXISTS Deals(name varchar(20), price float, dishes varchar(20), drinks varchar(20));");
      db.execute("CREATE TABLE IF NOT EXISTS Waiters(waiterID int primary key, waitName varchar(30), numberOfOrders int);");
    
    }
   }