package lab4;

public class node {

	private int value;
	private int defaultValue;
	
	public node(int v){
		 value = v;
	}
	
	public node(){
		defaultValue = 0;
	}
	
	public int get(){
		return value;
	}
	
	public void set(int v){
		value = v;
	}
	public node next = null;
	public node prev = null;
	
}
