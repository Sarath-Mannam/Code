package in.ineuron.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	public JdbcUtil() {
		
	}
	
	  static {  
                    // Step1:  loading and register the driver   
         try{
              Class.forName("com.mysql.cj.jdbc.Driver");
          } 
          catch(ClassNotFoundException ce) {
                ce.printStackTrace( );
           }
      }

	
	public static Connection getJdbcConnection( ) throws SQLException, IOException{
		
		// Take the data from properties file
		  FileInputStream fis = new FileInputStream("src\\in\\ineuron\\main\\Application.properties");  
          Properties properties = new Properties( );
                     properties.load(fis);       

		
		// Step2 - Establish the connection
		 Connection connection =  DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"), properties.getProperty("password"));
		 return connection;
	}

	public static void cleanUp(Connection con, Statement statement , ResultSet resultSet ) throws SQLException {
		
   // Step6 - Close the resources, Declaring all the methods as static because it is a utility code.

		
        if (con != null ) {
            con.close();
        }
      
        if(statement != null) {
        statement.close();
        }

       if(resultSet !=null) {
          resultSet.close();
       }

	}
}
