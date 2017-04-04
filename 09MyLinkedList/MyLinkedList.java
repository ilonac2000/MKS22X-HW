public class MyLinkedList{
	private class LNode{
		private int value;
		private LNode pre;
		private LNode next;
		public LNode(int n){
			value = n;
			//next = null;
			//pre = null;
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
	public int getSize(){
		return size;
	}
	private LNode getNthNode(int n){
		int mid = getSize() / 2;
		LNode current = start; 
		if (n < mid){
			for(int i = 0; i < mid; i++){
				current = current.next;	
				if(i == n){
					return current;
				}
			}
		}
		else{
			for(int i = size; i > 0; i--){
				current = current.prev;
				if (i == n){
					return current;
				}
			}
		}	
	}
   	private void addAfter(LNode tba, LNode loc){
		if(loc.next==null){
	    		tba.next=null;
	   	 	loc.next=tba.prev;
	   		tba.prev=loc.next;
			end = tba;
		}
		else{
		    tba.next = loc.next.prev;
		    tba.prev = loc.next;
		    loc.next.prev = tba.next;
		    loc.next = tba.prev;
		}
		size++;
    	}
	private void remove(LNode x){
		if (x.next == null){
			x.prev.next = null;
			end = x.prev;
		}
		if (x.prev == null){
			x.next.prev = null;
			start = x.next;
		}
		else{
			x.prev.next = x.next;
			x.next.prev = x.prev;
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
			else{if(i == size){
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

    
