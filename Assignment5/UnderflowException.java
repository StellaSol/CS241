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
 *  Input: NONE
 *  Output: NONE
 *
 *  Visible data fields:
 *  None 
 
 *  Visible methods:
 *  NONE
 *
 *
 *   Remarks
 *   -------
 *   NONE
 *
 *************************************************************************/
class UnderflowException extends RuntimeException {
	public UnderflowException() 
	{}

	public UnderflowException(String message) {
		super(message);
	}

}