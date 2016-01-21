import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author samuel
 * This is the constructor which will declair variables.
 */
public class ProjectDatabase {

  private String username;
  private String port;
  private String host;
  private String databaseName;
  
  private Connection dbConnection;  
  
  ProjectDatabase(String username, String port, String host, String databaseName) {
    
    this.username = username;
    this.port = port;
    this.host = host;
    this.databaseName = databaseName;
    
    this.connect();
    
  }
  
  /**
   * A private class that connect to the rhul teaching server.
   */
  private void connect() {
    
    try {
      
      Class.forName("org.postgresql.Driver");  
      this.dbConnection = DriverManager.getConnection("jdbc:postgresql://"+this.host+":"
          + this.port + "/" + this.databaseName, this.username, "doesn't matter");

    } catch (SQLException e) {

        System.out.println("Connection failed");

    } catch (ClassNotFoundException e) {
      
        System.out.println("Unable to load the postgre driver !");
      
    }
  }

  /**
   * @param tableName
   * This class will check if information has already exist in the database.
   */
  public boolean tableExists(String tableName) {
    
      try {
        
        DatabaseMetaData dbm = this.dbConnection.getMetaData();
        ResultSet tables = dbm.getTables(null, null, tableName, null);

        return tables.next();
        
      } catch (Exception e) {
        
          return false;
          
       }
  }
  
  /**
   * @param command
   * This will be the class that will take the sql command from the user and execute the command.
   */
  public void execute(String command) {
    
    try {
      
      Statement statement = this.dbConnection.createStatement();
      statement.execute(command);
      statement.close();

    } catch (SQLException e) {
      
        System.out.println("Unable to execute query :" + e.getMessage());
        
    }
  }
  
  /**
   * @param tableName
   * @param values
   * This method will call the execute and execute the requestString and the key and values.
   */
  public void insertInto(String tableName, Map<String, String> values) {
    
    String requestString = "INSERT INTO "+tableName + " ";
    String keyString = "(";
    String valuesString = "(";
    for(Entry<String, String> entry : values.entrySet()) {
      
      //Assign the key to keyString and value to valuesString to prepare the requestString.
      keyString += "\""+entry.getKey()+"\" , ";
      valuesString += "'"+entry.getValue()+"' , ";
      
    }
    
    //Clean up th syntax by removing the last semicolon.
    keyString = keyString.substring(0, keyString.length() - 2);
    valuesString = valuesString.substring(0, valuesString.length() - 2);

    keyString += ")";
    valuesString += ")";
    
    this.execute(requestString + keyString + " VALUES " + valuesString + ";");
    
  }
  
  /**
   * 
   * @param command
   * @return resultSet
   * This is a method that will add the line to the resultSet and return what is in the resultSet.
   */
  public ArrayList<ArrayList<Object>> query(String command) {
    
    try {
      
      //Creating an ArrayList of ArrayList containing the query datas
      ArrayList<ArrayList<Object>> resultSet = new ArrayList<ArrayList<Object>>();
      
      ResultSet results = this.dbConnection.createStatement().executeQuery(command);
      
      int columnNumber = results.getMetaData().getColumnCount();
      
      //Looping through database line.
      while(results.next()) {
        
        //Creating an ArrayList containing the line data. 
        ArrayList<Object> columnSet = new ArrayList<Object>();
        for(int i = 1; i <= columnNumber; i++) {
          
          columnSet.add(results.getObject(i));
          
        }
        
        //Add the line to resultSet.
        resultSet.add(columnSet);
        
      }
 
      return resultSet;
  
    } catch (SQLException e) {
      
        System.out.println("Unable to perform query : "+e.getMessage());
        
    }
    return null;
  }
  
}
