/*
 * @author Aidan Lee
 * @version 1.0 10/8/2018
 * This class takes inputs from QuadracticClient and processes it to return Description of the
 * parabola with Open Direction, Axis of Symmetry, Vertex, X-intercept, and Y intercept.
 */
public class Quadractic {
	public static String quadrDescriber(double a, double b, double c) {
		String equation, openDirection, symmetry, vertex, xintercepts, yintercept;

		//1. Open Direction
		if(a > 0) {
			openDirection = "Opens: Up\n";
		} else if (a== 0) {
			throw new IllegalArgumentException("Not a parabola. Enter a non-zero value for a. ");
		} else {
			openDirection = "Opens: Down\n";
		}
		
		//2. Equation 
		equation = "Description for Equation -- y= " + a + "x^2 + " + b + "x + " + c + "\n";
		
		//3. Symmetry and Vertex
		double prevertexCordX = -b / (2*a); //also Line of Symmetry
		double vertexCordX = 0.0;
		if(prevertexCordX == -0.0) {
			vertexCordX = absValue(prevertexCordX);
		} else {
			vertexCordX = prevertexCordX;
		}
		double vertexCordY = a * (vertexCordX * vertexCordX) + (b* vertexCordX) + c;
		
		symmetry = "Axis of Symmetry: " + vertexCordX + "\n";
		vertex = "Vertex: (" + vertexCordX + ", " + vertexCordY +")\n";
		
		//4. X intercept
		xintercepts = "x-intercept(s): " + quadForm(a,b,c) + "\n";
		//5. y-intercept
		yintercept = "y-intercept: " + c + "\n";
		
		//Return
		String returnStatement =  equation + openDirection + symmetry
								  + vertex + xintercepts + yintercept;
		return returnStatement;
	
	}

	
	
//NEEDED METHODS TO PROCESS QUADRACTIC
		public static double discriminant(double a, double b, double c) {
			return (b*b)-(4*a*c);
		}
		
		public static double absValue(double input) {
			if(input > 0) {
				return input; //returns input if original input is already positive
			
			} else {
				return -1*input; //multiples by -1 to attain a positive value if original input was negative
			}
		}
		
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
		
		public static double max(double val1,double val2) {
			if(val1 > val2) {
				return val1; //returns val1 if its bigger than val2
			}else { 
				return val2; //returns val2 if its bigger than val1
			}
		}
		
		public static String quadForm(double a, double b, double c) {
			if(discriminant(a,b,c) < 0) {
				return "no real roots";
			}
			//Roots are + and -
			double p = -b+sqrt((discriminant(a,b,c)));
			double n = -b-sqrt((discriminant(a,b,c)));
			double positiveAnswer = p/(2*a);
			double negativeAnswer =n/(2*a);
		
			
			if(positiveAnswer == negativeAnswer) {
				return "" +positiveAnswer;//return either positive or negative because they are the same
				
			} else {
				if(max(positiveAnswer, negativeAnswer) == positiveAnswer) {
					return "(" + positiveAnswer + ")"  + " and (" + negativeAnswer + ")";
					
				} else {
					return "("+ negativeAnswer +")" + " and (" + positiveAnswer + ")";
				}
			}	
		}
}