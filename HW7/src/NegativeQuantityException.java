/**
 * Custom exception NegativeQuantityException class.
 * @author Jessie Xu
 * @version 1.0
 */
public class NegativeQuantityException extends RuntimeException {
    /**
     * Handles NegativeQuantityException.
     * @param error error message
     */
    public NegativeQuantityException(String error) {
        super("Quantity " + error + " is not positive.");
    }
}