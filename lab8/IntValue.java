package lab8;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class IntValue {

	private String _num;

	public IntValue(String num){
		_num = num;
	}

	public String getValue(){
		return _num;
	}

	public IntValue multiply(IntValue num){

		//get numbers from objects
		String n = this.getValue();
		String m = num.getValue();
		IntValue counter = new IntValue("1");
		IntValue result = this;
		String counterString = counter.getValue();;
		IntValue addOne = new IntValue("1");

		//have n add itself m number of times for multiplication
		while(counterString.compareToIgnoreCase(m) != 0){

			counter = counter.add(addOne);
			counterString = counter.getValue();
			result = result.add(this);
		}

		return result;

	}

	public IntValue add(IntValue num){

		//get numbers from objects
		String n = this.getValue();
		String m = num.getValue();

		//create arrays based on bigger number
		int[] result;
		int[] num1; 
		int[] num2;
		if(n.length() > m.length()){
			result = new int[n.length() + 1];
			num1 = new int[n.length()+1];
			num2 = new int[n.length()+1];
		}
		else{
			result = new int[m.length() + 1];
			num1 = new int[m.length()+1];
			num2 = new int[m.length()+1];
		}

		//put first number into array
		for(int i = 0; i < n.length(); i++){
			int counter = n.length() - 1 - i;
			num1[i] = Integer.parseInt(n.charAt(counter)+"");
		}

		//fill with 0's if necessary
		for(int i = num1.length - 1; i > n.length() - 1; i--){
			num1[i] = 0;
		}

		//put second number into array
		for(int j = 0; j < m.length(); j++){
			int counter = m.length() - 1 - j;
			num2[j] = Integer.parseInt(m.charAt(counter)+"");

		}

		//fill with 0's if necessary
		for(int j = num2.length - 1; j > m.length() - 1; j--){
			num2[j] = 0;
		}

		//do the actual adding part
		int counter = 0; 
		int carry = 0;
		while(counter < result.length){
			if(num1[counter] + num2[counter] + carry > 9){
				result[counter] = carry + num1[counter] + num2[counter] - 10;
				carry = 1;
			}
			else{
				result[counter] = carry + num1[counter] + num2[counter];
				carry = 0;
			}

			counter++;
		}

		//turn array into readable number
		String reverseResult = "";
		for(int i = 0; i < result.length; i++){
			reverseResult = reverseResult + result[result.length - i - 1];
		}

		int stopZero = 0;
		for(int j = 0; j < reverseResult.length(); j++){
			if(Integer.parseInt(reverseResult.substring(j, j+1)) !=0){
				stopZero = j;
				break;
			}
		}
		String finalResult = reverseResult.substring(stopZero, reverseResult.length());

		IntValue resultIntValue = new IntValue(finalResult);
		return resultIntValue;
	}

	public IntValue pow(long num){

		//get numbers from objects
		String n = this.getValue();
		IntValue result = this;

		//have n add itself m number of times for multiplication
		for(long i = 0; i < num - 1; i++){

			result = result.multiply(this);
		}

		return result;
	}

	public static void main(String[] args){

		String cmd = "";

		//keep running until end		
		while(cmd.compareToIgnoreCase("E")!=0){
			cmd = JOptionPane.showInputDialog(null, "Enter an operation (A = add, M = multiply, P = power, E = end)");


			//addition
			if(cmd.compareToIgnoreCase("A") == 0){
				String n = JOptionPane.showInputDialog(null, "Input a number");
				String m = JOptionPane.showInputDialog(null, "Input another number");

				//turn strings into intvalues
				IntValue num1 = new IntValue(n);
				IntValue num2 = new IntValue(m);

				IntValue result = num1.add(num2);

				System.out.println(n + " + " + m + " = " + result.getValue());
			}	

			if(cmd.compareToIgnoreCase("M") == 0 ){
				String n = JOptionPane.showInputDialog(null, "Input a number");
				String m = JOptionPane.showInputDialog(null, "Input another number");

				IntValue num1 = new IntValue(n);
				IntValue num2 = new IntValue(m);

				IntValue result = num1.multiply(num2);

				System.out.println(n + " x " + m + " = " + result.getValue());
			}

			if(cmd.compareToIgnoreCase("P") == 0 ){
				String n = JOptionPane.showInputDialog(null, "Input a number");
				String m = JOptionPane.showInputDialog(null, "Input another number");

				IntValue num1 = new IntValue(n);
				long num2 = Long.parseLong(m);


				IntValue result = num1.pow(num2);

				System.out.println(n + " ^ " + m + " = " + result.getValue());
			}
		}
	}
}
