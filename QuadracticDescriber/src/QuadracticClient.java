import java.util.*;
/*
 * @author Aidan Lee
 * @version 1.0 10/8/2018
 * This Class gets inputs(a,b,c) from the user and sends it to quadDescriber. 
 * Then, it prints the return.
 */
public class QuadracticClient {
	public static void main(String [] args) {
		Scanner userInput = new Scanner(System.in); //Declares a new Scanner named userInput
		boolean continueInput = true;//boolean whether to close the Scanner
		System.out.print("Welcome to the Quadractice Describer Program\n" + "Please Enter coefficents a,b,c for a quadractic equation");
		
		double a;
		double b;
		double c;
		do {
			System.out.print("\na:");//Gets value of a and stores it
			a = userInput.nextDouble();
		
			System.out.print("\nb:");//gets value of b and stores it
			b = userInput.nextDouble();
		
			System.out.print("\nc:");//gets value of c and stores it
			c = userInput.nextDouble();
			
			System.out.println();
			System.out.println("a: "+ a + "\nb: " + b + "\nc: " + c + "\n");//prints out a,b,c to the user
			
			System.out.println("***Here are the results!***\n\n" + Quadractic.quadrDescriber(a, b, c));//prints out the description of the quadratic using return of method quadrDescriber
			
			System.out.println("Do you want to continue? (Type \"quit\" to end)");//quits if user types quit
			String quit = userInput.next();
			
			if(quit.equals("quit")) continueInput = false;
		} while(continueInput);
		
		userInput.close(); //closes Scanner because Eclipse's "!" symbol annoyed me
		
	
		
		
	}
}
