package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class JdbcUtil {
	
	private JdbcUtil() {
		
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
	public static Connection getJdbcConnection() throws SQLException, IOException{
	
		String fileLoc = "C:\\Users\\MANNAM\\OneDrive\\Desktop\\full stack\\Java\\CRUDAPP\\src\\in\\ineuron\\properties\\Application.properties";

       HikariConfig config = new HikariConfig(fileLoc);
       HikariDataSource dataSource = new HikariDataSource(config);
       return dataSource.getConnection( );
	}
	
	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		String fileLoc = "C:\\Users\\MANNAM\\OneDrive\\Desktop\\full stack\\Java\\CRUDAPP\\src\\in\\ineuron\\properties\\Application.properties";
         FileInputStream fis = new FileInputStream(fileLoc);
         Properties properties = new Properties( );
         properties.load(fis);
      
		
		  String url = properties.getProperty("jdbcUrl");
          String username= properties.getProperty("user");
          String password = properties.getProperty("password");
          
          return DriverManager.getConnection(url, username, password);
	}

}

