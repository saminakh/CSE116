package lab1c;

import java.util.*;

public class Lab1c {
	public static void main(String[] args){
		System.out.println("Usage: enter a, b & c from a quadratic equation.");
		System.out.println("  aX^2 + bX + c = 0");
		System.out.println("  Result will be 2 values for X");
		
		Scanner in = new Scanner(System.in);
		double a = 0;
		double b = 0;
		double c = 0;
		double x1 = 0;
		double x2 = 0;
		double x1Comp = 0;
		double x2Comp = 0;
		double discrim = 0;
		boolean badInputa = true;
		boolean badInputb = true;
		boolean badInputc = true;
		
		System.out.println("Please enter values for a, b and c.");

		while(badInputa){
			try{
				a = in.nextDouble();
				if(a==0){
					System.out.println("Please provide a non-zero input for a!");
				}
				else{
					badInputa = false;
				}
			}
			catch(InputMismatchException E){
				System.out.println("Please provide a valid input for a!");
				in.next();
			}

		}
		while(badInputb){
			try{
				b = in.nextDouble();
				badInputb = false;
			}
			catch(InputMismatchException E){
				System.out.println("Please provide a valid input for b!");
				in.next();
			}
		}
		while(badInputc){
			try{
				c = in.nextDouble();
				badInputc = false;
			}
			catch(InputMismatchException E){
				System.out.println("Please provide a valid input for c!");
				in.next();
			}
		}

		
		discrim = b * b - 4.0 * a * c;
		//non-complex values

		//check for complex values
		if(discrim<0){
			System.out.println("You have complex roots!");
	/*		x1Comp = (Math.sqrt(-discrim));
			a = 2.0*a;
			x2Comp = (Math.sqrt(-discrim));
			if(b==0){
				System.out.println("The first value of X is i("+x1Comp+")/"+a);
				System.out.println("The second value of X is -i("+x1Comp+")/"+a);
			}else{
				System.out.println("The first value of X is ("+(-b)+" + i("+x1Comp+"))/"+a);
				System.out.println("The second value of X is ("+(-b)+" - i("+x1Comp+"))/"+a);				
			} */
			
		}else{
			x1 = (-b + Math.sqrt(discrim)) / 2.0 * a;
			x2 = (-b - Math.sqrt(discrim)) / 2.0 * a;
			System.out.println("The two values for X are " + x1 + " and " + x2);
			return;
		}
		
	}

}
