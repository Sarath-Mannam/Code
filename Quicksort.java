import java.util.Arrays;

public class Quicksort {

	static void sort(int[] arr, int low, int high) {
        
        
		   int mid = (low+high)/2;
           int i = low;
           int j = high; 
           int pivot = arr[mid];
            
            while(i<=j) {
            	
            	while (arr[i]<pivot) {
            		i++;
                 }
            	
            	 while(arr[j]>pivot) {
            		 j--;
            	 }
            	 if(i<=j) {
            		 int temp = arr[i];
            		 arr[i]=arr[j];
            		 arr[j]=temp;
            		 i++;
            		 j--;
            	 }  
            }
              if(low<j)
            	  sort(arr, low, j);
              if(high > i)
            	  sort(arr, i, high);
            	  
           
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {14, 5, 6, 92, 26, 49, 89};
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		}
             
                    
		}
             

	


