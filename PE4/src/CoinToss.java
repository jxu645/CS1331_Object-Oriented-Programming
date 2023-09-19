import java.util.Scanner;
import java.util.Random;

public class CoinToss {

	public static void main(String[] args) {

		 String repeat = "y";
		 Scanner scan = new Scanner (System.in);
		 Random random = new Random();
		 
		 while (repeat.equalsIgnoreCase("y")) {
			 int toss;
			 System.out.println("Ready to run a coin toss simulation. Enter the number of tosses: ");
			 toss = scan.nextInt();
			 int sum = 0;
			 int head = 0;
			 int tail = 0;
			 System.out.println("Simulating Coin Tosses");
			 
			 for (int i = 1; i <= toss; i++) {
				 System.out.print(i + "-");
				 int H = 0;
				 int T = 0;
				 int result;
				 while (H == 0 || T == 0) {
					 result = random.nextInt(2);
					 if (result == 0) {
						 System.out.print("H");
						 H++;
					 } else {
						 System.out.print("T");
						 T++;
					 }
					 sum++;
				 }
				 head = head + H;
				 tail = tail + T;
				 System.out.println();
			 }
			 double avg = (double)sum / (double)toss;
			 
			 System.out.println("The average number of coin tosses was " + avg);
			 System.out.println("A total of " + head + " heads and " + tail + " tails were tossed.");

			 
			 System.out.println("Would you like to run another simulation? (y/n)");
			 scan.nextLine();
			 repeat = scan.nextLine();
		 }
		
	}

}
