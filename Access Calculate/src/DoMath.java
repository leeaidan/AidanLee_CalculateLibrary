/*Client Code for the Calculate Library
 * Calls various methods in the calculate library
 * @author Aidan
 * @version 3.1 9/12/2018
 */

public class DoMath {
	public static void main(String [] args) {
		System.out.println(Calculate.square(-3));//returns square of -3 = 9
		System.out.println(Calculate.discriminant(1, 2, 3));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.foil(2, 3,6, -7, "n"));
		System.out.println(Calculate.isDivisibleBy(10, 1));
		System.out.println(Calculate.round2(-1.568));
		System.out.println(Calculate.max(2,3,1));
		/*System.out.println(Calculate.exponent(2, 3));
		System.out.println(Calculate.factorial(4));
				
		*/
		System.out.println(Calculate.isPrime(13));	
		System.out.println(Calculate.gcf(6,18));
		System.out.println(Calculate.sqrt(-1.44));
		
	
	}

}
