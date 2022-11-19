

import java.util.Scanner;

public class Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Scanner scan = new Scanner(System.in);  
		  System.out.println("Enter the number of Elements in an Array:");
		  int size = scan.nextInt();
		  int[] ar = new int[size];
		  System.out.println("Enter the elements of the array:");
          
          for (int i=0; i<ar.length; i++ )
		  {
        	  ar[i] =scan.nextInt();
		  }
          scan.close();
          
          System.out.println("after sorting of array:");
     
          for(int k=0;k<ar.length;k++) {
        	  for(int l=1; l<ar.length-k;l++)
        	  {
        		  if(ar[l]<ar[l-1])
        		  {
        			  int tempVar = ar[l];
        			     ar[l] = ar[l-1];
        			     ar[l-1] = tempVar;
        			  
        		  }
        	  }
          }
          for(int elem: ar)
          {
        	  System.out.println(elem+ " ");
          }
          
          System.out.println("Duplicate Elements present in an array:");
          
          for (int i=0; i<ar.length-1; i++ ) {
          int count = 0 ;
       	  for(int j=i+1; j<ar.length; j++) 
       	  {
       		if(ar[i]==ar[j]) 
			    count++;
		  }
       	  if(count >= 1)
       	  {
       	   System.out.println("Element " + ar[i]+" has duplicate Elements of "+ count );
       	    i=i+count;
		  }
		 
	}
  }
}


