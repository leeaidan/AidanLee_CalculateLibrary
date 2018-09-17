/* This class contains the methods to do various math related tasks.
 * @author Aidan lee
 * @version 0 9/12/2018
 */
public class Calculate {
	
	public static int square(int number) { //returns square of an integer
		
		return (number * number);
	}
	
	public static int cube(int number) { //returns square of an integer
		
		return (number * number * number);
	}
	
	public static double average(double x1, double x2) {
		
		return ((x1 + x2)/2);
	}
	
	public static double average(double x1, double x2, double x3) {
		
		return ((x1+x2+x3)/3);
	}
	
	public static double toDegrees(double radian) {
		
		double degree = radian * (180/3.14159);
		return degree;
	}
	
	public static double toRadians(double degree) {
		
		double radian = degree * (3.14159/180);
		return radian;
	}
	
	public static double discriminant(double a, double b, double c) {
		return (b*b)-4*a*c;
	}
	
	public static String toImproperFrac(int whole, int num, int denom) {
		return (whole * denom + num) + "/" + denom;
	}
	
	public static String toMixedNum(int num, int denom) {
		return (num /  denom ) + "_" +(num % denom) + "/ " + denom;
	}
	
	public static String foil(int co1, int int1, int co2, int int2, String var) {
		int ax = co1 * co2;
		int bx = co1 * int2 + int1 * co2;
		int cx = int1 * int2;
		return ax + var + "^2" + "+" +bx + var +"+" + cx;
	}
	public static int absoluteValueInt(int inputInt) {
		if(inputInt < 0) {
			return -1*inputInt;
		}else {
			return inputInt;	
		}
	}
	
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if(dividend % divisor == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static double absValue(double input) {
		if(input > 0) {
			return input;
		
		} else {
			return -1*input;
		}
	}
	
	public static double max(double val1,double val2) {
		if(val1 > val2) {
			return val1;
		}else { 
			return val2;
		}
	}
	
	public static double max(double val1, double val2, double val3) {
		return max(val1, max(val2, val3));
	}
	
	public static int min(int val1, int val2) {
		if(val1 < val2) {
			return val1;
		} else {
			return val2;
		}
	}
	
	public static double round2(double input) { //method rounds double to 2 decimal places
		double checkRounding = input * 1000 % 10; //variable used to check thousandth place
		double inputmod = input * 1000;//variable to allow the use of % 10 for rounding
		//TODO:
		if((checkRounding) >= 5) {
			return ((inputmod) + 10 - (inputmod % 10))/1000;
		} else {
			return ((inputmod) - (inputmod % 10))/1000;
		}
			
	}
	
	public static double exponent(double base, int exp) {
		double answer = base;
		exp = exp -1;
		
		for(int i = 0; i < exp; i++) {
			answer = answer * exp;
		}
		return answer;
			
	}
	
	public static int factorial(int input) {
		int answer = input;
		for(int i = 1; i < input; i++) {
			answer = answer * (input - i);
		}
		return answer;
	}
	
	public static boolean isPrime(int input) {
		//According to google, 0 and 1 are not prime numbers
		if(input < 2) {
			return false;
			
		} else if(input == 2) { // 2= prime
			return true;
		} else {
			for(int i= 2; i < input; i++) {
				if(isDivisibleBy(input, i)) {
					return false;
			}	
		}
		return true;
		}
	}
	

	public static int gcf(int input1, int input2) {
		int answer = 1;	
		for(int i =1; i<=input1; i++) {
			
			if(isDivisibleBy(input2, i) && isDivisibleBy(input1, i)) {
					answer = i;
				
			}
		}
		return answer;
	}
	
	public static double sqrt(int input) {
		double answer =1;
	
		while(!(absValue(input -( answer * answer ))< 0.005)) { //makes sure different is positive and runs while loop if the difference is more than 0.005
			answer = (input / answer + answer)/2;
	
		}
	return round2(answer);
	}


}