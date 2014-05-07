
public class GeneralConverter {
	private String nameUnit1;
	private String nameUnit2;
	private Convertable converter;
	private double quantity1; // corresponds to quantity in unit 1
	private double quantity2; // corresponds to quantity in unit 2
	
	public GeneralConverter(String n1, String n2, Convertable convert){
		nameUnit1 = n1;
		nameUnit2 = n2;
		converter = convert;
	}
	
	public void setQuantity1(double q1){
		quantity1 = q1;
	}
	public void setQuantity2(double q2){
		quantity2 = q2;
	}
	public String getNameUnit1() {
		return nameUnit1;
	}
	public String getNameUnit2() {
		return nameUnit2;
	}
	public double getQuantity1() {
		return quantity1;
	}
	public double getQuantity2() {
		return quantity2;
	}
	

}
