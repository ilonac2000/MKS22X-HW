import java.util.*;

public class RunningMedian{
    private MyHeap min;
    private MyHeap max;
    
    public RunningMedian(){
        min = new MyHeap(false);
        max = new MyHeap(true);

    }

    public double getMedian(){		
        double result = 0.0;
        int sizeM = min.getSize();
        int sizeN = max.getSize();
        if ((sizeM == 0) && (sizeN == 0)){
            throw new NoSuchElementException("Size of heaps are zero");
        }
        else{
            int minT = min.peek();
            int maxT = max.peek();
         if(sizeM == sizeN){
            result = (minT + maxT) / 2;
         }
         else if(sizeM > sizeN){
            result = minT;
         }
         else{
            result = maxT;
         }
        }
        return result;
    }

    public void add(Integer i){
	   if (i < getMedian()){
        min.add(i);
       }
       else{
        max.add(i);
       }
       int result = min.getSize() - max.getSize;
       if(result > 1 || result < -1){
        if (result < -1){
            min.add(max.remove());
        }
        else{
            max.add(min.remove());
        }
       }
    }
}

