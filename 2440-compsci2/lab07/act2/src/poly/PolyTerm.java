package poly;

public class PolyTerm {
    private double coefficient;
    private int exponent;
	private double varValue;
    	
    public PolyTerm(double coefficient, int exponent) {
	this.coefficient = coefficient;
	this.exponent = exponent;
    }
	
    public double getCoefficient(){
	return coefficient;
    }

    public void setCoefficient(double value){
	coefficient = value;
    }

    public int getExponent(){
	return exponent;
    }

    public void setExponent(int value){
	exponent = value;
    }
    
    public double evalTerm(double varValue){
    return coefficient *(Math.pow (varValue, exponent));    //this returns the term in its proper polynomial manner
    }

    public String toString(){
	return coefficient + "X ^ " + exponent;
    }
}
