public class Ratio{
	protected int numerator; 	// nummerator of ratio
	protected int demominator;  // demominator of ratio

	public Ratio(int top, int bottom)
		// Pre : bottom != 0 
		// Post: constructs a ratio equivalent to top::bottom
	{
		numerator = top;
		demominator = bottom;
		reduce();

	}

	public int getNumerator()
	// post : return the numerator of the fraction
	{
		return numerator;

	}

	public int getDemominator(){
		return demominator;
	}

	public double getValue(){
		return (double)numerator/(double)demominator;
	}

	public Ratio add (Ratio other)
	// pre  : other is non-null
	// post : return new fraction -- the sum of this and other
	{
		return new Ratio (this.numerator* other.demominator + this.demominator * other.numerator, this.demominator * other.demominator);
	}

	protected void reduce()
	// post : numerator and demominator are set so that 
	// the greatest common divisor of the numerator and demominator is 1
	{
		int divisor = gcd(numerator, demominator);
		numerator /= divisor;
		demominator /= divisor;
	}

	protected static int gcd(int a, int b)
	// pre : 0 <= a.b
	// post : computes the greatest integer value that divides a and b
	{
		if ( a == 0 ){
			if (b==0) return 1;
			else return b;
		}
		if ( b < a  ) return gcd(b,a);
		return gcd(b%a,a);
	}

	public String toString()
	// post : returns a string that represents this fraction
	{
		return getNumerator() + "/" + getDemominator();
	}


	public static void main(String[] args){
		Ratio r = new Ratio(1,1);
		r = new Ratio(1,2);
		r.add(new Ratio(1,3));
		r = r.add(new Ratio(2,8));


		System.out.println(r.getValue());
		System.out.println(r.toString());
		System.out.println(r);
	}

}