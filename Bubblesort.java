import java.util.Scanner;

public class Bubblesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter the number of Elements in an Array");
		 int size = scan.nextInt();
		 int[] arr = new int[size];
		 System.out.println("Enter the elements of the array:");
		 for(int i=0; i<arr.length; i++)
		 {
			 arr[i]=scan.nextInt();
		 }
		 scan.close();
		 System.out.println("Sorted Array:");
		 
		 for(int i=0; i<arr.length; i++)
		 {
		     for(int j=1; j<arr.length-i; j++)
			 {
				 if(arr[j]<arr[j-1])
				 {
					 int tempVar = arr[j];
					 arr[j]=arr[j-1];
					 arr[j-1]=tempVar;
				 }
			 }
		 }
		  for(int elem : arr)
		  {
			  System.out.print(elem+ " ");
		  }
	}

}
