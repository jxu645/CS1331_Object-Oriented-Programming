import java.util.Random;

public class CandyBag {
	
	private enum Candy{
		GUMMY_BEAR, LOLIPOP, CHOLOCATE, LICORICE, HARD_CANDY
	}
	
	public static Candy[] createBag() {
		Candy[] candyArray = new Candy[6];
		Candy[] candyValue = Candy.values();
		Random random = new Random();
		
		for (int i = 0; i < 6; i++) {
			int index = random.nextInt(candyValue.length);
			candyArray[i] = candyValue[index];
		}
		return candyArray;
	}

	public static void printBag(Candy[] candyArray) {
		System.out.println("Your assortment of Candy includes: ");
		
		for (int i = 0; i < candyArray.length; i++) {
			System.out.println(candyArray[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Candy[] bag1 = CandyBag.createBag();
        CandyBag.printBag(bag1);
        Candy[] bag2 = CandyBag.createBag();
        CandyBag.printBag(bag2);
		
	}

}
