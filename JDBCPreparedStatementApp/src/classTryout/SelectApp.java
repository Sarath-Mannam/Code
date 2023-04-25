package classTryout;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.util.JdbcUtil;


public class SelectApp {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
	          connection = JdbcUtil.getJdbcConnection( ); 

	          if(connection !=null) 
	             statement = connection.createStatement( );

	          if(statement !=null) 
	          resultSet = statement.executeQuery("select sid, sname, sage, saddress, gender from student");
	          
	          if(resultSet!=null) {
	        	  System.out.println("SID\tSNAME\tSAGE\tSADDRESS\tGENDER");
	        	  while(resultSet.next()) {     	
	        		  System.out.println(resultSet.getInt(1)+ "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getString(4) +"\t" + resultSet.getString(5));
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
					 JdbcUtil.cleanUp(connection, statement, resultSet);
				} 
	        	catch (SQLException e) {
					e.printStackTrace();
				}
	        	 System.out.println("closing the resources");
	         }

		}
	}


