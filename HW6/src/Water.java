/**
 * Water type class.
 * @author Jessie Xu
 * @version 1.0
 */
public class Water implements PokemonType {
    /**
     * Overriding method that returns class name Water.
     * @return Returns class name
     */
    @Override
    public String type() {
        return this.getClass().getName();
    }

    /**
     * Method that compares type water with other pokemon types.
     * @param type The object to be compared.
     * @return Returns if water pokemon is "equals to" or "bigger than" the other pokemon
     */
    @Override
    public int compareTo(PokemonType type) {
        if (type instanceof Water) {
            return 0;
        } else if (type instanceof Fire) {
            return 1;
        } else {
            return 1;
        }
    }
}
