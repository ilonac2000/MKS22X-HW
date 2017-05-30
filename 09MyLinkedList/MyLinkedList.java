import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
  LNode start,end;
  int size;

  private class LNode{
    LNode next,prev;
    int value;
    public LNode(int value){
      this.value=value;
    }
    public String toString(){
      return value+"";
    }
  }

  public MyLinkedList(){
      start = null;
      end = null;
      size = 0; 
  }
  public int size(){
    return size;
  }

    
  private LNode getNthNode(int n){   
      int i = 0;
      LNode current = start; 
      if(n < 0 || n >= size()){
        throw new IndexOutOfBoundsException("get Index out of range");
      }
      while (i < n){
        current = current.next;
        i++;
      }
      return current;
  }

  private void addAfter(LNode loc, LNode tba){
      if(loc.next==null){
        tba.next=null;
        loc.next=tba;
        tba.prev=loc;
        end = tba;
    }
    else{
        tba.next = loc.next;
        tba.prev = loc;
        loc.next.prev = tba;
        loc.next = tba;
    }
    size++;
  }

  private void remove(LNode x){
    if (x.next == null && x.prev == null){
      start = null;
      end = null;
    }
    else if (x.next == null){
      x.prev.next = null;
      end = x.prev;
    }
    else if (x.prev == null){
      x.prev = null;
      start = x.next;
    }
    else{
      x.prev.next = x.next;
      x.next.prev = x.prev;
    }
    size--;
  }

  public String toString(){     
    String result = "[";
    for (int i = 0; i < size; i++){
      if (i > 0){
        result += ", ";
      }
      result += get(i);
      i++;
    }
    return result + "]";
  }

  public boolean add(int num){ 
    if (size == 0){
      start = new LNode(num);
      end = start;
    }
    else{
      end.next = new LNode(num);
      end.next.prev = end;
      end = end.next;
    }
    size++;
    return true;
  } 

  public int get(int index){
    return getNthNode(index).value;
  }

  public int set(int i, int news){
    LNode current = getNthNode(i);
    int olds = get(i);
    current.value = news;
    return olds;
  }

  public int indexOf(int value){
    for (int i = 0; i < size; i++){
      if (get(i) == value){
        return i;
      }
    }
    return -1;
  }

  public int remove(int index){  
    LNode x = getNthNode(index);
    int result = x.value;
    if (index >= 0 && index < size - 1){
      x.prev.next = x.next;
      x.next.prev = x.prev;
    }
    else if(index == 0){
      start = x.next;
    }
    else{
      end.prev.next = null;
    }
    size--;
    return result;
  }

  public void add(int i,int num){
    if (size == 0 || i == size){
      add(num);
    }
    LNode now = getNthNode(i);
    LNode hold = new LNode(num);
    hold.next = now;
    if (i > 0){
      hold.prev = now.prev;
      hold.prev.next = now;
    }
    size++;
  }

  public class LLIterator implements Iterator<Integer>{
    private MyLinkedList list;
    private LNode current;
    public LLIterator(MyLinkedList l, LNode x){
      list = l;
      current = x;
    }
    public boolean hasNext(){
      if (list.start == null && current == null){
        return false;
      }
      else{
        return true;
      }
    }
    public Integer next(){
      if (hasNext()){
      Integer result = new Integer(current.value);
      if (current.next != null){
        current = current.next;
      }
      return result;
      }
      else{
        throw new NoSuchElementException("no next element");
      }
    }
    public void remove(){
      throw new UnsupportedOperationException("no remove");
    }
  }
  public LLIterator iterator(){
    return new LLIterator(this, null);
  }
}
