
public class CharacterJumble {

	public static void main(String[] args) {
		
		String TEXT = "CS 1331 is the best class I will ever take";
		String text = TEXT.toLowerCase();
		text = text.replace("a", "&");
		text = text.replace("e", "%");
		text = text.replace("i", "^");
		text = text.replace("o", "*");
		text = text.replace("u", "@");
		text = text.replace("s", "$");
		text = text.replace("t", "!");
		
		System.out.println("Enter English Test: " + TEXT);
		System.out.println("Converted Text: " + text);
		
	}

}
