package in.ineuron.util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;


public class InsertApp {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
	    Scanner scanner = null;
	    ResultSet resultSet = null;
	    int sid=0;
	    
		try {
	          connection = JdbcUtil.getJdbcConnection( ); 
              
	         String sqlSelectQuery = "select sid, sname, sage, saddress, gender from student where sid = ?";

	         
	         if(connection !=null)
	         pstmt = connection.prepareStatement(sqlSelectQuery);	
	         
	         if(pstmt !=null) {
	         scanner = new Scanner(System.in);  
                 
                 System.out.print("Enter id of the student :");
                 sid=scanner.nextInt( ); 

                 // Use precompiled query to set the values
                  pstmt.setInt(1,sid);
               
                 // execute the Query
                 resultSet = pstmt.executeQuery( );
                }              
	         
	         if(resultSet !=null) {
                 
                 if(resultSet.next( ) ) {
                 System.out.println("SID\tSNAME\tSAGE\tSADDRESS\tGENDER");
                 System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3) +"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5));
                  }
                   else {
                     System.out.println("Record not available for the given id:" +sid);      
                   }                                
             }

  
	      }catch(IOException ie)
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
						   JdbcUtil.cleanUp(connection, pstmt, resultSet);
						   scanner.close();
						   System.out.println("Closing the resource");					  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	         }

		}
	}


