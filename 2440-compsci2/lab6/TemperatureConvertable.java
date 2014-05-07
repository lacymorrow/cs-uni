
public class TemperatureConvertable implements Convertable {
	   // convert to degrees C (from F)
	   public double convertTo(double deg){
	      return (deg-32.0)*5.0/9;
	   }
	   // convert to degrees F (from C)
	   public double convertFrom(double deg){
	      return deg*9.0/5.0 + 32.0;
	   }
	}