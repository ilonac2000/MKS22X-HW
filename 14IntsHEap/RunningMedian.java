import java.util.*;

public class RunningMedian{
    private MyHeap min;
    private MyHeap max;
    
    public RunningMedian(){
        min = new MyHeap(false);
        max = new MyHeap(true);

    }

    public double getMedian(){		
        double result = 0.0
        if ((min.getSize() == 0) && (max.getSize() == 0)){
            throw new NoSuchElementException("Size of heaps are zero");
        }
        else{
            int minT = min.peek();
            int maxT = max.peek();
            int result = (mintT + maxT) / 2;
        }
        return result;

    public void add(Integer i){
	   
    }

}
