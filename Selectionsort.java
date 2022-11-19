

public class Selectionsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	 int[] a = {44,1,55,99,43,22,14,15};
  
     for(int i=0; i<a.length-1; i++)
     {
         int min =i;
         for(int j=i+1; j<a.length; j++)
         { 
             if(a[j]<a[min])
                min = j; 
            }
                 int tempVar=a[i];
                 a[i]=a[min];
                 a[min]=tempVar;
              }

         
     for(int el:a)
         {
            System.out.print(el+ " ");
         }
     
         }
      
	

}
