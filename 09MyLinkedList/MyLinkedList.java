
import java.util.*;
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
  }

  private void addAfter(LNode location, LNode toBeAdded){
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

  private void remove(LNode target){
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

  public boolean add(int value){ 
    LNode current = start;
    while (current != end){
      current = current.next;
    }
    current.next = new LNode(num);
    size++;
    return true;
  } 

  public int get(int index){/*complete this*/}

  public int set(int index, int value){
      int hold = 0;
    if ((i > size) || (i < 0)){
      throw new IndexOutofBoundsException("Index of set out of bounds");
    }
    else{
      LNode current = start;
      for (int j = 0; j < size; j++){
        if (i == j){
        hold = current.value;
        current.value = news;
        }
        else{
          current = current.next;
        }
      }
    }
    return hold;
  }

  public int indexOf(int value){/*complete this*/}

  public int remove(int index){  
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
  }

  public void add(int index,int value){
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
              LNode nexto = new LNode(num, current.prev, current.next);
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
