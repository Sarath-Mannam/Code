package in.ineuron.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;


public class DeleteApp {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
	    Scanner scanner = null;

	    try {
                connection = JdbcUtil.getJdbcConnection( ); 

                String sqlDeleteQuery = "delete from student  where sid =?";

                if(connection !=null)
                pstmt = connection.prepareStatement(sqlDeleteQuery);     

                if(pstmt != null) {              
                     scanner = new Scanner(System.in);  

                     System.out.print("Enter the id of the student :");
                     int sid = scanner.nextInt( ); 

                    // Use precompiled query to set the values                    
                    pstmt.setInt(1, sid);                          
       
                   // execute the Query
                  int rowCount = pstmt.executeUpdate( );
                   System.out.println("No of rows deleted is : "+rowCount); 
              }                         
	        }
                 catch(IOException ie)
	              {
	                 ie.printStackTrace( );
	               } 
	               catch(SQLException se)
	               {
	                  se.printStackTrace( );
	                } 
                  catch(Exception e)
                 {
		     e.printStackTrace( );
                  }
	              finally {
	        	             try {
	                                 JdbcUtil.cleanUp(connection, pstmt, null);
                                     scanner.close( );
                                     System.out.println("Closing the resource...");
		                     } 
                              catch (SQLException e) {
				              e.printStackTrace( );
			           }
	              }
	     }
	}




