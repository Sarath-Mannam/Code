package in.ineuron.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;




public class ImageRetreivalAPP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     Connection connection = null;
         PreparedStatement pstmt = null;
         ResultSet resultSet = null;
         int id = 1;
       try{
               connection = JdbcUtil.getJdbcConnection( );
             
             String sqlSelectQuery = "select id, name, image from persons where id = ?";

              if( connection != null ) {
                      pstmt =  connection.prepareStatement(sqlSelectQuery);
               }

               // setting input values
               if(pstmt != null) {
               pstmt.setInt(1, id);

                //executing the query
                 resultSet = pstmt.executeQuery( );
               }
               
               if(resultSet != null) {
                      // processing the resultSet
                      if(resultSet.next( )) {
                    
                    	  System.out.println("ID\tNAME\tImage");
                           id = resultSet.getInt( 1 );
                          String name = resultSet.getString( 2 );
                          InputStream is = resultSet.getBinaryStream( 3 );
                                                   
                            File file = new File("byjus.jpg");
                            FileOutputStream fos = new FileOutputStream(file);
                            
                         /* int i = is.read( );

                            while( i !=-1 ) {
                            fos.write(i);
                             i=is.read( );
                          }
                        */
                         /*   byte [] b = new byte[1024];
                            while(is.read(b)>0) {
                            	fos.write(b);
                            }
                          */
                            //copying the data from (is) input stream  to (fos) file output stream
                            IOUtils.copy(is,fos);
                            
                           fos.close( );
                            System.out.println(id+"\t"+ name+"\t"+ file.getAbsolutePath( ) );
                      }
                      else {
                             System.out.println("Record not available for given id:"+id);
                      }
                }
        }
        catch(SQLException | IOException e) 
        {
           e.printStackTrace( );
        }
        catch(Exception e) {
         e.printStackTrace( );
        }
        finally {
                     try {
                              JdbcUtil.cleanUp(connection, pstmt, null);
                      } 
                       catch(SQLException e) {
                         e.printStackTrace( );
                      }
        }

	}

}
