public class ExpressionTree{
    
  private char op;
  private double value;
  private ExpressionTree left,right;
  
  /*TreeNodes are immutable, so no issues with linking them across multiple
  *  expressions. The can be constructed with a value, or operator and 2
  * sub-ExpressionTrees*/
  public ExpressionTree(double value){
    this.value = value;
    op = '~';
  }
  public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
    this.op = op;
    left = l;
    right = r;
  }
  
  
  
  public char getOp(){
    return op;
  }
  
  /* accessor method for Value, precondition is that isValue() is true.*/
  private double getValue(){
    return value;
  }
  /* accessor method for left, precondition is that isOp() is true.*/
  private ExpressionTree getLeft(){
    return left;
  }
  /* accessor method for right, precondition is that isOp() is true.*/
  private ExpressionTree getRight(){
    return right;
  }
  
  private boolean isOp(){
    return hasChildren();
  }
  private boolean isValue(){
    return !hasChildren();
  }
  
  private boolean hasChildren(){
    return left != null && right != null;
  }
  
  public String toString(){
    if (isValue()){
     return "" + getValue();
    } 
    else{
      return "(" + getLeft().toString() + " " + getOp() +" " +  getRight() + ")";}
    }
  
  public String toStringPostfix(){  
   if(isValue()){
     return "" + getValue();
   } 
   else{
      return getLeft().toStringPostfix() + " " + getRight().toStringPostfix() + " " + getOp();
    }
  }
    
  public String toStringPrefix(){  
   if(isValue()){
     return "" + getValue();
   } 
   else{
    return getOp() + " " + getLeft().toStringPrefix() + " " + getRight().toStringPrefix();
   }
 }

  public double evaluate(){
   if(isValue()){
     return getValue();
   } 
    else {
      if (getOp() == '+') {
        return getLeft().evaluate() + getRight().evaluate();
      }
      else if (getOp() == '-') {
       return getLeft().evaluate() - getRight().evaluate();
      }
      else if (getOp() == '/') {
        return getLeft().evaluate() / getRight().evaluate();
      }
      else {
        return getLeft().evaluate() * getRight().evaluate();
      }
    }
  }
}
