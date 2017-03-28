public class MyLinkedList{
	public class LNode{
		int value;
		LNode pre;
		LNode next;
		public LNode(int n){
			value = n;
			next = null;
			pre = null;
		}
		public LNode(int n, LNode rest, LNode last){
			value = n;
			next = rest;
			pre = last;
		}
	}
	LNode start;
	LNode end;
	int size;
	public MyLinkedList(){
		start = new LNode(0, null, null);
		end = new LNode(0, null, null);
		size = 0;	
	}	
	public boolean add(int num){		
		LNode current = new LNode(num, start, null);
		size++;
		start = current;
		return true;
	}
	public String toString(){
		String result = "[";
		for (int i = 0; i < size; i++){
			LNode current = start;
			current = current.next;
			result += current.value;
		}
		return result + "]";
	}
	public static void main(String[]args){
		MyLinkedList l = new MyLinkedList();	
		System.out.println(l);
		System.out.println(l.add(4));
		System.out.println(l);
	}	
}
