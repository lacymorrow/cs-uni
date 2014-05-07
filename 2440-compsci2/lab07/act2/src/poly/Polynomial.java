package poly;

import list.*;

public class Polynomial {
    ListInterface<PolyTerm> polynomial;
	double varValue;

    public Polynomial() { 
	polynomial = new ExpandableArrayList<PolyTerm>();//this creates the ExpandableArraylist object
    }
    public Polynomial(double[] coefArray, int[] exponentArray){
	this();  // use other constructor to make collection!
	PolyTerm term;
	for(int j = 0; j < coefArray.length; j++){
	    term = new PolyTerm(coefArray[j],exponentArray[j]);
	    polynomial.add(term);
	}
    }
	
    public int getLength(){ //returns the length of the polynomial
    return polynomial.getLength();
    }
	
    public PolyTerm getTerm(int index){ //this returns a specific term
	return polynomial.getEntry(index);
    }
	
    public void appendTerm(PolyTerm t){ //
	polynomial.add(t);
    }
    
    public double evalPolynomial(double varValue){
    double results = 0.0;
    int i = 1;
    if(getLength() == 1){   //if only one term in polynomial
        PolyTerm t = getTerm(1);
        return t.evalTerm(varValue);
    }
    else
    {
        while(i < getLength())
        {
           PolyTerm term = getTerm(i);
           results += term.evalTerm(varValue);
           i++;
        }
    }
    return results;
    }
    
    public double evalEff(double varValue)
    {
        double runningtotal = 0.0;  //set the running total variable that increments everytime there is another term to evaluate 
        double coef;    //coefficient variable
        int i = 1;  //index that the loop will use and will correspond with the exponent
        double value = varValue;   
        int power = getTerm(i).getExponent();   //power variable is the value of the exponent of the term
        while(i <= getLength()) //i is less than or equal to the length of the polynomial and this loop will run
        {
            if(power == getTerm(i).getExponent())   //if the next term in the array has an exponent equal to the power
            {
                coef = getTerm(i).getCoefficient();    //
                runningtotal += coef * value;   //the running total is set to the coefficient times the varValue
                value += value * varValue; power += 1.0;    //
                i++;    //increment
            }
            else
            {

                value = value * varValue;
                power += 1.0; //if no term to correspond to the next power, then increment the power manually and multiply value and varValue
            }
        }
        return runningtotal;
    }
     
    public String toString(){   //return the polynomial in its fullest
	int length = polynomial.getLength();
	if(length == 0){
	    return "";
    }
	else {
	    StringBuffer str = new StringBuffer(polynomial.getEntry(length).toString());
		PolyTerm term;
        for(int j = length - 1; j >= 1; j--){
            term = polynomial.getEntry(j);
            str.append(" + " + term.toString());
        }return str.toString();
	}
    }
}
