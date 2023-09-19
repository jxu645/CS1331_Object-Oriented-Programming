import java.util.Scanner;

public class DonutShop {

	public static void main(String[] args) {
	
		System.out.println("Welcome to Donut Shop finder!");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter your desired zip code: ");
		int zip = scan.nextInt();
		
		switch(zip) {
			case 33511:
				System.out.println("There is a donut shop called Dunkin Donuts here!");
				break;
			case 30328:
				System.out.println("There is a donut shop called Tim Hortons here!");
				break;
			case 30356:
				System.out.println("There is a donut shop called Krispy Kreme here!");
				break;
			case 30211:
				System.out.println("There is a donut shop called Sublime here!");
				break;
			default:
				System.out.println("Sorry, no shops found.");
				return;
		}
		
		System.out.print("Enter your budget: ");
		int budget = scan.nextInt();
		
		if (budget >= 1 && budget <= 5) {
			System.out.println("\nYou can purchase 2 donut(s).");
		} else if (budget >= 6 && budget <= 11) {
			System.out.println("\nYou can purchase 4 donut(s).");
		} else if (budget >= 12 && budget <= 20) {
			System.out.println("\nYou can purchase 8 donut(s).");
		} else if (budget > 20) {
			System.out.println("\nYou can purchase 16 donut(s).");
		} else {
			System.out.println("\nInvalid.");
		}
		
	}

}
