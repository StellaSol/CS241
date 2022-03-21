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
 *   ------
 *   
 *   This is for extra credit. 
 *  														Running Times
 *   Iterative search              |	10^2	|	 10^3	|	10^4		|	10^5		|	150,000	
 *   Skewed BST		    		   |	103,349	|	115,478	|	331,935		|	2,905,427	| 	3,529,165	
 *   														Running Times
 *   search           			   |	10^2	|	 10^3	|	10^4		|	10^5		|	150,000	
 *   Balanced BST		   		   |	11,866	|	283,001	|	382,507		|	424,728		| 	1,627,510	
 *************************************************************************/
import java.util.Scanner;

public class ExtraCredit {
	public static void main(String[] args) {
        // Question3 Program
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter integer");
        int n = scan.nextInt(); //input integer n
        BinarySearchTree<Integer> S = new BinarySearchTree<Integer>();// creating BST S
        BinarySearchTree<Integer> B = new BinarySearchTree<Integer>();// creating BST B
        
        //Using for loop to insert each integer as a node of the tree
        for (int i=1; i<=n;i++) {
        	S.iterativeInsert(i);
        }

        // store the time now
        long startTime = System.nanoTime();
        S.iterativeContains(n+1);
        // display the time elapsed
        System.out.println("t = " + (System.nanoTime() - startTime) + " nanosecs.");
        
        
        //Question6 Program
        //Using for loop to insert each integer as a node of the tree
        for (int i=1; i<=n;i++) {
        	B.iterativeInsert(i);
        }
        
       int minNum = B.findMin(); //assigning the min to a variable to be used for preorder traversal
       int maxNum = B.findMax();////assigning the max to a variable to be used for preorder traversal
        ExtraCredit.seq(minNum, maxNum, B);
        //store the time now
        startTime = System.nanoTime();
        B.iterativeContains(n+1);
        // display the time elapsed
        System.out.println("t = " + (System.nanoTime() - startTime) + " nanosecs.");
        scan.close();


	}
    //static method to arrange the binary tree in pre order
    public static void seq(int min, int max, BinarySearchTree<Integer> myList ) {
		if(min<=max){
			int mid=(min+max)/2;
			myList.iterativeInsert(mid);
			seq(min, mid-1, myList);
			seq(mid+1, min, myList);
		}
 }		
}
