
/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team Authors: Stella Solano
 *  External Collaborators: NONE
 *  References: Java Programming by Liang
 *  			https://docs.oracle.com/javase/tutorial/extra/generics/methods.html - Used to figure how the method signatures should be for a generic type array list  
 *				Lecture 20: Arrays from CS121- Used it to reference the for each version of the for loop to process array elements for the methods union, intersection, and difference
 *  			https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 *  			Weiss Book, Class Notes
 *
 *  Assignment: Assignment#2
 *  Problem: Implement a set as a data structure
 *  Description: Creating a generic type T using the ArrayList<T> and analyzing the running times
 * 
 *  Input: integers
 *  Output: String toString of SetA and SetB
 *  		System.out.println("Union of SetA and SetB: "+ union);
			System.out.println("Intersection of SetA and Set: "+ intersection);
			System.out.println("SetA - SetB: "+ difference);
			System.out.println("SetB - SetA: "+ difference2);
 *  		
 *
 *  Visible data fields:
 *  NONE
 *
 *  Visible methods:
 *  public void add(T item)
 *  public void remove(T item)
 *  public Boolean membership(T item)
 *	public static <T> Set<T> getUnion(Set<T> set1, Set<T> set2)
 *	public static <T> Set<T> getIntersection(Set<T> set1, Set<T> set2)
 *	public static <T> Set<T> getDifference(Set<T> set1, Set<T> set2)
 *	public ArrayList<T> getValues()
 *	public String toString()
 *
 *   Remarks
 *   -------
 *
 *	3) 	Running Times in the Worst Case
 *						Array List		|		Linked List
 *		add			|		O(n)		|		O(n)
 *		remove		|		O(n)		|		O(n)
 *		membership	|		O(n)		|		O(n)
 *		toString	|		O(n)		|		O(n)
 *
 *	4)Analysis of running times of the methods:
 *		Array List:
 *		1)add- The add method of Set is implemented with an if statement that has the method call contain from ArrayList. When the statement returns false,
 *				the add method from ArrayList will be invoked. Thus, the running time of the add method is O(n) because the same bound of the running time of the method Add from ArrayList is invoked.
 *				Also, considering the fact that when the ArrayList is full, the array needs to be resized and copied into another array. Thus, in the worst case, the running time is O(n)
 *		
 *		2)remove-The remove method of Set is implemented with an if statement that has the method call contain from ArrayList. When the statement returns true,
 *				 the remove method from ArrayList will be invoked. Thus, the running time of the remove method is O(n) because the same bound of the running time is applied 
 *				 to the method remove in the the Java ArrayList. Removing an item in an array list will shift the elements and decrease the index. 
 *
 *		3)membership- The membership method of Set is implemented with the contains from the ArrayList. Thus, the running time is O(n). The contains method scans the entire Array List and returns true if the element is there. 
 *					The time is linear because it is proportional to its size. The more elements the ArrayList has, the more time it will take to iterate through to find the element. 
 *						
 *		4)toString- The toString returns a string representation which consists of a list of the collection's elements in the order they are returned by its iterator.
 *					Elements are converted to strings as by String.valueOf(Object). Thus, the running time of the toString would be O(n * number of nodes) which is just O(n).
 *					It depends on how many elements are needed to returned as a string representation. 
 *
 * 		Linked List:
 *		1)add- The running time is O(n) because it is proportional to the size of the link list. If a linked list were to invoke the add method of the Set<T> class, the add method would be implemented with the 
 *				method call add of Linked List which has a running time of O(n). Thus, the add method would have the same bound of running time as the method add of Linked List. This is due to the fact that it is adding the element
 *				to the end of the linked list. The list needs to e traversed in order to add to the end of the list and that is why it is O(n).
 *
 *		2)remove-The running time is O(n) because just like the add method of the LinkList, the running time is  proportional to the size of the list since it is removing the last element of the list. The remove method would have the same bound of running time as the add method because
 *				deletion of an element requires traversing the list in order to remove the last node.  
 *
 *		3)membership-If the linked list were to invoked the membership method which implements the contains method of LinkedList, the entire LinkedList will be scanned from the beginning to search for the element and then returns true if the element is there. 
 *					The time is linear because it is proportional to the size of the linked list. The more the elements the list has, the longer it will take it to iterate through the list to find the element. 
 *
 *		4)toString-The toString returns a string representation which consists of a list of the collection's elements in the order they are returned by its iterator. Elements are converted to strings as by String.valueOf(Object). Thus, the running time of the toString would be O(n * number of nodes) which is just O(n).
 *
 *
 *
 *
 *************************************************************************/

import java.util.*;

public class Set<T> {
	// data fields
	private ArrayList<T> myList;

	// constructors
	Set() {
		myList = new ArrayList<T>();
	}

	// other methods
	public void add(T item) {
		if (!myList.contains(item))
			myList.add(item);
	}

	public void remove(T item) {
		if (myList.contains(item)) {
			myList.remove(item);
		}

	}
	
	public Boolean membership(T item) {
		boolean test = myList.contains(item);
		return test;
	}

	public ArrayList<T> getValues() {
		//Stores the values of the ArrayList so it can be retrieved in other method calls
		return myList;
	}

	public static <T>Set<T> getUnion(Set<T> setA, Set<T> setB) {
		// this array will store the union of both setA and setB
		Set<T> result = new Set<>();
		// processes each elements in setA and adds each item to the ArrayList result
		for (T item : setA.getValues()) {
			result.add(item);
		}
		//processes each elements in setB and adds each item to ArrayList result
		for (T item : setB.getValues()) {
			result.add(item);
		}
		return result;
	}

	public static <T> Set<T> getIntersection(Set<T> setA, Set<T> setB) {
		// this array will store the intersection of both setA and setB
		Set<T> result = new Set<>();
		// processes each elements in setA 
		for (T item : setA.getValues()) {
			// if the element in setB is also present in setA, that element from setB will be added to Arraylist result
			// uses the membership method because it already has the contain method of ArrayList
			if (setB.membership(item)) {
				result.add(item);
			}
		}
		return result;
	}

	public static <T> Set<T> getDifferenceOfSetA(Set<T> setA, Set<T> setB) {
		// this array will store the difference of SetA
		Set<T> result = new Set<>();
		// processes each elements in setA and adds it to the ArrayList result
		for (T item : setA.getValues()) {
			result.add(item);
		}
		// Remove all the elements of SetB and the elements shared by SetA and SetB
		for (T item : setB.getValues()) {
			result.remove(item);
		}
		return result;
	}
	
	public static <T> Set<T> getDifferenceOfSetB(Set<T> setA, Set<T> setB) {
		// this array will store the difference of SetB
		Set<T> result = new Set<>();
		// processes each elements in setB and adds it to the ArrayList result
		for (T item : setB.getValues()) {
			result.add(item);
		}
		//Remove all the elements of SetA and the elements shared by SetA and SetB
		for (T item : setA.getValues()) {
			result.remove(item);
		}
		return result;
	}
	
	public String toString() {
		return myList.toString();
	}

}
	class testSet {

	public static void main(String[] args) {
		Set<Integer> setA = new Set<>(); // Creates an empty setA of integers
		Set<Integer> setB = new Set<>();// Creates an empty setB of integers
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter integers. Enter done to stop.");
		
		//Loop returns true if the next token in this scanner's input is an int value
		//Scans the integers and adds integer to SetA ArrayList
		while (scan.hasNextInt()) { 
			int i = scan.nextInt();
			setA.add(i);
		}
		
		System.out.println("SetA : "+setA.toString()); //Prints ArrayList
		scan.next(); // consume input
		
		System.out.println("Enter integers to remove. Enter done to stop");
		//Loop returns true if the next token in this scanner's input is an int value
		//Scans integers and invokes the method remove to remove the integers from SetA Arraylist
		while (scan.hasNextInt()) {
			int i = scan.nextInt();
			setA.remove(i);
		}

		scan.next(); // consume input
		System.out.println("SetA After removing elements: " +setA.toString());//Prints ArrayList"
				
		
		
		System.out.println("Enter integer to check if it is in the set");
		//Scans one element to check if the element is in the SetA
		int i = scan.nextInt();
		System.out.println(setA.membership(i));

		System.out.println("\nEnter integers for set B. Enter done to stop."); 
		//Loop returns true if the next token in this scanner's input is an int value
		//Scans the integers and adds integer to SetB ArrayList
		while (scan.hasNextInt()) {
			int num = scan.nextInt();
			setB.add(num);
		}
		System.out.println("SetB : "+setB.toString());//Prints ArrayList
		
		//Method Calls of union, intersection, and difference
		Set<Integer> union = Set.getUnion(setA, setB);
		Set<Integer> intersection = Set.getIntersection(setA, setB);
		Set<Integer> difference = Set.getDifferenceOfSetA(setA, setB);
		Set<Integer> difference2 = Set.getDifferenceOfSetB(setA, setB);
		
		LinkedList<Integer> myList = new LinkedList<Integer>();
		for (i=0; i<=100;i++) {
			myList.add(i);
		}
		
		
		System.out.println("Union of SetA and SetB: "+ union);
		System.out.println("Intersection of SetA and SetB: "+ intersection);
		System.out.println("SetA - SetB: "+ difference);
		System.out.println("SetB - SetA: "+ difference2);
		
		System.out.println(myList);
		myList.add(217);
		myList.add(214);
		myList.remove();
		System.out.println(myList);

		scan.close(); 
	}

}
