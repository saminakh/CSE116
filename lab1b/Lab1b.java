package lab1b;

import java.util.*;

import javax.swing.JOptionPane;

public class Lab1b {
	
	private static int sideA = 0;
	private static int sideB = 0;
	
	public static void main(String[] args){
		System.out.println("Usage: Supply 2 integer values as triangle sides.");
		System.out.println("  A - integer value");
		System.out.println("  B - integer value");
		System.out.println("  C - attempt a pythagorean calculation");
		System.out.println("  Q - quit the program");
		System.out.println("");
		
		String value;
		String side;
		boolean carryOn = true;
		
		while(carryOn){
			
			side = JOptionPane.showInputDialog(null, "A or B?");
			if (side.compareTo("A") == 0 || side.compareTo("B") == 0 || side.compareTo("C") == 0 || side.compareTo("Q") == 0){
				
			switch(side){
			case "Q":	//quit program
				carryOn = false;
				break;
			case "A":	//side A
				value = JOptionPane.showInputDialog(null, "Enter A");
				try{
					sideA = Integer.parseInt(value);
					System.out.println("You have entered A as "+sideA);	
					if(sideA == 0){
						System.out.println("You have not entered a valid input for A! Please provide a positive, non-zero integer.");
						sideA = 0;
					}
				} catch(NumberFormatException NF){
					System.out.println("You have not entered a valid input for A! Please provide a positive, non-zero integer.");
					sideA = 0;
				}
				break;
			case "B":	//side B
				value = JOptionPane.showInputDialog(null, "Enter B");
				try{
					sideB = Integer.parseInt(value);
					System.out.println("You have entered B as "+sideB);	
					if(sideB == 0){
						System.out.println("You have not entered a valid input for B! Please provide a positive, non-zero integer.");
						sideB = 0;
					}
				} catch(NumberFormatException NF){
					System.out.println("You have not entered a valid input for B! Please provide a positive, non-zero integer.");
					sideB = 0;
				}
				break;
			case "C": 	//return hypotenuse
				double temp = (sideA * sideA) + (sideB * sideB);
				if(sideA <=0 || sideB <=0){
					if(sideA <=0){
						System.out.println("You don't have a triangle! Please enter a valid input for A.");
					}
					else{
						System.out.println("You dont have a triangle! Please enter a valid input for B.");
					}
				}
				
				else{
					double result = java.lang.Math.sqrt(temp);
					System.out.println("The hypotenuse value is "+result+". Inputs have been cleared.");
					sideA = 0; //clear A and B between attempted calculations of C 
					sideB = 0;
				}

			}
		} else{
			System.out.println("Please provide a valid command!");
		}
		}
		System.out.println("Thank you. Goodbye!");
		return;
		
	}

}
