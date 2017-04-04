public class MyLinkedList{
	private class LNode{
		private int value;
		private LNode pre;
		private LNode next;
		public LNode(int n){
			value = n;
			next = null;
			pre = null;
		}
		public LNode(int n, LNode nes, LNode last){
			value = n;
			next = nes;
			pre = last;
		}
	}
	LNode start;
	LNode end;
	int size;
	public MyLinkedList(){
		start = null;
		end = null;
		size = 0;	
	}	
	public boolean add(int num){		
		LNode current = start;
		while (current != end){
			current = current.next;
		}
		current.next = new LNode(num);
		size++;
		return true;
	}
	public void add(int i, int num){
		if ((i > size) || (i < 0)){
			throw new IndexOutofBoundsException("Index of add out of bounds");
		}
		else{
			int x = 0;
			LNode current = start;
			if (i == 0){
				LNode nexto = new LNode(num, null, current);
				start = nexto;
			}
			else{
				if(i == size){
					add(num);
					size -= 1;
				}
				else{
					while (x < size){
						if (x + 1 == i){
							LNode nexto = new LNode(num, current.prev, current.next);
							current.nexto = nexto
							x = size + 2;
						}
						else{
							nexto = nexto.next;
						}
						i++;
					}
				}
			}
		}
		size++;
	}
	public int getSize(){
		return size;
	}
    public int set(int i, int new){
		if ((i > size) || (i < 0)){
			throw new IndexOutofBoundsException("Index of set out of bounds");
		}
		else{
			int hold = 0;
			LNode current = start;
			for (int j = 0; j < size; j++){
				if (i = j){
				hold = current.value;
				current.value = new;
				}
				else{
					current = current.next;
				}
			}
		}
		return hold;
	}
    private void insertAfter(LNode tba, LNode loc){
		if(loc.next==null){
	    	tba.next=null;
	    	loc.next=tba;
	   		tba.prev=loc;
		}
		else{
		    tba.next=loc.next;
		    loc.next=tba;
		    tba.prev=loc;
		}
		size++;
    }
    private void insertBefore(LNode tba, LNode loc){
		if(loc.prev==null){
	    	tba.prev=null;
	    	loc.prev=tba;
		    tba.next=loc;
		}
		else{
		    tba.prev=loc.prev;
		    loc.prev=tba;
		    tba.next=loc;
		}
		size++;
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
}
    
