public class RationalNumber extends Number{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    if (deno < 0){
      if (nume < 0){
        denominator = Math.abs(deno);
        numerator = Math.abs(nume);
      }
      else{
        denominator = Math.abs(deno);
        numerator = (0 - nume);
      }
    }
    else{
    numerator = nume;
    denominator = deno;
  }
  reduce();
  if ((deno == 0)||(nume == 0)){
    denominator = 1;
    numerator = 0;
    }
  }

  public double getValue(){
    return ((double)numerator / (double)denominator);
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber r = new RationalNumber(denominator, numerator);
    return r;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if((other.getNumerator() == numerator)&&(other.getDenominator() == denominator)) return true;
    if(other.getValue() == this.getValue()) return true;
    return false;
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (denominator == 1) return getNumerator()+"";
    if (numerator == 0) return ""+0;
    return ""+getNumerator() + "/" + getDenominator();
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    //http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    int g = 1;
    for(int i = 1; i <= a && i <= b; i++){
        if(((a%i) == 0) && ((b%i) == 0)) g = i;
      }
    return g;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int g = gcd(getNumerator(), getDenominator());
    numerator = getNumerator() / g;
    denominator = getDenominator() / g;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){

    RationalNumber product = new RationalNumber(numerator*other.getNumerator(), denominator*other.getDenominator());
    return product;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber quotient = new RationalNumber(numerator*other.getDenominator(), denominator*other.getNumerator());
    return quotient;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int lcm = Math.abs(denominator*other.getDenominator())/(gcd(denominator, other.getDenominator()));
    int n1 = numerator*(lcm/denominator);
    int n2 = other.getNumerator()*(lcm/other.getDenominator());
    RationalNumber a = new RationalNumber(n1+n2, lcm);
    return a;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int lcm = Math.abs(denominator*other.getDenominator())/(gcd(denominator, other.getDenominator()));
    int n1 = numerator*(lcm/denominator);
    int n2 = other.getNumerator()*(lcm/other.getDenominator());
    RationalNumber s = new RationalNumber(n1-n2, lcm);
    return s;
  }
}
