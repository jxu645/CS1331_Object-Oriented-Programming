/**
 * Program that give the user a series of methods that can be used to analyze the input text.
 * @author Jessie Xu
 * @version 1.0
 */
public class WordStatistics {
    private String text;
    private String history;
    private static int totalWordCount = 0;
    private static int longestSentenceLength = 0;

    /**
     * Constructor that takes in user input text and history.
     * @param text Represents user input text.
     * @param history Represents user input published date.
     */
    public WordStatistics(String text, String history) {
        this.text = text.replaceAll("\\,", " ");
        this.history = history;
    }
    private String wordCount(String initText, String word) {
        String[] textArray = initText.split("\\s+");
        int count = 0;
        for (int i = 0; i < textArray.length; i++) {
            if (word.equals(textArray[i])) {
                count++;
            }
        }
        String stringCount = String.valueOf(count);
        return stringCount;
    }

    /**
     * Method that counts user assigned number of initial words' occurrences in text.
     * @param initWords User input int, represents how many initial words will be counted in the text.
     * @return Returns a 2d array with initial words and number of occurrences of that word in the text.
     */
    public String[][] countInitWords(int initWords) {
        this.text = text.toLowerCase();
        String initText = text.replaceAll("\\.", " ");
        String[] wordsArray = initText.split("\\s+");
        String[][] output = new String[wordsArray.length][2];
        String[][] output1 = new String[initWords][2];
        int a = 0;
        for (int j = 0; j < wordsArray.length; j++) {
            output[j][0] = wordsArray[j];
            output[j][1] = wordCount(initText, output[j][0]);
            if (!tof(output, j)) {
                output1[a][0] = output[j][0];
                output1[a][1] = output[j][1];
                int count = Integer.parseInt(output1[a][1]);
                totalWordCount = totalWordCount + count;
                a++;
            }
            if (a == initWords) {
                break;
            }
        }
        return output1;
    }
    /**
     *Method that determines if the current index value occurred in the previous index positions.
     * @param output Takes in unsimplified array.
     * @param index Takes in an index number.
     * @return Returns boolean values based on the conditions
     */
    private boolean tof(String[][] output, int index) {
        for (int i = 0; i < index; i++) {
            if (output[index][0].equals(output[i][0])) {
                return true;
            }
        }
        return false;
    }
    /**
     * Method to analyze the longest sentence in the text.
     * @return Returns length of the longest sentence in the text.
     */
    public int longestSentence() {
        String[] sentence = text.split("\\.");
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].trim();
        }
        int longest = 0;
        int max = 0;
        for (int i = 0; i < sentence.length; i++) {
            String[] words = sentence[i].split("\\s+");
            int wordCount = words.length;
            if (wordCount > longest) {
                longest = wordCount;
                max = i;
            }
        }
        if (longest > longestSentenceLength) {
            longestSentenceLength = longest;
        }
        System.out.println(sentence[max] + ".");
        return longest;
    }

    /**
     *Method to calculate age of text from user.
     * @return Returns an integer which represents age of the text since it's published.
     */
    public int textAge() {
        String publishedYear = history.substring(10, 14);
        int intPublishedYear = Integer.parseInt(publishedYear);
        int age = (2022 - intPublishedYear + 1);
        return age;
    }
}