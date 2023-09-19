
public class Weight {

	public static void main(String[] args) {
		
		double weight = 160;
		double ounce = weight * 35.274;
		int pound = (int)(ounce / 16);
		double ounceFinal = ounce - pound * 16;
		
		System.out.println(weight + " kg is " + pound + " lb " + ounceFinal + " oz.");
		
	}

}
