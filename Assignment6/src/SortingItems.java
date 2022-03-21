import java.util.Arrays;
import java.util.Random;

public class SortingItems {

    public static void main(String[] args) {


    int array[] = {1,5,6,1,2,3,-5000,533};
    SortingItems.quickSort2(array, 0, array.length-1);
    System.out.println(Arrays.toString(array));

   }

    public static void swapReferences(int arr[],int a, int b)  // swap two elements
    {
    int temp = arr[a];        // A into temp
    arr[a] = arr[b];   // B into A
    arr[b] = temp;             // temp into B
    } 

	    
  public static void quickSort2(int arr[], int low, int high) 
  { 
      Random f = new Random();
      int first = f.nextInt(arr.length - 1);
      int second = f.nextInt(arr.length - 1);
      int third = f.nextInt(arr.length - 1);

      
      // Selecting the pivot
      int pivot = arr[first]+arr[second]+arr[third]-Math.min(arr[first], Math.min(arr[second], arr[third]))
			  - Math.max(arr[first], Math.max(arr[second], arr[third]));
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
          	 swapReferences(arr, i, j);
                i++;
                j--;
           }
           else {
          	 break;
           }
     }
       
      
      if (low < j)//sort smaller elements
          quickSort2(arr, low, j);
      if (high > i)//sort larger elements
          quickSort2(arr, i, high);
  	}
	// Generating random numbers from 0 to the last element of the array

}