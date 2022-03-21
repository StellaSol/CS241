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
 *  Input: NONE
 *  Output: NONE
 *
 *  Visible data fields:
 *  NONE
 *
 *  Visible methods:
 *  NONE
 *
 *
 *   Remarks
 *   -------
 *   underflowException for BinarySearchTree Class
 *************************************************************************/
class UnderflowException extends RuntimeException {
	public UnderflowException() 
	{}

	public UnderflowException(String message) {
		super(message);
	}

}