import java.util.Arrays;
import java.util.Random;

public class TestSort {
	public static int[] quicksort(int arr[], int left, int right) {
		  
		  int pivot = arr[(int) Math.floor((left + right) / 2)];
		  int index = partition(arr, left, right, pivot);
		  quicksort(arr, left, index - 1);
		  quicksort(arr, index, right);
		  return arr;
		}
    public static void swapReferences(int arr[],int a, int b)  // swap two elements
    {
    int temp = arr[a];        // A into temp
    arr[a] = arr[b];   // B into A
    arr[b] = temp;             // temp into B
    } 
		public static int  partition(int arr[], int left, int right,int pivot) {
		  while (left <= right) {
		    while (arr[left] < pivot && left <= right) {
		      left++;
		    }
		    while (arr[right] > pivot) {
		      right--;
		    }
		    if (left <= right) {
		     swapReferences(arr, left,right);
		      left++;
		      right--;
		    }
		  }
		  return left;
		}
	    public static void main(String[] args) {

	        int array1[] = {1,5,6,1,2,3,-5000,533};
	        TestSort.quicksort(array1, 0, array1.length-1);
	        System.out.println(Arrays.toString(array1));

	       }
}
