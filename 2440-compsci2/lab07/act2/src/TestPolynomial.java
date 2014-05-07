
import list.*;
import poly.*;

public class TestPolynomial {

    public void go(){
	double[] coef1 = {3.0,2.0,1.0};
	int[] exp1 = {1,2,3};		
	Polynomial p1 = new Polynomial(coef1,exp1);
	System.out.println("p1 = " + p1);
	System.out.println("evaluating "+p1+" at 1.0 = " + p1.evalPolynomial(1.0));
	System.out.println("evaluating "+p1+" at 2.0 = " + p1.evalPolynomial(2.0));
    }

    public static void main(String[] args) {
	TestPolynomial myPolynomial = new TestPolynomial();
	myPolynomial.go();
    }
}
