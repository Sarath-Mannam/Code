package in.ineuron.daofactory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class StudentDaoFactory {

	 private StudentDaoFactory( ) {
     }

    private static IStudentDao studentDao = null;

   // method which will returns implementation class object  of an interface called IStudentDao
   public static IStudentDao getStudentDao( ) {

  // studentDao object should be created if the object does not exist            
                 if(studentDao == null) {
                    studentDao = new StudentDaoImpl( );
                }      
                return studentDao; 
  }

}
