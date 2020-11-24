public abstract class Number{
  public abstract double getValue();

  /*return 0 when this Number equals the other RealNumber
  return a negative value when this Number is smaller than the other Number
  return a positive value when this Number is larger than the other Number
  */
  public int compareTo(Number other){
    //TO BE IMPLEMENTED
  }

  /*
  *Return true when the % difference of the values
  *are within 0.00001 of eachother.
  *Special case: if one is exactly zero, the other must be exactly zero.
  */
  public boolean equals(RealNumber other){
    double pd1 = ((Math.abs(value-other.getValue()))/(other.getValue())) * 100;
    double pd2 = ((Math.abs(value-other.getValue()))/(value)) * 100;
    if((pd1 <= 0.0000001) && (pd2 <= 0.0000001)) return true;
    if((pd1 == 0)||(pd2 == 0)) return false;
    return false;
    }
}
