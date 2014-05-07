public class YearData implements Comparable<YearData>{
	int i = 0;
	int year;
	double data[] = new double[12];
	double high;
	double low;
	double average;
	double netChange;
	public YearData(int year) {
		this.year = year;
	}
	public int compareTo(YearData o) {
		return o.getYear()-this.year;
	}
	public double getAverage() {
		return average;
	}
	public double getNetChange() {
		return netChange;
	}
	public int getYear() {
		return year;
	}
	public void add(double nextDouble) {
		data[i] = nextDouble;
		i++;
		if(i==12){
			calc();
		}
	}
	private void calc() {
		double max = 0.0;
		double min = 100.0;
		double sum = 0.0;
		for(double num : data){
			if(num>max){
				max = num;
			}
			if(num<min){
				min = num;
			}
			sum += num;
		}
		high=max;
		low=min;
		average = sum/12;
		netChange=data[11]-data[0];
	}
	public String print() {
		String s = "";
		for(int a = 0; a<12;a++){
			s+="\t"+data[a];
		}
		s+="\nHigh: \t"+high+"\tLow: \t"+low+"\tAverage: \t"+roundIt(average)+"\tNet Change: \t"+roundIt(netChange)+"\n";
		return getYear()+s;
	}
	public static double roundIt(double num) {
		double result = num * 100;
		result = Math.round(result);
		result = result / 100;
		return result;
		}
}
