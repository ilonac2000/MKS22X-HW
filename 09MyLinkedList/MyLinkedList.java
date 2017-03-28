public class MyLinkedList{
	LNode start;
	LNode end;
	int size;
	public MyLinkedList(LNode ln){
		start = new LNode();
		start = ln;
		size = 1;
	}
	public MyLinkedList(int n, LNode ln){
		start = ln;
		size = n;
	}
	public void add(int num){
		start.next = new LNode(num);
		size++;
	}
	public String toString(){
		String result = "[";
		for (int i = 0; i < size; i++){
			LNode current = start;
			current = current.next;
			result += current;
		}
		return result;
	}
	
}
