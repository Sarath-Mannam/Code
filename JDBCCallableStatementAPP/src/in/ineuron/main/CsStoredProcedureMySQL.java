package in.ineuron.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


public class CsStoredProcedureMySQL {

	private static final  String storedProcedureCall="{CALL P_GET_PRODUCTS_DETAILS_BY_ID(?, ?, ?, ?)}";  
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   // Resources used
        Connection connection = null;
        CallableStatement cstmt = null;
        Scanner scanner = null;
        Integer id = null;
        
        try {
            connection = JdbcUtil.getJdbcConnection( );
            if(connection != null)
            cstmt = connection.prepareCall(storedProcedureCall);
             scanner = new Scanner(System.in);
             if (scanner != null) { 
              System.out.print("Enter the product id :");
              id = scanner.nextInt( );
             }
             // setting the input values
             if(cstmt != null) {
                 cstmt.setInt(1, id);
             }
             //Setting Output values
               if(cstmt != null) {
                   cstmt.registerOutParameter(2, Types.VARCHAR);
                   cstmt.registerOutParameter(3, Types.INTEGER);
                   cstmt.registerOutParameter(4, Types.INTEGER);
              }
             // run the stored procedure
              if(cstmt != null) {
                cstmt.execute( );   // To execute Stored procedure
             }
             // retrieve the result
             if(cstmt != null) {
             System.out.println("Product Name is : "+cstmt.getString(2));
             System.out.println("Product Cost is : "+cstmt.getInt(3));
             System.out.println("Product Quantity is : "+cstmt.getInt(4));
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
                             JdbcUtil.cleanUp(connection, cstmt, null);
                              }catch( SQLException e) {
                                 e.printStackTrace( );
                              }
                               scanner.close( );
        }

 }
}

