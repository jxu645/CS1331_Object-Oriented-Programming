/**
 * Custom exception IllegalQuantityException class.
 * @author Jessie Xu
 * @version 1.0
 */
public class IllegalQuantityException extends Exception {
    /**
     * Handles IllegalQuantityException.
     * @param error error message
     */
    public IllegalQuantityException(String error) {
        super("Quantity " + error + " is not a number.");
    }
}
