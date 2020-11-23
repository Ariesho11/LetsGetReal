public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  public double getValue(){
    return value;
  }

  public String toString(){
    return ""+value;
  }
  //---------ONLY EDIT BELOW THIS LINE------------

  /*
  *Return true when the values are within 0.001% of eachother.
  *Special case: if one is exactly zero, the other must be exactly zero.
  */
  public boolean equals(RealNumber other){
    double pd1 = ((Math.abs(value-other.getValue()))/(other.getValue())) * 100;
    double pd2 = ((Math.abs(value-other.getValue()))/(value)) * 100;
    if((pd1 <= 0.0000001) && (pd2 <= 0.0000001)) return true;
    if((pd1 == 0)||(pd2 == 0)) return false;
    return false;
  }

  /*
  *Return a new RealNumber that has the value of:
  *the sum of this and the other
  */
  public RealNumber add(RealNumber other){
     //other can be ANY RealNumber, including a RationalNumber
     //or other subclasses of RealNumber (that aren't written yet)
     RealNumber n = new RealNumber(value + other.getValue());
     return n;
  }

  /*
  *Return a new RealNumber that has the value of:
  *the product of this and the other
  */
  public RealNumber multiply(RealNumber other){
    RealNumber n = new RealNumber(value * other.getValue());
    return n;
  }

  /*
  *Return a new RealNumber that has the value of:
  *this divided by the other
  */
  public RealNumber divide(RealNumber other){
    RealNumber n = new RealNumber(value / other.getValue());
    return n;
  }

  /*
  *Return a new RealNumber that has the value of:
  *this minus the other
  */
  public RealNumber subtract(RealNumber other){
    RealNumber n = new RealNumber(value - other.getValue());
    return n;
  }
}
