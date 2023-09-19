/**
 * Grass type class.
 * @author Jessie Xu
 * @version 1.0
 */
public class Grass implements PokemonType {
    /**
     * Overriding method that returns class name Grass.
     * @return Returns class name
     */
    @Override
    public String type() {
        return this.getClass().getName();
    }

    /**
     * Method that compares type grass with other pokemon types.
     * @param type The object to be compared.
     * @return Returns if grass pokemon is "smaller than" or "equals to" the other pokemon
     */
    @Override
    public int compareTo(PokemonType type) {
        if (type instanceof Water) {
            return -1;
        } else if (type instanceof Fire) {
            return -1;
        } else {
            return 0;
        }
    }
}
