package lab4;

public class BetterArray {
	
	private int size;
	private node head;
	private node tail;
	
	public BetterArray(int n){
		
		size = n;
		
		//add head and tail nodes
		head = new node();
		tail = new node();
		head.set(0);
		tail.set(0);
		
		//have head and tail point properly
		tail.next = null;
		head.prev = null;
		head.next = tail;
		tail.prev = head;
		
		//create additional nodes between head and tail, have them point correctly
		node temp = head;
		for(int x = 0; x < n-2; x ++){
			node save = temp.next;
			temp.next = new node(0);
			(temp.next).next = save;
			(temp.next).prev = temp;
			save.prev = temp.next;
		}
	}
	
	public BetterArray(){
		
		size = 2;
		
		//add head and tail nodes
		head = new node();
		head.set(0);
		tail = new node();
		tail.set(0);
		
		//have head and tail point correctly
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
 
	}
	
	public int get(int index){
		node temp = head;
		
		for(int x=0; x < index; x++){
			temp = temp.next;
		}
		
		return temp.get();	
	}
	
	public void put(int value, int index){
		//check to see if trying to add a value beyond list, add node if it is
		if(index >= size){
			node temp = tail;
			int counter = index - size + 1;
			for(int x = 0; x < counter; x++){
				temp.next = new node(value);
				(temp.next).next = null;
				(temp.next).prev = temp;
				size = size + 1;
				tail = temp.next;
			}
		}
		
		//setting new value for the corresponding node
		node temp = head;
		for (int loc = 0; loc < index; loc++){
			temp = temp.next;
		}
		
		temp.set(value);
		
		
	}

}
