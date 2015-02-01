 public class Komplex {
     private double re;
     private double im;

     public static void main(String[] args) {
	 Komplex c = new Komplex(1,2);
	 Komplex d = new Komplex(3,4);
	 Komplex noll = new Komplex();
	 Heltal h = new Heltal(5);
	 System.out.println("("+c+") + ("+d+") = (" + c.add(d) + ")");
	 System.out.println("("+d+") - ("+c+") = (" + d.sub(c) + ")");
	 System.out.println("("+d+") * ("+c+") = (" + d.mul(c) + ")");
	 System.out.println("("+c+") / ("+d+") = (" + c.div(d) + ")");
	 System.out.println("("+noll+") - ("+c+") = (" + noll.sub(c) + ")");
	 System.out.println("Conjugate of ("+c+") = ("+c.conj()+")");
	 System.out.println("("+c+") + "+h+" = ("+c.addHeltal(h)+")");
	 System.out.println(h+" + ("+c+") = ("+c.addHeltal(h)+")");
	 
     }

     /**
      * 
      */
     public String toString() {
	 return "" + this.re + (this.im>=0?" + ":" - ") + Math.abs(this.im) + "i";
     }
     /**
      * Create a new Komplex object.
      * @param re The real part of the number
      * @param im The imaginary part of the number
      */
     public Komplex(double re, double im){
	 this.re = re;
	 this.im = im;
     }

     /**
      * Create an object with the specified real part
      * @param re
      */
     public Komplex(double re) {
	 this(re, 0.0);
     }

     /**
      * Creates a default Komplex with re = 0 im = 0.
      */
     public Komplex() {
	 this(0.0);
     }

     /**
      * create a Komplex object from a Heltal.
      * @param a
      */
     public Komplex(Heltal a) {
	 this((double)a.getValue());
     }

     /**
      * Returns a new Komplex which is the sum of 2 Komplex.
      * @param rhs
      * @return
      */
     public Komplex add(Komplex rhs) {
	 return new Komplex(this.re+rhs.re, this.im+rhs.im);

     }

     /**
      * Returns the difference between 2 Komplex.
      * @param rhs
      * @return
      */
     public Komplex sub(Komplex rhs) {
	 return new Komplex(this.re-rhs.re, this.im-rhs.im);

     }

     /**
      * Multiplies two Komplex numbers.
      * @param rhs
      * @return
      */
     public Komplex mul(Komplex rhs) {
	 return new Komplex(this.re*rhs.re-this.im*rhs.im,
			    this.re*rhs.im+this.im*rhs.re);
     }

     /**
      * Divides this Komplex with denominator rhs.
      * @param rhs
      * @return
      */
     public Komplex div(Komplex rhs) {
	 double denominator = rhs.re*rhs.re + rhs.im*rhs.im;
	 return new Komplex((this.re*rhs.re + this.im*rhs.im)/denominator,
			    (this.im*rhs.re-this.re*rhs.im)/denominator);

     }

     // New methods (by Martin Törnqvist)
     /**
      * Conjugates this Komplex.
      * @param
      * @return
      */
     public Komplex conj() {
     	 return new Komplex(this.re, 0-this.im);
     }

     /**
      * Adds this Komplex with a Heltal rhs.
      * @param rhs
      * @return
      */
     public Komplex addHeltal(Heltal rhs) {
	 return new Komplex(this.re+rhs.getValue(), this.im);
     }
     
 }
