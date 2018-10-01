/* This class contains the methods to do various math related tasks.
 * @author Aidan lee
 * @version 3.1 9/12/2018
 */
public class Calculate {
	
	//Square method accepts an integer input and returns the square of the input
	public static int square(int input) { 
		return (input * input);
	}
	
	//Cube method multiples the input by itself twice and outputs the final answer
	public static int cube(int input) { 
		return (input * input * input);
	}
	
	//This Average method adds two double inputs together and divide it by 2. Can be overloaded.
	public static double average(double input1, double input2) {
		return ((input1 + input2)/2);
	}
	
	//This Average method adds three doubles inputs together and divides it by 3. Can be overloaded
	public static double average(double input1, double input2, double input3) {
		return ((input1 + input2 + input3 )/3);
	}
	
	//toDegrees method converts an input in radians to degrees
	public static double toDegrees(double radian) {
		double degree = radian * (180/3.14159);
		return degree;
	}
	
	//toRadians method converts an input in degrees to radians
	public static double toRadians(double degree) {
		
		double radian = degree * (3.14159/180);
		return radian;
	}
	
	//discriminant method finds the descriminant found in the quadractic equation with inputs a,b,c
	public static double discriminant(double a, double b, double c) {
		return (b*b)-(4*a*c);
	}
	
	//toImproperFrac method changes a mixed number into an improper fraction
	public static String toImproperFrac(int whole, int num, int denom) {
		return (whole * denom + num) + "/" + denom;
	}
	
	//toMixedNum method changes a improper fraction into a mixed number
	public static String toMixedNum(int num, int denom) {
		return (num /  denom ) + "_" +(num % denom) + "/" + denom;
	}
	
	//foil method expands a quadratic function given in x-intercept form (co1 + int1)(co2 + int2) to ax^2+bx+c including a inputted variable
	public static String foil(int co1, int int1, int co2, int int2, String var) {
		int ax = co1 * co2; //ax^2
		int bx = co1 * int2 + int1 * co2; //bx
		int c = int1 * int2; //c
		return ax + var + "^2 " + "+ " +bx + var +" + " + c;//output: ax^2+bx+c
	}
	
	//isDivisiblyBy method checks if a dividend is divisible by a divisor, in other words, is there a remainder
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if(divisor == 0) {
			throw new IllegalArgumentException("Cannot divide by zero!");
		}
		if(dividend % divisor == 0) { //is Divisible
			return true;
		} else {
			return false; //is not Divisible
		}
	}
	
	//absValue finds the absolute value of an input by multiplying it by -1 if needed
	public static double absValue(double input) {
		if(input > 0) {
			return input; //returns input if original input is already positive
		
		} else {
			return -1*input; //multiples by -1 to attain a positive value if original input was negative
		}
	}
	
	//This max method returns the larger of two inputs. Can be overloaded.
	public static double max(double val1,double val2) {
		if(val1 > val2) {
			return val1; //returns val1 if its bigger than val2
		}else { 
			return val2; //returns val2 if its bigger than val1
		}
	}
	
	//This max method returns the larger of three inputs. Can be overloaded.
	public static double max(double val1, double val2, double val3) {
		return max(val1, max(val2, val3)); //finds the largest input out of val1, val2, and val3
	}
	
	//min method finds the smallest input out of two values
	public static int min(int val1, int val2) {
		if(val1 < val2) {
			return val1; //returns val1 if val2 is bigger than val1
		} else {
			return val2; //returns val2 if its smaller than val1
		}
	}
	
	//round2 method returns the the input rounded to two decimal places
	public static double round2(double input) {
		double round;
		if(input < 0) {
			round = input - 0.005;//for negative inputs
		} else {
			round= input + 0.005;//for positive inputs
		}
		double pretruncate = round * 100;//multiples by 100 in preparation for a truncate
		double truncate = ((int) pretruncate) /100.0; //truncates the input and divides by 100 to return it to the correct places
		return truncate;//returns input rounded to two decimal places
	}
	
	
	//exponent method raises a value to a positive integer value
	public static double exponent(double base, int exp) {
		if(exp < 0) {
			throw new IllegalArgumentException("Please enter a positive exponent");
		}
		
		double answer =1;//assigns the answer to 1 since base^0=1
		for(int i = 0; i < exp; i++) {//runs for loop as many times as exp
			answer = answer * base;
		}
		return answer;
			
	}
	
	//factorial method returns the factorial of the value passed
	public static int factorial(int input) {
		if(input < 0) {
			throw new IllegalArgumentException("Cannot enter a negative factorial!");
		}
		
		int answer = input; //makes a variable to store the answer for for loop
		for(int i = 1; i < input; i++) {
			answer = answer * (input - i);//subtract i to decrement to do factorial...ie. 4*3*2*1
		}
		return answer;
	}
	
	//isPrime determines whether or not an integer is prime
	public static boolean isPrime(int input) {
		//According to google, 0 and 1 are not prime numbers
		if(input < 2) {//Less than 2 != prime
			return false;
			
		} else if(input == 2) { // 2 is prime, according to google, so return true
			return true;
		} else {
			for(int i= 2; i < input; i++) {//runs a for loop to test if all integers below the input to find if its divisible by
				if(isDivisibleBy(input, i)) {
					return false;//if its divisible by something other than itself, then its not a prime number
			}	
		}
		return true;
		}
	}
	
	//gcf methods finds the greatest common factor ofanswer two integers
	public static int gcf(int input1, int input2) {
		int answer = 1;	//declares inital value for  as 1 b/c 1 is always a gcf
		for(int i =1; i<=input1; i++) {//test for gcf for integers up to value of input1
			
			if(isDivisibleBy(input2, i) && isDivisibleBy(input1, i)) {//returns i into answer the highest value both inputs are divisible by
					answer = i;
				
			}
		}
		return answer;
	}
	
	//sqrt method returns the approximation of the square root of the value passed, rounded to two decimal places
	public static double sqrt(double input) {
	
		if(input < 0) {
			throw new IllegalArgumentException("Negative Input Recieved. Please input a positive number");
		}
		if(input ==0.0) {
			return 0.0;
		}
		double  guess=1;//initial guess value
	
		while(!(absValue(input -( guess * guess ))< 0.005)) { //makes sure different is positive and runs while loop if the difference is more than 0.005
			//uses absolute value so that the while loop can use positive numbers
			guess = (input / guess + guess)/2;//Newton's guessing square root method
	
		}
	return round2(guess);//uses round2 method to round output of above to two decimal places
	}
	
	//quadForm method returns the roots of a quadractic function in a String
	public static String quadForm(int a, int b, int c) {
		if(discriminant(a,b,c) < 0) {
			return "no real roots";
		}
		//Roots are + and -
		double p = -b+sqrt((discriminant(a,b,c)));
		double n = -b-sqrt((discriminant(a,b,c)));
		double positiveAnswer = p/(2*a);
		double negativeAnswer =n/(2*a);
		System.out.println(positiveAnswer);
		System.out.println(negativeAnswer);
		
		if(positiveAnswer == negativeAnswer) {
			return "" +positiveAnswer;//return either positive or negative because they are the same
			
		} else {
			if(max(positiveAnswer, negativeAnswer) == positiveAnswer) {
				return positiveAnswer + " and " + negativeAnswer;
				
			} else {
				return negativeAnswer + " and " + positiveAnswer;
			}
			
			
		}
		
		
		
		
	}

}