/**
 * Fire type class.
 * @author Jessie Xu
 * @version 1.0
 */
public class Fire implements PokemonType {
    /**
     * Overriding method that returns class name Fire.
     * @return Returns class name
     */
    @Override
    public String type() {
        return this.getClass().getName();
    }

    /**
     * Method that compares type fire with other pokemon types.
     * @param type The object to be compared.
     * @return Returns if fire pokemon is "smaller than", "equals to", or "bigger than" the other pokemon
     */
    @Override
    public int compareTo(PokemonType type) {
        if (type instanceof Water) {
            return -1;
        } else if (type instanceof Fire) {
            return 0;
        } else {
            return 1;
        }
    }
}
