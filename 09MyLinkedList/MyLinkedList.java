
import java.util.*;
//public class MyLinkedList implements Iterable<Integer>{
public class MyLinkedList{

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

  LNode start,end;
  int size;

  public MyLinkedList(){
      start = null;
      end = null;
      size = 0; 
  }
  public int size(){
    return size;
  }

    
  private LNode getNthNode(int n){
      LNode current = start; 
      if(n < 0 || n >= size()){
        throw new IndexOutOfBoundsException("get Index out of range");
      }
      else{
      int mid = size / 2;
      if (n < mid){
       for(int i = 0; i < mid; i++){
         current = current.next; 
        }
      }
      else{
      for(int i = size; i > 0; i--){
        current = current.prev;
      }
      }
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
    if (size > 0){
      result += " ";
      LNode current = start;
      result += current.value;
      current = current.next;
      for (int i = 0; i < size; i++){
        result += ", " + current.value;
        current = current.next;
      }
    }
     return result + "]";
  }

  public boolean add(int num){ 
    if (start == null){
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
    int olds = current.value;
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
    return x.value;
  }

  public void add(int i,int num){
    if ((i > size) || (i < 0)){
      throw new IndexOutOfBoundsException("Add index out of range");
    }
    else if(size == 0 || i == size()){
      add(num);
    }
    else{
      int x = 0;
      LNode current = start;
      if (i == 0){
        LNode nexto = new LNode(num);
        nexto.next = start;
        start = nexto;
      }
      else{if(i == size){
          add(num);
          size -= 1;
        }
        else{
          while (x < size){
              LNode nexto = new LNode(num);
              nexto.next = current.next;
              nexto.prev = current.prev;
            if (x + 1 == i){
              nexto.next = nexto;
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
}
