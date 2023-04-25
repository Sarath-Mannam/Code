package in.ineuron.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class ClobInsertionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   
	    // Resources used
        Connection connection = null;
        PreparedStatement pstmt = null;
        Scanner scanner = null;

       // variables used
        String name = null;
        String pdfLoc = null;
        
     try {
             connection = JdbcUtil.getJdbcConnection( );
            
              String sqlInsertQuery = "insert into cities(`name`,`history`) values(?,?) ";
              if(connection != null) {                    
                 pstmt = connection.prepareStatement(sqlInsertQuery); 
              }
             
              if(pstmt != null) {
                   scanner = new Scanner(System.in);
  
               //collecting the inputs
                 if(scanner != null) {

                     System.out.print("Enter the cityname :");
                     name = scanner.next( );
                     
                      System.out.print( "Enter the pdf location:");
                      pdfLoc = scanner.next( );          
                     } 
                    

            // Set the input values to Query and execute.
                pstmt.setString(1, name);
                pstmt.setCharacterStream(2, new FileReader(new File(pdfLoc)));

            // execute the query
                int rowAffected = pstmt.executeUpdate( );
                System.out.println("No of rows inserted is:"+rowAffected);
               } 
           }

            catch( SQLException | IOException e) {
                        e.printStackTrace( );
           }           
           catch(Exception e) {
             e.printStackTrace( );
           }
           finally {
                      try {
                              JdbcUtil.cleanUp(connection, pstmt, null);
                               }catch( SQLException e) {
                                  e.printStackTrace( );
                               }
                                scanner.close( );
         }

  }
}
