import java.util.Scanner;

public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter Size of Array 1");
		 int size1 = scan.nextInt();
		 System.out.println("Enter size of Array 2");
		 int size2 = scan.nextInt();
		 int[] arr1 = new int[size1];
		 int[] arr2 = new int[size2];
		 System.out.println("Enter Elements of Array 1: ");
		 for(int i=0; i<arr1.length; i++)
		 {
			 arr1[i]=scan.nextInt();
		 }
		 int j=0;
		 System.out.println("Enter Elements of Array 2: ");
		 for( j=0; j<arr2.length; j++)
		 {
			 arr2[j]=scan.nextInt();
		 }
		
	
		 int x = 0;
		 for(int i=0; i<arr2.length; i++)
		 {
			 for(j=0; j<arr1.length; j++)
			 {
				 if(arr2[i]==arr1[j])
				 {
					 break;
				 }
			 }
			 if(j==arr1.length)
			 {
				 x =1;
				 System.out.println(" Array 2 is not a subset of Array 1!!");
				 break;
			 }
		 }
		 if(x==0)
		 {
			 System.out.println("Array 2 is  subset of Array 1!!");
		 }
		 
		 
	}

}
