/*
 * @author Aidan Lee
 * @version 1.0 10/8/2018
 * This class takes inputs from QuadracticClient and processes it to return Description of the
 * parabola with Open Direction, Axis of Symmetry, Vertex, X-intercept, and Y intercept.
 */
public class Quadractic {
	public static String quadrDescriber(double a, double b, double c) {
		String equation, openDirection, symmetry, vertex, xintercepts, yintercept;//declares many string variables to be used in Quadractic.java

		//1. Finds which direction the parabola opens, throws exception if a==0 b/c thats not a parabola
		if(a > 0) {
			openDirection = "Opens: Up\n";
		} else if (a== 0) {
			throw new IllegalArgumentException("Not a parabola. Enter a non-zero value for a. ");
		} else {
			openDirection = "Opens: Down\n";
		}
		
		//2. Educates user on what equation the program will be describing
		equation = "Description of the graph of:\ny= " + a + "x^2 + " + b + "x + " + c + "\n\n";
		
		//3. Calculates the line of symmetry and coordinates of the vertex
		double prevertexCordX = -b / (2*a); //Calculates the x coordinate of the vertex, also Line of Symmetry
		double vertexCordX = 0.0; //establishes a base value
		if(prevertexCordX == -0.0) { //this if statement resolves issues with outputs that are 0,0, since they seem to return (-0.0, 0.0)
			vertexCordX = absValue(prevertexCordX);
		} else {
			vertexCordX = prevertexCordX;
		}
		double vertexCordY = a * (vertexCordX * vertexCordX) + (b* vertexCordX) + c;//calculates the y value of the vertex by plugging in the x value of the vertex
		
		symmetry = "Axis of Symmetry: " + vertexCordX + "\n";//Assigns Line of Symmetry to string
		vertex = "Vertex: (" + vertexCordX + ", " + vertexCordY +")\n";//Assigns vertex coordinate to string vertex
		
		//4. X intercept
		xintercepts = "x-intercept(s): " + quadForm(a,b,c) + "\n";//calculates x intercept(s) of the quadractic equation and assigns to string xintercepts
		//5. y-intercept
		yintercept = "y-intercept: " + c + "\n";//calculates y intercept and assigns to string yintercept
		
		//Return
		String returnStatement =  equation + openDirection + symmetry
								  + vertex + xintercepts + yintercept;//assigns all the return strings to a sifngle string returnStatement
		return returnStatement;//returns output of quadrDescriber
	
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
			double positiveAnswer = (-b+sqrt((discriminant(a,b,c))))/(2*a);//calculates one of the x intercept
			double negativeAnswer = (-b-sqrt((discriminant(a,b,c))))/(2*a);//calculates the other x intercept
		
			
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