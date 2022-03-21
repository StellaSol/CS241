/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team Authors: Stella Solano
 *  External Collaborators: None
 *  References: Liang book, Weiss book
 *  			https://introcs.cs.princeton.edu/java/12types/ThreeSort.java.html : used to find the median using the Math class
 *				https://itnext.io/a-sort-of-quick-guide-to-quicksort-and-hoares-partitioning-scheme-in-javascript-7792112c6d1
 *  Assignment: Assignment 6
 *  Problem: Evaluate the running times of Quick Sort and Insertion Sort
 *  Description: Comparing Insertion Sort with Quick Sort. 2 different versions of quick sort with 2 different pivots will also be compared
 *
 *  Input: None
 *  Output: Running times of three methods on 3 different list
 *
 *  Visible data fields:None
 *
 *  Visible methods:
 *  public static void insertionSort(int arr[]) 					---> insertion sort algorithm
 *	public static int partition(int arr[], int begin, int end) {	---> part of quick sort version 2a
 *	public static void quickSort1(int arr[], int low, int high)		    ---> quick sort algorithm with pivot as first element
 *	public static void quickSort2(int arr[], int low, int high) 	---> quick sort algorithm with pivot as median of 3 random elements
 *  public static void swapReferences(int arr[],int a, int b) 		---> For swapping elements 
 *   Remarks
 *   -------
 *
 *   3)
 *      	 Version	|	increasing order		|	 decreasing order	    |	random		
 *   	       1		|		41,507				|	    112,165				|	130,387
 *        	   2a		|		132,918				|		515,314				|	47,825
 *        	   2b		|		5,118,097			|		2,545,520			|	1,638,281	
 *        
 *   4)  	 Version	|	increasing order		|	 decreasing order		|	random			
 *   	       1		|		O(n)				|		O(n^2)				|	O(n^2)		
 *        	   2a		|		O(n^2)				|		O(n^2)				|	O(nlogn)		
 *        	   2b		|		O(nlogn)			|		O(nlogn)			|	O(nlogn)		
 
 *	 5) 	I used n=100 because the stack would overflow if i go above that. At times when I run n=100, the stack will overflow but i was still able to get the running times for quicksort version 2b.
 *			
 *			For version 1, measurements match my big-o conjectures. Insertion sorting inputs with decreasing order and random inputs will grow faster 
 *			than insertion sorting increasing order. This is due to the fact that in increasing order, the elements are already sorted and so there will be no swaps.
 *			In comparison to decreasing order and random inputs, there will be numerous swaps which will make the time O(n^2).
 *			
 *			For version2a, measurements match my big o conjectures. Quicksorting with the pivot as the first element on an already sorted array and reverse sorted array
 *			will grow faster than inputs in random order. This is due to the fact that the pivot is used to partition the array equally. Since the pivot is the first element in the array, it will be the smallest element or the largest
 *			of each subarray. This will perform worst case O(n^2).As for random inputs, there is a higher possibility of the first element not being the smallest or largest element of the sub array which can partition the subarray. 
 *
 * 			For version 2b, measurements do not match my conjecture for increasing order since sorting all 3 lists were costly and the running time was over 1 million nanoseconds. I thought that since the pivot is random, there is a less likelychance of the pivot
 * 			being the first or last element. But it ended up being costly. 
 * 
 * 			For increasing order, if version 2a is O(n^2) it should be faster than version 1 and 2b. It is faster than version 1 but not version 2b. 
 * 			For decreasing order, if version 1 and 2a have higher big o, it should have been faster than 2b but it isnt. 
 * 			for random order, since version 1 has O(n^2), it hshould be faster than version 2a and 2b. It grows faster than 2a but not 2b. 
 * 			
 *************************************************************************/

import java.util.*;
public class Sort {
	
	// 1)Insertion Sort method
	public static void insertionSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 

	//QuickSort Method Version 2a
	//pivot from the first position of the subarray
	public static int partition(int arr[], int first, int end) {
	    int pivot = arr[first];
	    int low=first+1;
	    int high=end;
	    
	    while (high>low) {
	    	while(low<=high && arr[low]<=pivot)
	    		low++;
	    	while(low<=high && arr[high]>pivot) 
	    		high--;
	    	if (high>low) {
	    		int temp=arr[high];
	    		arr[high]=arr[low];
	    		arr[low]=temp;
	    	}
	    }
	    while(high>first && arr[high] >= pivot) {
	    	high--;
	    }
	 
	    if (pivot>arr[high]) {
	    	arr[first]=arr[high];
	    	arr[high]=pivot;
	    	return high;
	    }
	    else {
	    	return first;
	    }
	}
  

    public static void quickSort1(int arr[], int first, int last) 
    { 
        if (last > first) 
        { 
        	int pivot=partition(arr,first,last);
        	quickSort1(arr, first, pivot-1);
        	quickSort1(arr,pivot+1, last);
        } 
    }
       
    //QuickSort method version 2b

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
       //partition
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
       
      //Sort
      if (low < j)//sort smaller elements
          quickSort2(arr, low, j);
      if (high > i)//sort larger elements
          quickSort2(arr, i, high);
  	}
    
    
    
    
    
    //Test Program	  
	public static void main(String[] args) {
		//List with increasing order
		int n=100;
		int[] list1 = new int[n];
		for (int i = 0; i<list1.length;i++) {
			list1[i]=i;
		}
		
		//List with decreasing order
		int[] list2 = new int[n];
		int size=list2.length;
		
		for (int i = 0; i<size;i++) { //insertion numbers in increasing order
			list2[i]=i;
		}
		
		for (int i = 0; i < size ; i++)  //arranging the numbers in decreasing order
		{
			for (int j = i + 1; j < size; j++) 
			{
				if (list2[i] < list2[j]) 
				{
					int temp = list2[i];
					list2[i] = list2[j];
					list2[j] = temp;
				}
			}
		}

		
		//List with random inputs
		
		int[] list3 = new int[n];
		int size2 = list3.length;
		for (int i = 0; i<list3.length;i++) {
			list3[i]= (int) (Math.random()*size2);
		}
		
		
	
		//method calls 
		
		//Insertion Sort method calls 
        long startTime = System.nanoTime();
        Sort.insertionSort(list1);
        // display the time elapsed
        System.out.println("Insertion sort on list1 t = " + (System.nanoTime() - startTime) + " nanosecs.");
		
        startTime = System.nanoTime();
        Sort.insertionSort(list2);
        // display the time elapsed
        System.out.println("Insertion sort on list2 t = " + (System.nanoTime() - startTime) + " nanosecs.");
        
        startTime = System.nanoTime();
        Sort.insertionSort(list3);
        // display the time elapsed
        System.out.println("Insertion sort on list3 t = " + (System.nanoTime() - startTime) + " nanosecs.");
		
		
		//QuickSort1 Method Calls
		
        startTime = System.nanoTime();
        Sort.quickSort1(list1,0,list1.length-1);
        // display the time elapsed
        System.out.println("QuickSort version 2a on list1 t = " + (System.nanoTime() - startTime) + " nanosecs.");

        startTime = System.nanoTime();
        Sort.quickSort1(list2,0,list2.length-1);
        // display the time elapsed
        System.out.println("QuickSort version 2a on list2 t = " + (System.nanoTime() - startTime) + " nanosecs.");
        
        startTime = System.nanoTime();
        Sort.quickSort1(list3,0,list3.length-1);
        // display the time elapsed
        System.out.println("QuickSort version 2a on list3 t = " + (System.nanoTime() - startTime) + " nanosecs.");
		
        //QuickSort2 Method Calls
		
         startTime = System.nanoTime();
		Sort.quickSort2(list1, 0, list1.length-1);
        // display the time elapsed
        System.out.println("QuickSort version 2b on list1 t = " + (System.nanoTime() - startTime) + " nanosecs.");
       
        startTime = System.nanoTime();
		Sort.quickSort2(list2, 0, list2.length-1);
        // display the time elapsed
        System.out.println("QuickSort version 2b on list2 t = " + (System.nanoTime() - startTime) + " nanosecs.");
       
        startTime = System.nanoTime();
		Sort.quickSort2(list3, 0, list3.length-1);
        // display the time elapsed
        System.out.println("QuickSort version 2b on list3 t = " + (System.nanoTime() - startTime) + " nanosecs.");

        
		
			
		}

}
