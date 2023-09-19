import java.util.Scanner;

/**
 * This is the driver class to test methods in WordStatistics class.
 * @author Jessie Xu
 * @version 1.0
 */
public class Driver {
    /**
     * This is the main method.
     *
     * @param args An array of command-line arguments for the application
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the text dialogue: ");
        String text = scan.nextLine();
        System.out.print("Enter the date the text is published: ");
        String history = scan.next();
        WordStatistics test = new WordStatistics(text, history);
        System.out.print("Enter the initial number of words: ");
        int initWordNum = scan.nextInt();
        String[][] array = test.countInitWords(initWordNum);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][0] + " " + array[i][1]);
        }
        int num = test.longestSentence();
        System.out.println(num);
        System.out.println("Text age is: " + test.textAge());
    }
}