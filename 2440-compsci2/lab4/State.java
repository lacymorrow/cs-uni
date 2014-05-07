public class State implements Comparable<State>{
	double area;
	double pop;
	String data[] = new String[3];
	public State(String[] args) {
		data[0] = args[0];//state name
		data[1] = args[1];//state abbrev
		data[2] = args[2];//postal abbrev
		area = Double.parseDouble(args[3]);
		pop = Double.parseDouble(args[4]);
	}
	public int compareTo(State o) {
		return (int) (getPop() - o.getPop());
	}
	public double getPD() {
		return pop/area;
	}
	public double getArea() {
		return area;
	}
	public double getPop() {
		return pop;
	}
	public String print() {
		return "["+data[0]+"]\tPopulation: \t"+getPop()+"\tArea:\t"+getArea()+"\t   Population Density:\t"+roundIt(getPD());
	}
	public static double roundIt(double num) {
		double result = num * 100;
		result = Math.round(result);
		result = result / 100;
		return result;
		}
}
