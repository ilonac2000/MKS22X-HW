public class LNode{
	int value;
	LNode pre;
	LNode next;

	public LNode(){
		
	}
	public LNode(int n){
		value = n;
	}
	public LNode(int n, LNode rest){
		value = n;
		next = rest;
	}
}
