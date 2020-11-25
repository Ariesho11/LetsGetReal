public abstract class Number{
  public abstract double getValue();

  /*return 0 when this Number equals the other RealNumber
  return a negative value when this Number is smaller than the other Number
  return a positive value when this Number is larger than the other Number
  */
  public int compareTo(Number other){
    if(getValue() == other.getValue()) return 0;
    if(other.getValue() > (getValue())) return -1;
    return 1;
  }

  /*
  *Return true when the % difference of the values
  *are within 0.00001 of eachother.
  *Special case: if one is exactly zero, the other must be exactly zero.
  */
  public boolean equals(RealNumber other){
    double pd1 = ((Math.abs(getValue()-other.getValue()))/((other.getValue()+getValue())/2)) * 100;
    if(pd1 <= 0.0000001) return true;
    if(pd1 == 0) return false;
    return false;
    }
}
