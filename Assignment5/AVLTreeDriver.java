/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team Authors: Stella Solano
 *  External Collaborators: NONE
 *  References: Weiss book, http://wmueller.com/precalculus/families/1_32.html,https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html
 *
 *  Assignment: Assignment 5
 *  Problem: Running times of insertion and query performance
 *  Description: Comparing the running times of insertion and query performance of a separate-chaining hash table and AVL Tree
 *
 *  Input: Integer num
 *  Output: Running times of insertions and search of oth hash tale and avl tree
 *
 *  Visible data fields:
 *  None 
 *
 *  Visible methods:
 *	void insert( x )       --> Insert x
 *	void remove( x )       --> Remove x (unimplemented)
 *	boolean contains( x )  --> Return true if x is present
 *	boolean remove( x )    --> Return true if x was present
 *	Comparable findMin( )  --> Return smallest item
 * 	Comparable findMax( )  --> Return largest item
 * 	boolean isEmpty( )     --> Return true if empty; else false
 * 	void makeEmpty( )      --> Remove all items
 *  void printTree( )      --> Print tree in sorted order
 *
 *
 *   Remarks
 *   -------
 *   
 *   1) Hash Table -
 *   	a) I think that the time complexity of inserting all items would take O(n^2). Insertion of one i For every insertion, a linked list will be declared and will implement the hash function on the item. A loop would iterate
 *   	through the list and check if the x item is contained in the list and if the item is not contained in the list, the item would be added. If the current size exceeds the list length, the rehash() method would be implemented.
 *   	The rehash method consists a new array which is allocated and is resized to the next prime number. 
 *   	
 *  	b) I think query time in a hash table is O(n). The search method consists of using the hash function to determine which list to traverse. The search method would then use a loop to iterate through the list to check if the item is contained in the list. This will take O(n) 
 *  		because it is proportional to how many items are in the list. 
 *   
 *   2) AVL Tree-  
 *   	a) I think that the time complexity for inserting n entries is O(logn). This will take O(logn) because the AVL insertion has to traverse the tree from the root to the location where it is going 
 *   		to be inserted and then it has to traverse back to the root to rebalance. 
 *   	b) I think that the time complexity for search a key that is not in a tree is also O(logn). The AVL method contains compares the item that is being searched for with the root. Since the tree is already balanced, the search will either go to the left child or the right child, splitting the tree in half. This will continue until it reaches null. 
 *   		Like a phone book, for every search is made, it is restricted to one half of the search space every time. 
 *   
 *   3)  
 *     									
 *   construction time   |	n=10^2	|	 n=10^3		|	n=10^4		|	n=10^5		|	n=10^6	
 *   HashTable		     |	121,861	|	1,111,812	|	6,541,863	|	18,835,777	| 	149,076,433	
 *   Tree			     |	25,885	|	258,394		|	1,819,131	|	12,914,263	| 	148,587,757	
 *   
 *   
 *   search time 		 |	n=10^2	|	 n=10^3	|	n=10^4		|	n=10^5		|	n=10^6	
 *   HashTable		     |	85,194	|	328,562	|	2,580,283	|	5,704,566	| 	15,065,641	
 *   Tree			     |	2,623	|	2,688	|	2,712		|	2,777		| 	2,890	
 *	
 *	4) 
 *	Hashtable:
 *		Insertion- Measurements for insertion time match my conjecture. From n=10^2 to n=10^3, the time increased by by 1 million nanoseconds. From n=10^3 to n=10^4, the time increased by 
 *					5 million nanoseconds. From n=10^4 to n=10^5, the time increased by 12 million nanoseconds. From n=10^5 to n=10^6, the time increased by over 100 million nanoseconds. 
 *					This shows exponential growth. This is due to the fact that the measurement is based on the running time of inserting all items. 
 *
 *		Search- Measurements for search time match my conjecture. In order for it to be logarithmic, since the input is multiplied by a constant interval of 10, the output should have somewhat a constant interval as well.
 *				From n=10^2 to n=10^3, the time increased by 240,000 nanoseconds. From n=10^3 to n=10^4, time increased by 2 million nanoseconds. From 
 *				n=10^4 to n=10^5, the time increased by 3 million nanoseconds. From n=10^5 to n=10^6, the time increased by 10 million nanoseconds. 
 *				These measurements show that it is a linear trend. As the input increases, the times increased as well. For example, i calculated the rate of change for each and its around 20-200 nanoseconds. It is not the perfect rate of change but the bounds are close to each other. 
 *				Since it is traversing the list, it will just take O(n) depending on the number of items already in the list. Thus, the search time is O(n).
 *
 *
 * 	AVL Tree: 
 *		Insertion-Measurements for insertion time does not match my conjecture. In order for the measurements to be a logarithmic trend, since the input is increased by a constant multiple of 10, then the output has to be increased by a constant interval. 
 *				Output times do not show any constant interval. From n=10^2 to n=10^3, the time increased by 200,000 nanoseconds. From n=10^3 to n=10^4, the time increased by almost a million nanoseconds.
 *				From n=10^4 to n=10^5, the time has increased by 10 million nanoseconds. From n=10^5 to n=10^6, the time has increased by 100 million nanoseconds. This is not a logarithmic trend, but an exponential trend. 
 *				I realized that the method is in a for loop so it will take O(nlogn) to insert all items. 
 *
 *		Search- Measurements for query time do match my conjecture. Since the input n is increased by a constant multiple of 10, the output was increased by a somewhat constant interval.
 *				From n=10^2 to n=10^3, the time increased by 65 nanoseconds. From n=10^3 to n=10^4, the time increased by 24 seconds. From n=10^4 to n=10^5, the time has increased by 65 seconds.
 *				From n=10^5 to n=10^6, the time increased by 100 seconds. Although it is not a perfect constant interval, for each input that is raised by a constant multiple of 10, the output is increased by an interval that is less than 100 nanoseconds.
 *				This suggests that it is showing a logarithmic trend. Thus, search time in an AVL tree is O(logn). 
 *				
 *
 *************************************************************************/
import java.util.Hashtable;
import java.util.Scanner;

public class AVLTreeDriver {

	public static void main(String[] args) {
        //Question3 Programs
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an integer");
        int num = scan.nextInt();
      
        //Hashtable
        Hashtable A = new Hashtable(1000, (float) .75);
        
        //store the time now
        long startTime = System.nanoTime();
        for (int i=0;i<=num;i++) {
        	A.put(i, i); //insertion
        }     
        // display the time elapsed
        System.out.println("Hashtable insertion t = " + (System.nanoTime() - startTime) + " nanosecs.");

        //store the time now
        startTime = System.nanoTime();
        A.contains(num+1);//search
        // display the time elapsed
        System.out.println("Hashtable search t = " + (System.nanoTime() - startTime) + " nanosecs.");
        
        //AVL tree
        AvlTree<Integer> B = new AvlTree<Integer>();
        
        //store the time now
        startTime = System.nanoTime();
        for (int i=0;i<=num;i++) {
        	B.insert(i);//insertion
        }
        // display the time elapsed
        System.out.println("AVL Tree insertion t = " + (System.nanoTime() - startTime) + " nanosecs.");
        
        //store the time now
        startTime = System.nanoTime();
        B.contains(num+1);//search
        // display the time elapsed
        System.out.println("AVL Tree search t = " + (System.nanoTime() - startTime) + " nanosecs.");
        
        scan.close();

	}

}
