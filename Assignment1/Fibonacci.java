/*************************************************************************
 *
 *  Pace University
 *  Fall 2019
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team Authors: Stella Solano
 *  External Collaborators: NONE
 *  References: https://mathbitsnotebook.com/Algebra1/Functions/FNSequenceFunctions.html (I used the explicit Fibonacci formula in order to write my code for extra credit)
 *				Weiss book, Class Notes
 *  Assignment: Assignment 1
 *  Problem: Running time measurements consistent with Big-O
 *  Description: Analysis of the running times of recursive, non-recursive, and method that takes O(1) space
 *
 *  Input: nextInt to input an integer
 *  Output: Running time of method in nanosecs
 *
 *  Visible data fields:
 *  NONE
 *
 *  Visible methods:
 *  Fibo1: Recursive method that returns the Fibonacci number
 *  Fibo2: Non-Recursive method that returns the Fibonacci number
 *  Fibo3: Method that uses O(1) Space
 *  
 *
 *
 *   Remarks
 *   -------
 *		
 *   2) 
 *    															Running Time
 *   n              |	0		|	1		|	2		|	4		|	8	|	16		|	32			|	40			|	45
 *   recursive      |	50789	|	40714	|	41862	|	49092	| 77010	|	445483  |	13809945	|	392221024	|	4307872483
 *   non recursive  |	3039	|	4385	|	5032	|	6669	| 7145	|	8122	|	6210		|	5823		|	5951
 *   O(1) method    |	421712	|	362796	|	416147	|	345725	|465094	|	404799	|	325021		|	403267		|	377862
 *   
 *   
 *   3a) Running Time for the recursive method:
 *   The method consists of an if and else statement.In order to obtain the running time of the method, we take the highest running time between both if and else statements.
 *   The if statement has the running time of O(1) because it only returns a statement. As for the else statement it consists of a return statement that computes F(n-1) + F(n-2). 
 *   This suggests that the running time will increase exponentially. The Big O would be O(2^n).I came to this conclusion because the functions calls on itself twice through f(n-1) and f(n-2).
 *  			 f(n-1) 	+		f(n-2)
 *  		f(n-2)+	f(n-3)		f(n-3)+f(n-4)
 *  and so on. This will become like a pyramid and continue to double by a factor of 2 to the n power as it goes down. 
 *   
 *   
 *   b) My measurements were consistent with the fact that the running time increased exponentially. Looking at row recursive, n=0 to n=1, the running time dropped by 10,000 nanoseconds. From n=1 to n=2, 
 *   the running time increased by 1000 nanoseconds. From n=4 to n=8, the running time increased by 28000 nanoseconds. After n=8, the the running time drastically increased to over million nanoseconds.
 *   I put more input values for n because i tried to do 64 but it didn't even run. I tried 50 and that did not even run either. I wanted to see what the running times were for higher values than 32. From n=32 to n=40,
 *   it drastically increased to around 400 million nanoseconds. For n=45, the running time was around 4 billion nanoseconds. This  drastic increase concludes that it is not O(x^2) but (O(2^n). 

 *   
 *   c) Running Time for non recursive method:
 *   if statement: O(1) because the the statement is just a base case which only returns n if n<=1. 
 *   else statement:There is 3 assignment statements and a return statement prior to the For loop for which they will have a running time of O(1)
 *   The For loop's running time is the # of iterations * the running time of the body. The body of the for loop contains
 *   3 consecutive assignment statements. Each consecutive statement would have a 
 *   running time of O(1). Since this For loop has three consecutive statements, the running time of the entire For loop would be O(n * 3) 
 *   The running time of the whole method would be O(3n) + 4.
 *   The else statement has the fastest Big O.  Excluding constants, the running time is O(n).
 *   
 *   
 *   d) Measurements are consistent with the big O running time. 
 *   Looking at the row non recursive, from n=2 to n=4, the running time increments
 *   by 1000 nanoseconds. This 1000 nanosecond increment is also similar from n=4 to n=8 and n=8 to n=16. But when it comes to when n=32,
 *   apparently running time was faster in comparison to when n=4. This is quite interesting because as n was getting larger, the running time 
 *   was getting large as well, that is until n=32. So the function of my measurements would have been estimated as 1000x + 3039 which is a linear function and thus this is consistent with O(n).
 *   
 *   4) Running Time Analysis for method that uses O(1) space:
 *   The worst case Big-O running time in respect to n would be O(1) because the method Fibo3 contains consecutive print statements and a return statement. 
 *   Analysis: In comparison to the other methods, the method that supposedly takes O(1) space took much longer than the recursive method and non-recursive method.
 *   I believe this is due to the Math class being invoked in the print statements which will take more time.
 *   Looking at row O(1) method, from n=0 to n=1, the running time decreases by 60,000 nanoseconds. from n=1 to n=2, it increased by 53,000 nanoseconds. As the input increases, the average  difference of running time
 *   between each input is around 50,000 - 70,000 nanoseconds. The measurements is not as consistent because I expected the running times to be around the same but the running times either decrease or increase by 60,000 nanoseconds.
 *   The running time does not seem to increase exponentially or have a linear pattern. It is consistent to an extent because overall, the running times
 *   were between 30,000 nanoseconds and 40,000 nanoseconds, but it is not the perfect method that uses O(1) space. 
 *   
 *   
 *  
 *   
 *
 *
 *************************************************************************/


import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
        // store the time now
        long startTime = System.nanoTime();
        Fibo1(n); //Recursive Method  
        
        // display the time elapsed
        System.out.println("t = " + (System.nanoTime() - startTime) + " nanosecs.");
        
        // store the time now
        long startTime1 = System.nanoTime();
		Fibo2(n); //Non-Recursive Method
		
        // display the time elapsed
        System.out.println("t = " + (System.nanoTime() - startTime1) + " nanosecs.");
        
        long startTime2 = System.nanoTime();
		Fibo3(n); //Method that takes O(1) space
		
        // display the time elapsed
        System.out.println("t = " + (System.nanoTime() - startTime1) + " nanosecs.");
        scan.close();
       
		
	}
	
	public static int Fibo1(int n) { //Recursive
		if (n <= 1) { //Base case if user inputs a number <=1 
			return 1;
		}

		
		else {
			return Fibo1(n-1) + Fibo1(n-2); //Recursive formula of Fibonacci numbers. Method calls on itself
		}
	}
	
	
	public static int Fibo2(int n) {	//non-recursive
		if (n <= 1) { //Base case if user inputs a number <=1 
			  return 1;
		}

		
		else {
			 int num1 = 0;  //variable for previous term: n-1
			 int num2 = 0; 	//variable for n-2
			 int fiboNum = 1;//the result 
			 
			 for(int i = 1; i < n; ++i){ 
				 
				 num2 = num1; //stores the (n-2)th term to num2 because every iteration will have a different previous number
				 num1 = fiboNum; //After each iteration, fiboNum is stored as the previous term
				 fiboNum = num1 + num2; //Adds (n-1)th term to (n-2)th term
			 
			 }
			 return fiboNum;
			}
	}


	public static double Fibo3(int n) { // Method for O(1) running time
		double numerator = Math.pow((1+Math.sqrt(5)), n) - Math.pow((1-Math.sqrt(5)), n); // (1+5^1/2)^x - 1-5^1/2)^x 
		double denominator = Math.pow(2, n) * Math.sqrt(5); // 2^x * 5^1/2
		return Math.floor(numerator/denominator); // rounded the decimal down so it can be a whole number
    }
	}
	
	
	


