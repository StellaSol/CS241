/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team Authors: Stella Solano
 *  External Collaborators: NONE
 *  References: Weiss book
 *
 *  Assignment: Assignment4
 *  Problem: Highlight the difference in running time, creating a skewed BST and balanced BST
 *  Description: Both BST will execute with a large number of nodes and measure the execution time of searching on each BST
 *
 *  Input: int n
 *  Output: Running time of both trees
 *
 *  Visible data fields:
 *  NONE
 *
 *  Visible methods:
 *  public static void seq(int min, int max, BinarySearchTree<Integer> myList ) {
 *
 *
 *   Remarks
 *   -------
 *
 *  1) 
 *   		  		Skewed Tree 	| 	Balanced Tree
 *		Search	|		O(n)		| 		O(n)
 *		
 *	2) 
 *		I will use the contains method of the BST class. The method contains of the BST class has the contains method of the BinaryNode class which does the comparisons.
 *	   Skewed Tree: I estimated that the search is O(n) because since it is a skewed tree there is one path either it is a right skewed tree or left skewed tree. To go to each node,it will go to only one path which is the height of the tree. 
 *					So the height of the tree is O(n).
 *     Balanced Tree: I estimated that the search is O(n) because if the node that is being search for is not the root, then the method will proceed to do comparisons 
 *					between the left and the right child which will take O(n). It is not setting a midpoint in order to find the node. It is just comparing
 *					each node if it is greater or less than the child. The same running time is applied to all the nodes so it will take O(n).
 *     
 *  4)  		
 *  									Running Times
 *   search              |	10^2	|	 10^3	|	10^4	|	15000		|	22500	
 *   Skewed BST		     |	121173	|	152628	|	189537	|	207712		| 	235759	
 *   
 *   
 *  5)Skewed BST Running time analysis: Based on the running times, I think that the growth of my measurements do not match my conjecture because the running times increased logarithmically. From 10^2 to 10^3, the increase was 35059. From 10^3 to 10^4 the increase was 36909. 
 *  									Each n is increased by a constant multiple of 10 and those two outputs show that they increase in a constant interval between 31,000 nanoseconds and 36,000 nanoseconds.
 *  									I tried running 10^5 but the stack overflowed. I tried running 10^6 and it did the same thing. I also tried doing 25000 and to my surprised the stack over flowed.
 *  									So I used 15000 and 22500 because they are increased by a constant of 1.5. from 10^4 to 22,500 the time increase 18175. From 15,000 to 22,500 the time increased 15187. As a result, they had the same interval between 15,000 and 18,000 nanoseconds.
 *  									I looked back to the contains method to investigate the reason why the method is O(logn). Although the contains method compares every node, I did not take in account that it recursively calls itself again in order 
 *  									for the nodes to be compared. 
 *  								
 *  									
 *  7)  		
 *  									Running Times
 *   search            	 |	10^2		|	 10^3	|		10^4		|	15000		|	22500	
 *   Balanced BST		 |	10533		|	11471	|		12024		|	13503		| 	15120	    
 *   
 *   
 *   8)Balanced BST Running time analysis: Based on the running times, the measures do not match my conjecture. From 10^2 to 10^3, the running time increased 938 nanoseconds. from 10^3 to 10^4, the running time increased
 *   										553 nanoseconds. From 10^4 to 15000, the running time increased 1479 nanoseconds. From 150000 to 22,500, the running time increased 1617. The running times have the same input which is a constant that is until 15,000 and 22,5000 which had a constant multiplied by 1.5.
 *   										They both have the same intervals of 500-900 nanoseconds for those inputs with a constant of 10. As for the inputs with 15,000 and 22,500 they have a constant interval of 1,400-1600 nanoseconds. This data shows that the running time was again O(log(n)).
 *************************************************************************/
import java.util.Scanner;

public class BSTDriver {

	public static void main(String[] args) {
        // Question3 Program
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter integer");
        int n = scan.nextInt(); //input integer n
        BinarySearchTree<Integer> S = new BinarySearchTree<Integer>();// creating BST S
        BinarySearchTree<Integer> B = new BinarySearchTree<Integer>();// creating BST B
        
        //Using for loop to insert each integer as a node of the tree
        for (int i=1; i<=n;i++) {
        	S.insert(i);
        }

        // store the time now
        long startTime = System.nanoTime();
        S.contains(n+1);
        // display the time elapsed
        System.out.println("t = " + (System.nanoTime() - startTime) + " nanosecs.");
        
        
        //Question6 Program
        //Using for loop to insert each integer as a node of the tree
        for (int i=1; i<=n;i++) {
        	B.insert(i);
        }
        
        int minNum = B.findMin(); //assigning the min to a variable to be used for preorder traversal
        int maxNum = B.findMax();////assigning the max to a variable to be used for preorder traversal
        BSTDriver.seq(minNum, maxNum, B);
        //store the time now
        startTime = System.nanoTime();
        B.contains(n+1);
        // display the time elapsed
        System.out.println("t = " + (System.nanoTime() - startTime) + " nanosecs.");
        scan.close();

	}
    //static method to arrange the binary tree in pre order
    public static void seq(int min, int max, BinarySearchTree<Integer> myList ) {
		if(min<=max){
			int mid=(min+max)/2;
			myList.insert(mid);
			seq(min, mid-1, myList);
			seq(mid+1, min, myList);
		}
 }
}
