import java.util.*;
public class SampleSort {
	
	public static int medianOf3(int arr[],int begin,int end) {
	   Random rnd = new Random();
	      Random f = new Random();
	      int left = f.nextInt(arr.length - 1);
	      Random s = new Random();
	      int center = s.nextInt(arr.length - 1);
	      Random t = new Random();
	      int right = t.nextInt(arr.length - 1);
	      
	    int pivot = 0;

		if( arr[left] < arr[center] && arr[center]<arr[right] )
				pivot=arr[center];		              
		if( arr[center] < arr[left] && arr[left]<arr[right] )
				pivot=arr[left];
		if( arr[left] < arr[right] && arr[right]<arr[center] )
				pivot=arr[right];
		
		return pivot;
 }
		  
	   public static void swap(int arr[],int dex1, int dex2)  // swap two elements
	      {
	      int temp = arr[dex1];        // A into temp
	      arr[dex1] = arr[dex2];   // B into A
	      arr[dex2] = temp;             // temp into B
	      } 

		    
	    public static void sort(int arr[], int low, int high) 
	    { 


	        // Selecting the pivot
	        int pivot = medianOf3(arr,0,arr.length-1);
		    	//int pivot = medianOf3(arr);
	           // Begin partitioning
            int i =low;
            int j=high;


            while (i <= j) {
                 while (arr[i] < pivot) {
                       i++;
                 }

                 while (arr[j] > pivot) {
                       j--;
                 }

                 if (i <= j) {
                	 swap(arr, i, j);
                      i++;
                      j--;
                 }
                 else {
                	 break;
                 }
           }
             
            
            if (low < j)//sort smaller elements
                sort(arr, low, j);
            if (high > i)//sort larger elements
                sort(arr, i, high);
	    	}
	    	

		
	public static void main(String[] args) {
		int[] list1 = new int[10];
		for (int i = 0; i<list1.length;i++) {
			list1[i]=i;
		}
		SampleSort.sort(list1, 0, list1.length-1);
	}

}
