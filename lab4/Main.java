package lab4;

public class Main {
	
	public static void main(String[] args){
		
		BetterArray list = new BetterArray(10);
		System.out.println("Initial Values");
		for(int x = 0; x < 10; x++){
			list.put(200+x, x);
			System.out.println("   Value at index "+x+": "+list.get(x));
		}
		System.out.println();
		
		System.out.println("Setting values for elements 0-20");
		for(int x = 0; x < 20; x++){
			list.put(300+x, x);
			System.out.println("   Value at index "+x+": "+list.get(x));
		}
	}
}
